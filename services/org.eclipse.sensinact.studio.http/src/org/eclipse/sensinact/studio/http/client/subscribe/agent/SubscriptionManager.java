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
package org.eclipse.sensinact.studio.http.client.subscribe.agent;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.sensinact.studio.http.client.snamessage.MsgSensinact;

/**
 * @author Etienne Gandrille
 */
public class SubscriptionManager {

	private static SubscriptionManager INSTANCE = null;
	List<SubscriptionListener> listeners = new ArrayList<SubscriptionListener>();	
	
	public static SubscriptionManager getInstance() {
		if (INSTANCE == null)
			INSTANCE = new SubscriptionManager();
		return INSTANCE;
	}
	
	public SubscriptionManager() {
	}

	public void subscribe(SubscriptionListener listener) {
		listeners.add(listener);
	}
	
	public void unsubscribe(SubscriptionListener listener) {
		listeners.remove(listener);
	}
	
	void notifyLocation(String gateway, List<MsgSensinact> message) {
		for (SubscriptionListener listener : listeners)
			listener.onLocationEvent(gateway, message);
	}
	
	void notifyLifecycle(String gateway, List<MsgSensinact> message) {
		for (SubscriptionListener listener : listeners)
			listener.onLifecycleEvent(gateway, message);
	}
}
