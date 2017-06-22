/**
 * Copyright (c) 2017 CEA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     CEA - initial API and implementation and/or initial documentation
 */
package org.eclipse.sensinact.studio.model.manager.listener.subscription;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.sensinact.studio.http.client.GatewayHttpClient;
import org.eclipse.sensinact.studio.http.client.snamessage.SnaMessage;
import org.eclipse.sensinact.studio.http.client.snamessage.SnaMessageFactory;
import org.eclipse.sensinact.studio.http.client.snamessage.gateway.ResponseSubscribe;
import org.eclipse.sensinact.studio.model.resource.utils.ResourceDescriptor;
import org.eclipse.sensinact.studio.model.resource.utils.Segments;
import org.eclipse.sensinact.studio.preferences.ConfigurationListerner;
import org.eclipse.sensinact.studio.preferences.ConfigurationManager;
import org.eclipse.sensinact.studio.preferences.GatewayHttpConfig;
import org.eclipse.sensinact.studio.preferences.StudioHttpConfig;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.data.Status;

import org.eclipse.sensinact.studio.resource.AccessMethodType;

/**
 * @author Etienne Gandrille
 */
public class SubscriptionManager implements ConfigurationListerner {

	private static final Logger logger = Logger.getLogger(SubscriptionManager.class);

	private static SubscriptionManager INSTANCE = null;

	private final Map<String, ResourceDescriptor> id2resource = new HashMap<String, ResourceDescriptor>();
	private final Map<ResourceDescriptor, Set<SubscriptionListener>> resource2listeners = new HashMap<ResourceDescriptor, Set<SubscriptionListener>>();

	private SubscriptionManager() {
		ConfigurationManager.addListener(this);
	}

	public static SubscriptionManager getInstance() {
		if (INSTANCE == null)
			INSTANCE = new SubscriptionManager();
		return INSTANCE;
	}

	private String generateSubscriptionID(ResourceDescriptor resource){
		return resource.toString()+"-"+System.currentTimeMillis();
	}
	
	public String subscribeResource(ResourceDescriptor resource, SubscriptionListener listener) throws IOException {

		if (resource2listeners.get(resource) == null)
			resource2listeners.put(resource, new HashSet<SubscriptionListener>());
		resource2listeners.get(resource).add(listener);

		String subsId = getSubscriptionId(resource);
		
		if (subsId == null) {

			try {
				subsId = subscribeResourceInternal(resource);	
			}catch(IOException e){
				subsId = generateSubscriptionID(resource);
			}finally {
				id2resource.put(subsId, resource);
			}
			
		}

		return subsId;
	}

	public void unsubscribeResource(ResourceDescriptor resource, SubscriptionListener listener) throws IOException {
		Set<SubscriptionListener> listeners = resource2listeners.get(resource);

		if (listeners != null) {
			listeners.remove(listener);
			if (listeners.isEmpty()) {
				resource2listeners.remove(resource);
				String subsId = getSubscriptionId(resource);
				if (subsId != null) {
					id2resource.remove(subsId);
					unsubscribeResourceInternal(resource, subsId);
				}
			}
		}
	}

	public boolean hasSubscribeResource(ResourceDescriptor resource, SubscriptionListener listener) {
		Set<SubscriptionListener> listeners = resource2listeners.get(resource);
		if (listeners != null) {
			if (listeners.contains(listener)) {
				return true;
			}
		}
		return false;
	}

	public List<String> getSubscriptionIDFromResourceURI(String eventURI){
		
		List<String> subscriptions=new ArrayList<String>();
		
		for(Map.Entry<String, ResourceDescriptor> entry:id2resource.entrySet()){
			ResourceDescriptor resourceDescription=entry.getValue();
			System.out.println("Key:"+entry.getKey().toString()+" Value:"+entry.getValue().toString());
			String uriBuilt="/" + resourceDescription.getDevice() + "/" + resourceDescription.getService() + "/" + resourceDescription.getResource()+"/value";
			if(uriBuilt.equals(eventURI)){
				subscriptions.add(entry.getKey());
			}
		}
		
		return subscriptions;
	}
	
