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

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.sensinact.studio.http.services.server.SensinactServerResource;
import org.eclipse.sensinact.studio.model.manager.modelupdater.ModelEditor;
import org.eclipse.sensinact.studio.model.manager.modelupdater.ModelUpdater;
import org.restlet.resource.Get;

/**
 * @author Etienne Gandrille
 */
public class DeviceInfoRoute extends SensinactServerResource {

	private static final Logger logger = Logger.getLogger(DeviceInfoRoute.class);
	
	@Get
	public String getValue(String params) {

		StringBuilder sb = new StringBuilder();
		
		try {
			String gatewayName = getRequestAttribute("gateway");
			String deviceName = getRequestAttribute("device");
			
			String fullName = gatewayName + "/" + deviceName;
			
			sb.append("<b>" + fullName + "</b><br/>");
			List<String> serviceIds = ModelEditor.getInstance().getServicesId(gatewayName, deviceName);
			if(serviceIds.size()==0){
				ModelUpdater.getInstance().updateServices(gatewayName, deviceName, true);
				serviceIds = ModelEditor.getInstance().getServicesId(gatewayName, deviceName);
			}
			for (String serviceId : serviceIds) {
				String link = "updatePopupOnClick('" + fullName + "','" + serviceId + "')";
				String symbol = "+";
				sb.append("<a href=\"#\" onclick=\"" + link + "\"> " + symbol + " " + serviceId + "</a><br/>\n");
			}
			
			return sb.toString();
		} catch (InterruptedException e) {
			logger.error("DeviceInfoRoute", e);
			return "ERROR - see logs";
		} catch (UnsupportedEncodingException e) {
			logger.error("DeviceInfoRoute - decode error", e);
			return "ERROR - see logs";
		} catch (IOException e) {
			logger.error("DeviceInfoRoute - decode error", e);
			return "ERROR - see logs";
		}
	}
}
