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
package org.eclipse.sensinact.studio.model.manager.http;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.sensinact.studio.http.messages.snamessage.MsgFactory;
import org.eclipse.sensinact.studio.http.messages.snamessage.MsgSensinact;
import org.eclipse.sensinact.studio.http.services.server.SensinactServerResource;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.Response;
import org.restlet.data.Status;
import org.restlet.resource.Post;

/**
 * @author Nicolas Hili
 */
public abstract class GatewayHttpServerRoute extends SensinactServerResource {

	private static final Logger logger = Logger.getLogger(GatewayHttpServerRoute.class);

	@Post("json")
	public Response getValue(String params) {
		try {
			JSONObject json = new JSONObject(params);
			String id = json.getString("callbackId");
			List<MsgSensinact> messages = getMessagesList(json);
			Status status = notify(id, messages); 
			return buildResponse(status);
		} catch (JSONException e) {
			logger.error("DeviceInfoRoute - decode error", e);
			return null;
		}
	}

	protected abstract Status notify(String id, List<MsgSensinact> messages);
	
	private List<MsgSensinact> getMessagesList(JSONObject json) throws JSONException {
		JSONArray array = json.getJSONArray("messages");
		List<MsgSensinact> messages = new ArrayList<MsgSensinact>(); 
		for (int i=0; i<array.length(); i++) {
			JSONObject object = array.getJSONObject(i);
			messages.add(MsgFactory.build(object));
		}
		return messages;
	}
	
	private Response buildResponse(Status status) {
		Response response = getResponse();
		response.setStatus(status);
		return response;
	}
}
