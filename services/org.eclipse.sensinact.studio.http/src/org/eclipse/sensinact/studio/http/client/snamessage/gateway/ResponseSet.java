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

import org.eclipse.sensinact.studio.http.client.snamessage.ResponseKO;
import org.eclipse.sensinact.studio.http.client.snamessage.ResponseMessage;
import org.eclipse.sensinact.studio.http.client.snamessage.ResponseOK;
import org.eclipse.sensinact.studio.http.client.snamessage.ResponseSetError;
import org.eclipse.sensinact.studio.http.client.snamessage.ResponseSetOK;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Etienne Gandrille
 */
public abstract class ResponseSet extends ResponseMessage {

	public static final String KEY = "SET_RESPONSE";
	
	public ResponseSet(JSONObject jsonObject) {
		super(jsonObject);
	}
	
	public static ResponseSet build(JSONObject jsonObject) {
		try {
			int statusCode = jsonObject.getInt("statusCode");
			if (statusCode == 200)
				return new ResponseSetOK(jsonObject, new ResponseOK(jsonObject));
			else
				return new ResponseSetError(jsonObject, new ResponseKO(jsonObject));
		} catch (JSONException e) {
			throw new IllegalArgumentException(ResponseSet.class.getName() + " json malformed");
		}
	}	
}
