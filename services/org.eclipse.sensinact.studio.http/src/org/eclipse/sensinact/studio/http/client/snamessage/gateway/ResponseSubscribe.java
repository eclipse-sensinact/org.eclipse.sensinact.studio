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

import org.eclipse.sensinact.studio.http.client.snamessage.ResponseMessage;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Etienne Gandrille
 */
public class ResponseSubscribe extends ResponseMessage {

	public static final String KEY = "SUBSCRIBE_RESPONSE";
	
	private final String id;
	
	// {"response":{"subscriptionId":"event18040186921465822896394"},"statusCode":200,"type":"SUBSCRIBE_RESPONSE","uri":"/sensiNact/system/event"}
	public ResponseSubscribe(JSONObject jsonObject) {
		super(jsonObject);
	
		try {
			id = jsonObject.getJSONObject("response").getString("subscriptionId");
		} catch (JSONException e) {
			throw new IllegalArgumentException(this.getClass().getName() + " json malformed");
		}
	}
	
	public String getSubscriptionId() {
		return id;
	}
	
	@Override
	public String getPrettyPrintedValue() {
		return id;
	}
	
	@Override
	public String getFullDescription() {
		String msg = super.getFullDescription();
		msg += "id:" + id;
		return msg;
	}
}
