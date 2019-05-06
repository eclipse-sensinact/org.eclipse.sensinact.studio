/**
 * Copyright (c) 2019 CEA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     CEA - initial API and implementation and/or initial documentation
 */
package org.eclipse.sensinact.studio.http.services.client.connectionmanager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.sensinact.studio.http.messages.snamessage.MsgCategory;
import org.eclipse.sensinact.studio.http.messages.snamessage.MsgFactory;
import org.eclipse.sensinact.studio.http.messages.snamessage.MsgSensinact;
import org.eclipse.sensinact.studio.http.messages.snamessage.attributevalueupdated.MsgAttributeValueUpdated;
import org.json.JSONArray;
import org.json.JSONObject;

public class NotifDispatcher {

	private static NotifDispatcher INSTANCE = null;

	private Set<NotifSubscriptionListener> notifSublisteners = new HashSet<>();
	
	private Set<ConnectionListener> conlisteners = new HashSet<>();

	private static final Logger logger = Logger.getLogger(NotifDispatcher.class);

	public synchronized static NotifDispatcher getInstance() {
		if (INSTANCE == null)
			INSTANCE = new NotifDispatcher();
		return INSTANCE;
	}

	private NotifDispatcher() {
	}

	public void subscribe(NotifSubscriptionListener listener) {
		notifSublisteners.add(listener);
	}

	public void unsubscribe(NotifSubscriptionListener listener) {
		notifSublisteners.remove(listener);
	}

	public void subscribe(ConnectionListener listener) {
		conlisteners.add(listener);
	}

	public void unsubscribe(ConnectionListener listener) {
		conlisteners.remove(listener);
	}
		
	void notifyMessage(String gatewayName, String msg) {
		System.out.println("Message " + msg);

		List<MsgSensinact> lifecycleMsgs = new ArrayList<>();
		List<MsgSensinact> valueMsgs = new ArrayList<>();
		List<MsgSensinact> locationMsgs = new ArrayList<>();
		List<MsgSensinact> otherMsgs = new ArrayList<>();

		try {
			JSONObject jsonObject = new JSONObject(msg);
			if ("CALLBACK".equals(jsonObject.optString("type"))) {
				JSONArray array = jsonObject.getJSONArray("messages");
				for (int i = 0; i < array.length(); i++) {
					JSONObject jsonMsg = array.getJSONObject(i);
					MsgSensinact message = MsgFactory.build(jsonMsg, 200);

					if (message.getCategory() == MsgCategory.LIFECYCLE) {
						lifecycleMsgs.add(message);
					} else if (message.getCategory() == MsgCategory.VALUE) {
						if (message instanceof MsgAttributeValueUpdated) {
							if (((MsgAttributeValueUpdated) message).isLocationValue()) {
								locationMsgs.add(message);
							}
						}
						valueMsgs.add(message);
					} else {
						otherMsgs.add(message);
					}
				}
			}
		} catch (Exception e) {
			logger.error(e);
		}

		if (lifecycleMsgs.size() != 0)
			notifyLifecycle(gatewayName, lifecycleMsgs);

		if (locationMsgs.size() != 0)
			notifyLocation(gatewayName, locationMsgs);
		
		if (valueMsgs.size() != 0)
			notifyValue(gatewayName, valueMsgs);
	}

	void notifyGatewayConnected(String gatewayName) {
		for (ConnectionListener listener : conlisteners)
			listener.onConnect(gatewayName);
	}

	void notifyGatewayDisconnected(String gatewayName) {
		for (ConnectionListener listener : conlisteners)
			listener.onDisconnect(gatewayName);
	}

	private void notifyLocation(String gateway, List<MsgSensinact> message) {
		for (NotifSubscriptionListener listener : notifSublisteners)
			listener.onLocationEvent(gateway, message);
	}

	private void notifyLifecycle(String gateway, List<MsgSensinact> message) {
		for (NotifSubscriptionListener listener : notifSublisteners)
			listener.onLifecycleEvent(gateway, message);
	}
	
	private void notifyValue(String gateway, List<MsgSensinact> message) {
		for (NotifSubscriptionListener listener : notifSublisteners)
			listener.onValueEvent(gateway, message);
	}
}
