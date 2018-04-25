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
package org.eclipse.sensinact.studio.http.messages.snamessage.tokencreation;

import org.eclipse.sensinact.studio.http.messages.snamessage.MsgSensinact;

/**
 * @author Etienne Gandrille
 */
public class MsgTokenCreation extends MsgSensinact {

	public static final String KEY = "TOKEN_CREATION";
	
	private long generated;
	private long validUntil;
	private String uri;
	private String token;
	
	public MsgTokenCreation() {
		super(KEY);
	}
	
	public long getGenerated() {
		return generated;
	}
	
	public void setGenerated(long generated) {
		this.generated = generated;
	}
	
	public long getValidUntil() {
		return validUntil;
	}
	
	public void setValidUntil(long validUntil) {
		this.validUntil = validUntil;
	}
	
	public String getUri() {
		return uri;
	}
	
	public void setUri(String uri) {
		this.uri = uri;
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (generated ^ (generated >>> 32));
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		result = prime * result + ((uri == null) ? 0 : uri.hashCode());
		result = prime * result + (int) (validUntil ^ (validUntil >>> 32));
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
		MsgTokenCreation other = (MsgTokenCreation) obj;
		if (generated != other.generated)
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		if (uri == null) {
			if (other.uri != null)
				return false;
		} else if (!uri.equals(other.uri))
			return false;
		if (validUntil != other.validUntil)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "MsgTokenCreation [generated=" + generated + ", validUntil=" + validUntil + ", uri=" + uri + ", token="
				+ token + "]";
	}
}
