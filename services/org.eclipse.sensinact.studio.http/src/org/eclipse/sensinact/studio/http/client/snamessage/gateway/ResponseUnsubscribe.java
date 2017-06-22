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
package org.eclipse.sensinact.studio.http.client.snamessage.gateway;

import org.eclipse.sensinact.studio.http.client.snamessage.ResponseMessage;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Etienne Gandrille
 */
public class ResponseUnsubscribe extends ResponseMessage {

	public static final String KEY = "UNSUBSCRIBE_RESPONSE";
	
	private final String taskId;
	private final String status;
	private final int start;
	private final int end;

	//{"response":{"taskId":"sensiNact#UNSUBSCRIBE#system#event","status":"ABORDED","start":1465823758549,"end":1465823758549},"statusCode":200,"type":"UNSUBSCRIBE_RESPONSE","uri":"/sensiNact/system/event"}
	public ResponseUnsubscribe(JSONObject jsonObject) {
		super(jsonObject);
		
		try {
			JSONObject response = jsonObject.getJSONObject("response");
			taskId = response.getString("taskId");
			status = response.getString("status");
			start = response.getInt("start");
			end = response.getInt("end");		
		} catch (JSONException e) {
			throw new IllegalArgumentException(this.getClass().getName() + " json malformed");
		}
	}
	
	@Override
	public String getPrettyPrintedValue() {
		return taskId;
	}
	
	@Override
	public String getFullDescription() {
		String msg = super.getFullDescription();
		msg += "taskId:" + taskId + "\n";
		msg += "status: " + status + "\n";
		msg += "start: " + start + "\n";
		msg += "end: " + end + "\n";
		return msg;
	}
}