	public Status callbackRecieved(String content, String subscriptionId) {
		ResourceDescriptor resource = id2resource.get(subscriptionId);

		System.out.println("Subscription ID "+subscriptionId+" Content "+content);
		
		for(Map.Entry<String, ResourceDescriptor> entry:id2resource.entrySet()){
			System.out.println("Signal: key"+entry.getKey()+" value:"+entry.getValue().toString());
		}
		
		if (resource != null) {
			Set<SubscriptionListener> listeners = resource2listeners.get(resource);

			SnaMessage response = null;
			if (content != null) {
				try {
					response = SnaMessageFactory.build(resource.getGateway(), new JSONObject(content));
				} catch (JSONException e) {
					throw new IllegalArgumentException(content);
				}
			}
			if (listeners != null) {
				Iterator<SubscriptionListener> iterator = listeners.iterator();
				while (iterator.hasNext()) {
					SubscriptionListener listener = iterator.next();
					listener.onEvent(response, resource);
				}
				return Status.SUCCESS_OK;
			}
		}
		
		logger.info("SubscriptionManager::callbackRecieved Unknown subscription ID " + subscriptionId);
		return Status.CLIENT_ERROR_NOT_FOUND; // error 404
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (String id : id2resource.keySet()) {
			ResourceDescriptor resource = id2resource.get(id);
			sb.append(id + " - " + resource + "\n");
			for (SubscriptionListener listener : resource2listeners.get(resource)) {
				sb.append(" * " + listener + "\n");
			}
		}

		for (ResourceDescriptor resource : resource2listeners.keySet())
			if (!id2resource.containsValue(resource))
				sb.append("[ERROR] No id for resource " + resource + "\n");

		return sb.toString();
	}

	/* ================================== */
	/* callbacks for configuration update */
	/* ================================== */

	@Override
	public void gatewayAddedOrUpdatedNotif(GatewayHttpConfig gateway) {
	}

	@Override
	public void gatewayRemovedNotif(String name) {
	}

	@Override
	public void studioPortUpdatedNotif(int port) {
		logger.info("SubscriptionManager::studioConfigUpdated");
		for (String id : id2resource.keySet()) {
			ResourceDescriptor resource = id2resource.remove(id);
			try {
				unsubscribeResourceInternal(resource, id);
			} catch (IOException e) {
				logger.error("Unsubscribe failed", e);
			}
			String newId;
			try {
				newId = subscribeResourceInternal(resource);
				id2resource.put(newId, resource);
			} catch (IOException e) {
				logger.error("Subscribe failed", e);
			}
		}
	}
	
	/* ======== */
	/* internal */
	/* ======== */

	public String getSubscriptionId(ResourceDescriptor resource) {
		for (String id : id2resource.keySet())
			if (id2resource.get(id).equals(resource))
				return id;
		return null;
	}

	private static String subscribeResourceInternal(ResourceDescriptor resource) throws IOException {
		JSONObject jsonObject = new JSONObject();

		System.out.println("Resource:"+resource.getDevice());
		
		GatewayHttpConfig gateway = ConfigurationManager.getGateway(resource.getGateway()); 
		int port = ConfigurationManager.getStudioPort();
		StudioHttpConfig studioConfig = new StudioHttpConfig(gateway, port);
		String url = studioConfig.getUrl().toString();
		
		//System.out.println("Studio URL:"+url);
		
		if (url == null || url.isEmpty())
			throw new IOException("URL is not valid - subscribtion fail");
		
		// TODO update this with a constant --> see also InitRoutes.java
		url += "/callback";
		
		//System.out.println("Studio callback:"+url);
		
		try {
			jsonObject.put("callback", url);
		} catch (JSONException e) {
			logger.error("Should never happend");
		}

		Segments segment = new Segments.Builder().resource(resource).method(AccessMethodType.SUBSCRIBE).build();
		System.out.println("Sending subscribe for resource " + segment + " with callback " + url);
		logger.debug("Sending subscribe for resource " + segment + " with callback " + url);
		SnaMessage response = GatewayHttpClient.sendPostRequest(segment, jsonObject);

		if (response.isValid()) {
			ResponseSubscribe objectResponse = (ResponseSubscribe) response;
			String id = objectResponse.getSubscriptionId();
			logger.debug("Recieved subscription id: " + id);
			return id;
		} else {
			String msg = "Subscribe fails for resource " + resource;
			logger.error(msg);
			throw new IOException(msg);
		}
	}

	private static void unsubscribeResourceInternal(ResourceDescriptor resource, String subsId) throws IOException {
		try {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("usid", subsId);

			Segments segments = new Segments.Builder().resource(resource).method(AccessMethodType.UNSUBSCRIBE).build();

			logger.debug("Sending unsubscribe for resource " + segments);
			GatewayHttpClient.sendPostRequest(segments, jsonObject);

		} catch (JSONException e) {
			String msg = "Unsubscribe fails for resource " + resource;
			logger.error(msg, e);
			throw new IOException(msg, e);
		}
	}
}
