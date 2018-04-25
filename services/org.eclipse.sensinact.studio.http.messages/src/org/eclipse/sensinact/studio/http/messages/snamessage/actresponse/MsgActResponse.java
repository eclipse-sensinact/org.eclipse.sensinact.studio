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
package org.eclipse.sensinact.studio.http.messages.snamessage.actresponse;

import java.util.List;

import org.eclipse.sensinact.studio.http.messages.snamessage.MsgSensinact;
import org.eclipse.sensinact.studio.http.messages.snamessage.ObjectNameTypeValue;

/**
 * @author Etienne Gandrille
 */
public class MsgActResponse extends MsgSensinact {

	public static final String KEY = "ACT_RESPONSE";
	
	private List<ObjectNameTypeValue> triggered;
	private ObjectResponse response;
	private String uri;
	private int statusCode;
	
	public MsgActResponse() {
		super(KEY);
	}

	public List<ObjectNameTypeValue> getTriggered() {
		return triggered;
	}

	public void setTriggered(List<ObjectNameTypeValue> triggered) {
		this.triggered = triggered;
	}

	public ObjectResponse getResponse() {
		return response;
	}

	public void setResponse(ObjectResponse response) {
		this.response = response;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((response == null) ? 0 : response.hashCode());
		result = prime * result + statusCode;
		result = prime * result + ((triggered == null) ? 0 : triggered.hashCode());
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
		MsgActResponse other = (MsgActResponse) obj;
		if (response == null) {
			if (other.response != null)
				return false;
		} else if (!response.equals(other.response))
			return false;
		if (statusCode != other.statusCode)
			return false;
		if (triggered == null) {
			if (other.triggered != null)
				return false;
		} else if (!triggered.equals(other.triggered))
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
		return "MsgActResponse [triggered=" + triggered + ", response=" + response + ", uri=" + uri + ", statusCode="
				+ statusCode + "]";
	}
}