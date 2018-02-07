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
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Etienne Gandrille
 */
public class ResponseAct extends ResponseMessage {

	public static final String KEY = "ACT_RESPONSE";

	private int timestamp;
	private String type;
	private String value;
	
	private ResponseOK ok;
	private ResponseKO ko;

	// BUGFIX Christophe has to swap the response part and the triggered part.
	// Update this when the gateway bug will be fixed.
	// {"response":{"timestamp":1465826225451,"name":"status","value":"ON","type":"string"},"statusCode":200,"type":"ACT_RESPONSE","uri":"/light/switch/turn_on","triggered":[{"taskId":"light#ACT#switch#turn_on","result":null,"status":"EXECUTED","start":1465826225114,"end":1465826225184}]}
	public ResponseAct(JSONObject jsonObject) {
		super(jsonObject);
		
		try {
		
			if (isValid()) {
				JSONObject triggered;
					triggered = super.getJson().getJSONObject("response");
				
				timestamp = triggered.getInt("start");
				type = super.getType();
				value = triggered.getString("result");	
				ko = null;
			} else {
				ok = null;
				ko = new ResponseKO(jsonObject);
			}
		
		} catch (JSONException e) {
			e.printStackTrace();
			ok = null;
			ko = new ResponseKO(jsonObject);
		}
	}

	@Override
	public String getFullDescription() {
		return value;
	}

	@Override
	public String getPrettyPrintedValue() {
		if (isValid())
			return ok.getPrettyPrintedValue();
		else
			return ko.getPrettyPrintedValue();
	}
	
	public int getTimestamp() {
		return timestamp;
	}
	
	public String getType() {
		return type;
	}
	public String getValue() {
		return value;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		ResponseAct other = (ResponseAct) obj;

		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

}
