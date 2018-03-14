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
package org.eclipse.sensinact.studio.http.client.snamessage;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author nj246216
 */
public class ResponseMessage extends SnaMessage {

	private int statusCode;

	public ResponseMessage(JSONObject json, String type, String uri) {
		super(json, type, uri);
		statusCode = getStatusCode(json);
	}
	
	public ResponseMessage(JSONObject json) {
		super(json);
		statusCode = getStatusCode(json);
	}

	private static int getStatusCode(JSONObject json) {
		try {
			return json.getInt("statusCode");
		} catch (JSONException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public int getStatusCode() {
		return statusCode;
	}
	
	@Override
	public boolean isValid() {
		return statusCode == 200;
	}
	
	@Override
	public String getPrettyPrintedValue() {
		return getUri() + " (" + statusCode + ")";
	}
	
}
