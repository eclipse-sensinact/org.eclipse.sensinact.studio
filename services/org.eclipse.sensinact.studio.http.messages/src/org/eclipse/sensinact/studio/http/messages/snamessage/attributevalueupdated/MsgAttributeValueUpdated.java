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
package org.eclipse.sensinact.studio.http.messages.snamessage.attributevalueupdated;


import org.eclipse.sensinact.studio.http.messages.snamessage.MsgSensinact;
import org.eclipse.sensinact.studio.http.messages.snamessage.ObjectNameTypeValue;

/**
 * @author Etienne Gandrille
 */
public class MsgAttributeValueUpdated extends MsgSensinact {

	public static final String KEY = "ATTRIBUTE_VALUE_UPDATED";

	private ObjectNameTypeValue notification;
	private String uri;
	
	public MsgAttributeValueUpdated() {
		super(KEY);
	}

	public ObjectNameTypeValue getNotification() {
		return notification;
	}

	public void setNotification(ObjectNameTypeValue notification) {
		this.notification = notification;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((notification == null) ? 0 : notification.hashCode());
		result = prime * result + ((uri == null) ? 0 : uri.hashCode());
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
		MsgAttributeValueUpdated other = (MsgAttributeValueUpdated) obj;
		if (notification == null) {
			if (other.notification != null)
				return false;
		} else if (!notification.equals(other.notification))
			return false;
		if (uri == null) {
			if (other.uri != null)
				return false;
		} else if (!uri.equals(other.uri))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MsgAttributeValueUpdated [notification=" + notification + ", uri=" + uri + "]";
	}	
}
