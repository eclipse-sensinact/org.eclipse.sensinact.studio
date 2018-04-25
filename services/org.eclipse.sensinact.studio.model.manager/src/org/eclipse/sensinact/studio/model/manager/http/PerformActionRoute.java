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

import java.io.UnsupportedEncodingException;

import org.apache.log4j.Logger;
import org.eclipse.sensinact.studio.http.services.client.StudioRequest;
import org.eclipse.sensinact.studio.http.services.client.UIResult;
import org.eclipse.sensinact.studio.http.services.server.SensinactServerResource;
import org.eclipse.sensinact.studio.model.resource.utils.ResourceDescriptor;
import org.restlet.resource.Get;

import org.eclipse.sensinact.studio.resource.AccessMethodType;

/**
 * @author Etienne Gandrille
 */
public class PerformActionRoute extends SensinactServerResource {

	private static final Logger logger = Logger.getLogger(PerformActionRoute.class);

	@Get
	public String getValue(String params) {
		try {
			String gatewayName = getRequestAttribute("gateway");
			String deviceName = getRequestAttribute("device");
			String serviceName = getRequestAttribute("service");
			String ressourceName = getRequestAttribute("ressource");

			ResourceDescriptor descriptor = new ResourceDescriptor(gatewayName, deviceName, serviceName, ressourceName);
			StudioRequest request = new StudioRequest(descriptor, AccessMethodType.ACT);
			UIResult result = request.sendRequestForIU();

			logger.debug(result.asJson());

			return result.asJson().toString();
		} catch (UnsupportedEncodingException e) {
			logger.error("DeviceInfoRoute - decode error", e);
			return "";
		}
	}
}
