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
package org.eclipse.sensinact.studio.http.services.client.subscribe.agent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.sensinact.studio.http.messages.snamessage.MsgSensinact;
import org.eclipse.sensinact.studio.http.messages.snamessage.subscriberesponse.MsgSubscribeResponse;
import org.eclipse.sensinact.studio.http.services.client.GatewayHttpClient;
import org.eclipse.sensinact.studio.model.resource.utils.Segments;
import org.eclipse.sensinact.studio.preferences.ConfigurationManager;
import org.eclipse.sensinact.studio.preferences.GatewayHttpConfig;
import org.eclipse.sensinact.studio.preferences.StudioHttpConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.data.Status;

/**
 * @author Etienne Gandrille
 */
public class Agent {

	private static Agent INSTANCE = null;
	
	public static final String PATH = "/callback/new";

	private SubscriptionStorage storage = new SubscriptionStorage();
	
	private List<AgentSubscriptionListener> listeners = new ArrayList<AgentSubscriptionListener>();
	
	private Agent() {
	}
	
	public static Agent getInstance() {
		if (INSTANCE == null)
			INSTANCE = new Agent();
		return INSTANCE;
	}
	
	public void subscribe(GatewayHttpConfig gateway) throws JSONException, IOException {
		
		String gatewayName = gateway.getName();
		Segments segments = new Segments.BuilderGateway(gatewayName).subscribeAgent().build();
		String url = getCallbackUrl(gateway);
		
		String locId = getId(GatewayHttpClient.sendPostRequest(segments, createJsonForLocation(url)), url);
		String lcId = getId(GatewayHttpClient.sendPostRequest(segments, createJsonForLifecycle(url)), url);

		storage.add(new Subscription(gatewayName, locId, lcId));
	}

	public void unsubscribe(GatewayHttpConfig gateway) throws IOException, JSONException {
		
		String gatewayName = gateway.getName();
		Segments segments = new Segments.BuilderGateway(gatewayName).unsubscribeAgent().build();

		Subscription subscription = storage.getByGateway(gateway.getName());
		if (subscription == null) {
			throw new IllegalArgumentException("Can't get subscription for " + gatewayName);
		}

		GatewayHttpClient.sendPostRequest(segments, createJsonForUnscubscribe(subscription.getLocationId()));
		GatewayHttpClient.sendPostRequest(segments, createJsonForUnscubscribe(subscription.getLifecycleId()));
		
		storage.remove(subscription);
	}
	
	private static String getId(MsgSensinact msg, String url) {
		if (msg instanceof MsgSubscribeResponse)
			return ((MsgSubscribeResponse) msg).getResponse().getSubscriptionId();
		throw new IllegalArgumentException("Can't get subscription on " + url);
	}
		
	private static String getCallbackUrl(GatewayHttpConfig gateway) throws IOException {
		int port = ConfigurationManager.getStudioPort();
		StudioHttpConfig studioConfig = new StudioHttpConfig(gateway, port);
		String url = studioConfig.getUrl().toString();
		if (url == null || url.isEmpty())
			throw new IOException("URL is not valid - subscribtion fail");
		url += PATH;
		return url;
	}
	
	private static JSONArray createJsonForLocation(String url) throws JSONException {
		return createJson(url, "/[^/]+/admin/location(/[^/]+)?", "UPDATE");
	}
	
	private static JSONArray createJsonForLifecycle(String url) throws JSONException {
		return createJson(url, "(/[^/]+)+", "LIFECYCLE");
	}
	
	private static JSONArray createJsonForUnscubscribe(String subscriptionid) throws JSONException {
		JSONArray array = new JSONArray();
		array.put(nameTypeValue("subscriptionid", "string", subscriptionid));
		return array;
	}
	
	private static JSONArray createJson(String url, String sender, String type) throws JSONException {
		JSONArray array = new JSONArray();
		array.put(nameTypeValue("sender",     "string",  sender));
		array.put(nameTypeValue("pattern",    "boolean", "true"));
		array.put(nameTypeValue("complement", "boolean", "false"));
		array.put(nameTypeValue("types",      "array",   "[\"" + type + "\"]"));
		array.put(nameTypeValue("callback",   "string",  url));
		return array;
	}
	
	private static JSONObject nameTypeValue(String name, String type, String value) throws JSONException {
		JSONObject retval = new JSONObject();
		retval.put("name", name);
		retval.put("type", type);
		retval.put("value", value);
		return retval;
	}

	public boolean isConnected(String name) {
		return (storage.getByGateway(name) != null);
	}

	public Status callbackRecieved(String id, List<MsgSensinact> messages) {
		
		Subscription lifeSub = storage.getByLifecycleId(id);
		Subscription locSub = storage.getByLocationId(id);
		
		if (lifeSub != null) {
			String gateway = lifeSub.getGatewayName();
			notifyLifecycle(gateway, messages);			
			return Status.SUCCESS_OK;	
		}
		
		if (locSub != null) {
			String gateway = locSub.getGatewayName();
			notifyLocation(gateway, messages);
			return Status.SUCCESS_OK;	
		}

		return  Status.CLIENT_ERROR_NOT_FOUND;				
	}
	
	/* ======================= */
	/* SUBSCRIPTION MANAGEMENT */
	/* ======================= */
	
	public void subscribe(AgentSubscriptionListener listener) {
		listeners.add(listener);
	}
	
	public void unsubscribe(AgentSubscriptionListener listener) {
		listeners.remove(listener);
	}
	
	void notifyLocation(String gateway, List<MsgSensinact> message) {
		for (AgentSubscriptionListener listener : listeners)
			listener.onLocationEvent(gateway, message);
	}
	
	void notifyLifecycle(String gateway, List<MsgSensinact> message) {
		for (AgentSubscriptionListener listener : listeners)
			listener.onLifecycleEvent(gateway, message);
	}
}
