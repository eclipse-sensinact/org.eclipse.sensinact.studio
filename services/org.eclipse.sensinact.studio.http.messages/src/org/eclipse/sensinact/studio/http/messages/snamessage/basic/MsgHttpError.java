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
package org.eclipse.sensinact.studio.http.messages.snamessage.basic;

import org.json.JSONObject;

/**
 * @author Etienne Gandrille
 */
public class MsgHttpError extends MsgError {

	private final int code;
	private final JSONObject jsonObject;
	
	public MsgHttpError(int code, JSONObject jsonObject) {
		this.code = code;
		this.jsonObject = jsonObject;
	}
	
	public int getCode() {
		return code;
	}
	
	public JSONObject getJsonObject() {
		return jsonObject;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + code;
		result = prime * result + ((jsonObject == null) ? 0 : jsonObject.hashCode());
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
		MsgHttpError other = (MsgHttpError) obj;
		if (code != other.code)
			return false;
		if (jsonObject == null) {
			if (other.jsonObject != null)
				return false;
		} else if (!jsonObject.equals(other.jsonObject))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MsgHttpError [code=" + code + ", jsonObject=" + jsonObject + "]";
	}
}
