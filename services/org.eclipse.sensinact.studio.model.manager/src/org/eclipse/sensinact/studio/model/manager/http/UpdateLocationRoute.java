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
package org.eclipse.sensinact.studio.model.manager.http;

import java.io.UnsupportedEncodingException;

import org.apache.log4j.Logger;
import org.eclipse.sensinact.studio.http.server.SensinactServerResource;
import org.eclipse.sensinact.studio.model.manager.listener.devicelocation.DeviceLocationManager;
import org.eclipse.sensinact.studio.model.resource.utils.DeviceDescriptor;
import org.eclipse.sensinact.studio.model.resource.utils.GPScoordinates;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.Response;
import org.restlet.data.Status;
import org.restlet.resource.Post;

/**
 * @author Etienne Gandrille
 */
public class UpdateLocationRoute extends SensinactServerResource {

	private static final Logger logger = Logger.getLogger(UpdateLocationRoute.class);
	
	@Post("json")
	public Response getValue(String params) {
		Response response = getResponse();

		try {
			String gatewayName = getRequestAttribute("gateway");
			String deviceName = getRequestAttribute("device");
			
			JSONObject jsonMsg = new JSONObject(params);
			double lat = (Double) jsonMsg.get("lat");
			double lng = (Double) jsonMsg.get("lng");
			DeviceLocationManager.getInstance().updateLocationInServer(new DeviceDescriptor(gatewayName, deviceName), new GPScoordinates(lat, lng));
			response.setStatus(Status.SUCCESS_OK);
		} catch (UnsupportedEncodingException e) {
			logger.error("DeviceInfoRoute - decode error", e);
			response.setStatus(Status.SERVER_ERROR_INTERNAL);
		} catch (JSONException e) {
			logger.error("Update Location Route", e);
			response.setStatus(Status.SERVER_ERROR_INTERNAL);
		}

		return response;
	}
}
