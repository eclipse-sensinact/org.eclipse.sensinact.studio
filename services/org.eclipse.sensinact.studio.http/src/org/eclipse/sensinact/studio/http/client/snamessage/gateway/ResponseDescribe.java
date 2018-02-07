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

import org.eclipse.sensinact.studio.http.client.snamessage.ResponseDescribeResource;
import org.eclipse.sensinact.studio.http.client.snamessage.ResponseMessage;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * @author Etienne Gandrille
 */
// {"response":{"name":"name","type":"PROPERTY"},"statusCode":200,"type":"DESCRIBE_RESPONSE","uri":"/weather_11/admin/name"}
public class ResponseDescribe extends ResponseMessage {

	public static final String KEY = "DESCRIBE_RESPONSE";

	private final JSONObject info;
	
	public static ResponseMessage build(JSONObject jsonObject) {
		
		try {
			JSONObject info = jsonObject.getJSONObject("response");
			try {
				return new ResponseDescribeResource(jsonObject, info);
			} catch (Exception e) {
				return new ResponseDescribe(jsonObject, info);
			}
		} catch (JSONException e) {
			// no response field...
			throw new IllegalArgumentException(ResponseDescribe.class.getName() + " json malformed");
		}
	}
	
	public ResponseDescribe(JSONObject jsonObject, JSONObject info) {
		super(jsonObject);		
		this.info = info;
	}
	
	public JSONObject getInfo() {
		return info;
	}
}
