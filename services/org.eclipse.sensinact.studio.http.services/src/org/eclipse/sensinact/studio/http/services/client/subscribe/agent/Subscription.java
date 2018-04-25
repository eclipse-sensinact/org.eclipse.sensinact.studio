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

/**
 * @author Etienne Gandrille
 */
public class Subscription {
	
	private final String gatewayName;
	private final String locationId;
	private final String lifecycleId;

	public Subscription(String gatewayName, String locationId, String lifecycleId) {
		this.gatewayName = gatewayName;
		this.locationId = locationId;
		this.lifecycleId = lifecycleId;
	}

	public String getGatewayName() {
		return gatewayName;
	}

	public String getLocationId() {
		return locationId;
	}

	public String getLifecycleId() {
		return lifecycleId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gatewayName == null) ? 0 : gatewayName.hashCode());
		result = prime * result + ((lifecycleId == null) ? 0 : lifecycleId.hashCode());
		result = prime * result + ((locationId == null) ? 0 : locationId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subscription other = (Subscription) obj;
		if (gatewayName == null) {
			if (other.gatewayName != null)
				return false;
		} else if (!gatewayName.equals(other.gatewayName))
			return false;
		if (lifecycleId == null) {
			if (other.lifecycleId != null)
				return false;
		} else if (!lifecycleId.equals(other.lifecycleId))
			return false;
		if (locationId == null) {
			if (other.locationId != null)
				return false;
		} else if (!locationId.equals(other.locationId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Subscription [gatewayName=" + gatewayName + ", locationId=" + locationId + ", lifecycleId="
				+ lifecycleId + "]";
	}
}
