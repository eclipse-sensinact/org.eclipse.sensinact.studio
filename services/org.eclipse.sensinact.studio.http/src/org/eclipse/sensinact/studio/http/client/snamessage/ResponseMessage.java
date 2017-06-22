/**
 * Copyright (c) 2017 CEA.
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

	public ResponseMessage(JSONObject jsonObject) {
		super(jsonObject);
		try {
			statusCode = jsonObject.getInt("statusCode");
		} catch (JSONException e) {
			e.printStackTrace();
			statusCode = -1;
			//throw new IllegalArgumentException(this.getClass().getName() + " json malformed");
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
