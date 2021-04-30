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
package org.eclipse.sensinact.studio.http.messages.snamessage.serviceslist;

import java.util.List;

import org.eclipse.sensinact.studio.http.messages.snamessage.MsgCategory;
import org.eclipse.sensinact.studio.http.messages.snamessage.MsgSensinact;

/**
 * @author Etienne Gandrille
 */
public class MsgServicesList extends MsgSensinact {
	
	public static final String KEY = "SERVICES_LIST";
	
	private String uri;
	private int statusCode;
	private List<String> services;
	
	public MsgServicesList() {
		super(KEY);
	}

	@Override
	public MsgCategory getCategory() {
		return MsgCategory.OTHER;
	}
	
	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public List<String> getServices() {
		return services;
	}

	public void setServices(List<String> services) {
		this.services = services;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((services == null) ? 0 : services.hashCode());
		result = prime * result + statusCode;
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
		MsgServicesList other = (MsgServicesList) obj;
		if (services == null) {
			if (other.services != null)
				return false;
		} else if (!services.equals(other.services))
			return false;
		if (statusCode != other.statusCode)
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
		return "MsgServicesList [type=" + type + ", uri=" + uri + ", statusCode=" + statusCode + ", services="
				+ services + "]";
	}	
}
