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
package org.eclipse.sensinact.studio.http.messages.snamessage.subscriberesponse;

import java.util.Optional;

import org.eclipse.sensinact.studio.http.messages.snamessage.ObjectNameTypeValue;

/**
 * @author Etienne Gandrille
 */
public class ObjectResponse {
	private String subscriptionId;
	private Optional<ObjectNameTypeValue> initial = Optional.empty();
	
	public String getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(String subscriptionId) {
		this.subscriptionId = subscriptionId;
	}
	
	public Optional<ObjectNameTypeValue> getInitial() {
		return initial;
	}
	
	public void setInitial(ObjectNameTypeValue initial) {
		this.initial = Optional.of(initial);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((initial == null) ? 0 : initial.hashCode());
		result = prime * result + ((subscriptionId == null) ? 0 : subscriptionId.hashCode());
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
		ObjectResponse other = (ObjectResponse) obj;
		if (initial == null) {
			if (other.initial != null)
				return false;
		} else if (!initial.equals(other.initial))
			return false;
		if (subscriptionId == null) {
			if (other.subscriptionId != null)
				return false;
		} else if (!subscriptionId.equals(other.subscriptionId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ObjectResponse [subscriptionId=" + subscriptionId + ", initial=" + initial + "]";
	}	
}
