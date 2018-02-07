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
package org.eclipse.sensinact.studio.http.client.snamessage.gateway;

import org.eclipse.sensinact.studio.http.client.snamessage.ResponseGetError;
import org.eclipse.sensinact.studio.http.client.snamessage.ResponseGetOK;
import org.eclipse.sensinact.studio.http.client.snamessage.ResponseKO;
import org.eclipse.sensinact.studio.http.client.snamessage.ResponseMessage;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Etienne Gandrille
 */
public abstract class ResponseGet extends ResponseMessage {

	public static final String KEY = "GET_RESPONSE";
	
	public static ResponseGet build(JSONObject jsonObject) {
		try {
			int statusCode = jsonObject.getInt("statusCode");
			if (statusCode == 200)
				return new ResponseGetOK(jsonObject);
			else
				return new ResponseGetError(jsonObject, new ResponseKO(jsonObject));
		} catch (JSONException e) {
			throw new IllegalArgumentException(ResponseGet.class.getName() + " json malformed");
		}
	}
	
	public ResponseGet(JSONObject jsonObject) {
		super(jsonObject);
	}
}
