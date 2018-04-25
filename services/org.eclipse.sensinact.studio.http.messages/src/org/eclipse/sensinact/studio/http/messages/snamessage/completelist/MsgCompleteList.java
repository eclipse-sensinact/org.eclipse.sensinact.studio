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
package org.eclipse.sensinact.studio.http.messages.snamessage.completelist;

import java.util.List;

import org.eclipse.sensinact.studio.http.messages.snamessage.MsgSensinact;

/**
 * @author Etienne Gandrille
 */
public class MsgCompleteList extends MsgSensinact {

	public static final String KEY = "COMPLETE_LIST";

	private List<ObjectProvider> providers;
	private String uri;
	private int statusCode;
	
	public MsgCompleteList() {
		super(KEY);
	}
	
	public List<ObjectProvider> getProviders() {
		return providers;
	}
	
	public ObjectProvider getProvider(String providerName) {
		for (ObjectProvider provider : providers)
			if (provider.getName().equals(providerName))
				return provider;
		return null;
	}
	
	
	public void setProviders(List<ObjectProvider> providers) {
		this.providers = providers;
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
		result = prime * result + ((providers == null) ? 0 : providers.hashCode());
		result = prime * result + statusCode;
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
		MsgCompleteList other = (MsgCompleteList) obj;
		if (providers == null) {
			if (other.providers != null)
				return false;
		} else if (!providers.equals(other.providers))
			return false;
		if (statusCode != other.statusCode)
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
		return "MsgCompleteList [providers=" + providers + ", uri=" + uri + ", statusCode=" + statusCode + "]";
	}
}
