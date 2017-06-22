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
import org.eclipse.sensinact.studio.model.manager.listener.subscription.SubscriptionManager;
import org.restlet.Response;
import org.restlet.data.Status;
import org.restlet.resource.Post;

/**
 * @author Nicolas Hili
 */
public class GatewayHttpServerRoute extends SensinactServerResource {

	private static final Logger logger = Logger.getLogger(GatewayHttpServerRoute.class);

	@Post("json")
	public Response getValue(String params) {
		try {
			String content = new String(params.getBytes());
			String id = getRequestAttribute("id");

			logger.debug("Callback recieved : " + content);
			Status status = SubscriptionManager.getInstance().callbackRecieved(content, id);

			Response response = getResponse();
			response.setStatus(status);
			return response;
		} catch (UnsupportedEncodingException e) {
			logger.error("DeviceInfoRoute - decode error", e);
			return null;
		}
	}
}
