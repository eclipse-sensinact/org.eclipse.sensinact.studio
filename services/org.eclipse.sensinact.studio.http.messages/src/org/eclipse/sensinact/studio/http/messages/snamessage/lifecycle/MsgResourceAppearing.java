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
package org.eclipse.sensinact.studio.http.messages.snamessage.lifecycle;

import org.eclipse.sensinact.studio.http.messages.snamessage.MsgSensinact;
import org.eclipse.sensinact.studio.http.messages.snamessage.ObjectNameTypeValue;

/**
 * @author Etienne Gandrille
 */
public class MsgResourceAppearing extends MsgSensinact {

	public static final String KEY = "RESOURCE_APPEARING";
	
	private String type;
	private String uri;
	private ObjectNotificationWithType notification;
	private ObjectNameTypeValue initial;
	
	public MsgResourceAppearing() {
		super(KEY);
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public ObjectNotificationWithType getNotification() {
		return notification;
	}

	public void setNotification(ObjectNotificationWithType notification) {
		this.notification = notification;
	}
	
	public ObjectNameTypeValue getInitial() {
		return initial;
	}
	
	public void setInitial(ObjectNameTypeValue initial) {
		this.initial = initial;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((initial == null) ? 0 : initial.hashCode());
		result = prime * result + ((notification == null) ? 0 : notification.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		MsgResourceAppearing other = (MsgResourceAppearing) obj;
		if (initial == null) {
			if (other.initial != null)
				return false;
		} else if (!initial.equals(other.initial))
			return false;
		if (notification == null) {
			if (other.notification != null)
				return false;
		} else if (!notification.equals(other.notification))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
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
		return "MsgResourceAppearing [type=" + type + ", uri=" + uri + ", notification=" + notification + ", initial="
				+ initial + "]";
	}
}
