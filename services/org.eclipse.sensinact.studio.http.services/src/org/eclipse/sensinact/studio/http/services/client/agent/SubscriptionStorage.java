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
package org.eclipse.sensinact.studio.http.services.client.agent;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Etienne Gandrille
 */
public class SubscriptionStorage {
		
	private final Map<String, Subscription> byGatway = new HashMap<String, Subscription>();
	private final Map<String, Subscription> byLocation = new HashMap<String, Subscription>();
	private final Map<String, Subscription> byLifecycle = new HashMap<String, Subscription>();
	private final Map<String, Subscription> byIcon = new HashMap<String, Subscription>();
	
	void add(Subscription subscription) {
		byGatway.put(subscription.getGatewayName(), subscription);
		byLocation.put(subscription.getLocationId(), subscription);
		byLifecycle.put(subscription.getLifecycleId(), subscription);
		byIcon.put(subscription.getIconId(), subscription);
	}
	
	void remove(Subscription subscription) {
		byGatway.remove(subscription.getGatewayName());
		byLocation.remove(subscription.getLocationId());
		byLifecycle.remove(subscription.getLifecycleId());
		byIcon.remove(subscription.getIconId());
	}
	
	public Subscription getByGateway(String gateway) {
		return byGatway.get(gateway);
	}
	
	public Subscription getByLocationId(String locationId) {
		return byLocation.get(locationId);
	}

	public Subscription getByLifecycleId(String lifecycleId) {
		return byLifecycle.get(lifecycleId);
	}
	
	public Subscription getByIconId(String iconId) {
		return byIcon.get(iconId);
	}
}
