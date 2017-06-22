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

import org.eclipse.sensinact.studio.http.client.snamessage.gateway.ResponseGet;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Etienne Gandrille
 */
public class ResponseGetOK extends ResponseGet {

	//private ResponseOK ok;
	private int timestamp;
	private String name;
	private String value;
	private ResponseKO ko;
	
	//{"response":{"timestamp":1465824378119,"name":"location","value":"44.40850067:8.92329979","type":"string"},"statusCode":200,"type":"GET_RESPONSE","uri":"/tourism_2/admin/location"}
	public ResponseGetOK(JSONObject jsonObject) {
		super(jsonObject);
		
		try {
			
			if (isValid()) {
				JSONObject triggered=super.getJson().getJSONObject("response");
				
				timestamp = triggered.getInt("timestamp");
				name = triggered.getString("name");
				value = triggered.get("value").toString();
				ko = null;
			} else {
				//ok = null;
				ko = new ResponseKO(jsonObject);
			}
		
		} catch (JSONException e) {
			e.printStackTrace();
			ko = new ResponseKO(jsonObject);
		}
	}

	@Override
	public String getPrettyPrintedValue() {
		try {
			return getValue()!=null?getValue():super.getJson().toString(4);
		} catch (JSONException e) {
			e.printStackTrace();
			return getValue();
		}
	}
	
	@Override
	public String getFullDescription() {	
		return value.toString();
	}
	
	public String getName() {
		return name;
	}
	
	public String getValue() {
		return value;
	}
}
