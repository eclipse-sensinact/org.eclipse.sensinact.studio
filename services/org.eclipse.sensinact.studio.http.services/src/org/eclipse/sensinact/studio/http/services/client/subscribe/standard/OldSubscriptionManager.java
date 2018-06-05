/**
 * Copyright (c) 2018 CEA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     CEA - initial API and implementation and/or initial documentation
 */
package org.eclipse.sensinact.studio.http.services.client.subscribe.standard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.sensinact.studio.http.messages.snamessage.MsgSensinact;
import org.eclipse.sensinact.studio.http.messages.snamessage.subscriberesponse.MsgSubscribeResponse;
import org.eclipse.sensinact.studio.http.services.client.GatewayHttpClient;
import org.eclipse.sensinact.studio.model.resource.utils.JsonUtil;
import org.eclipse.sensinact.studio.model.resource.utils.ResourceDescriptor;
import org.eclipse.sensinact.studio.model.resource.utils.Segments;
import org.eclipse.sensinact.studio.preferences.ConfigurationListerner;
import org.eclipse.sensinact.studio.preferences.ConfigurationManager;
import org.eclipse.sensinact.studio.preferences.GatewayHttpConfig;
import org.eclipse.sensinact.studio.preferences.StudioHttpConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.data.Status;

import org.eclipse.sensinact.studio.resource.AccessMethodType;

/**
 * @author Etienne Gandrille
 */
public class OldSubscriptionManager implements ConfigurationListerner {

	public static final String PATH = "/callback/old";
	
	private static final Logger logger = Logger.getLogger(OldSubscriptionManager.class);

	private static OldSubscriptionManager INSTANCE = null;

	private final Map<String, ResourceDescriptor> id2resource = new HashMap<String, ResourceDescriptor>();
	private final Map<ResourceDescriptor, Set<OldSubscriptionListener>> resource2listeners = new HashMap<ResourceDescriptor, Set<OldSubscriptionListener>>();

	private OldSubscriptionManager() {
		ConfigurationManager.addListener(this);
	}

	public static OldSubscriptionManager getInstance() {
		if (INSTANCE == null)
			INSTANCE = new OldSubscriptionManager();
		return INSTANCE;
	}

	private String generateSubscriptionID(ResourceDescriptor resource){
		return resource.toString()+"-"+System.currentTimeMillis();
	}
	
	public String subscribeResource(ResourceDescriptor resource, OldSubscriptionListener listener) throws IOException {

		if (resource2listeners.get(resource) == null)
			resource2listeners.put(resource, new HashSet<OldSubscriptionListener>());
		resource2listeners.get(resource).add(listener);

		String subsId = getSubscriptionId(resource);
		
		if (subsId == null) {
			try {
				subsId = subscribeResourceInternal(resource);	
			} catch(IOException e) {
				subsId = generateSubscriptionID(resource);
			} finally {
				id2resource.put(subsId, resource);
			}
		}

		return subsId;
	}

	public void unsubscribeResource(ResourceDescriptor resource, OldSubscriptionListener listener) throws IOException {
		Set<OldSubscriptionListener> listeners = resource2listeners.get(resource);

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

	public boolean hasSubscribeResource(ResourceDescriptor resource, OldSubscriptionListener listener) {
		Set<OldSubscriptionListener> listeners = resource2listeners.get(resource);
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
	
	public Status callbackRecieved(String subscriptionId, List<MsgSensinact> messages) {
		ResourceDescriptor resource = id2resource.get(subscriptionId);
	
		// Subscription found
		if (resource != null) {
			for (MsgSensinact message : messages) {
				for (OldSubscriptionListener listener : resource2listeners.get(resource)) {
					listener.onEvent(message, resource);
				}
			}
			return Status.SUCCESS_OK;
		} else {
			// Subscription NOT found
			logger.error("SubscriptionManager::callbackRecieved Unknown subscription ID " + subscriptionId);
			return Status.CLIENT_ERROR_NOT_FOUND; // error 404
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (String id : id2resource.keySet()) {
			ResourceDescriptor resource = id2resource.get(id);
			sb.append(id + " - " + resource + "\n");
			for (OldSubscriptionListener listener : resource2listeners.get(resource)) {
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
		
		GatewayHttpConfig gateway = ConfigurationManager.getGateway(resource.getGateway()); 
		int port = ConfigurationManager.getStudioPort();
		StudioHttpConfig studioConfig = new StudioHttpConfig(gateway, port);
		
		// URL
		String url = studioConfig.getUrl().toString();
		if (url == null || url.isEmpty())
			throw new IOException("URL is not valid - subscribtion fail");		
		url += PATH;
		
		// Json Object
		JSONArray jsonArray = createMessageAsJsonArray("callback", "string", url);
		
		Segments segment = new Segments.Builder().resource(resource).method(AccessMethodType.SUBSCRIBE).build();
		logger.debug("Sending subscribe for resource " + segment + " with callback " + url);
	
		MsgSensinact response = GatewayHttpClient.sendPostRequest(segment, jsonArray);
		
		if (response instanceof MsgSubscribeResponse) {
			MsgSubscribeResponse objectResponse = (MsgSubscribeResponse) response;
			String id = objectResponse.getResponse().getSubscriptionId();
			logger.debug("Recieved subscription id: " + id);
			return id;
		} else {
			String msg = "Subscribe fails for resource " + resource;
			logger.error(msg);
			throw new IOException(msg);
		}
	}

	private static void unsubscribeResourceInternal(ResourceDescriptor resource, String subsId) throws IOException {
		JSONArray jsonArray = createMessageAsJsonArray("subscriptionId", "string", subsId);
		Segments segments = new Segments.Builder().resource(resource).method(AccessMethodType.UNSUBSCRIBE).build();
		logger.debug("Sending unsubscribe for resource " + segments);
		GatewayHttpClient.sendPostRequest(segments, jsonArray);
	}
	
	private static JSONArray createMessageAsJsonArray(String name, String type, Object value) {
		JSONArray jsonArray = new JSONArray();
		try {
			JSONObject jsonObject = JsonUtil.createNameTypeValue(name, type, value);
			jsonArray.put(jsonObject);
		} catch (JSONException e) {
			logger.error("Should never happend");
		}
		return jsonArray;
	}
}
