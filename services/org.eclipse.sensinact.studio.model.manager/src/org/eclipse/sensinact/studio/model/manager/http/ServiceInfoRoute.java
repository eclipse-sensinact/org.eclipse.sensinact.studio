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
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.sensinact.studio.http.messages.snamessage.MsgSensinact;
import org.eclipse.sensinact.studio.http.messages.snamessage.getresponse.MsgGetResponse;
import org.eclipse.sensinact.studio.http.services.client.StudioRequest;
import org.eclipse.sensinact.studio.http.services.server.SensinactServerResource;
import org.eclipse.sensinact.studio.model.manager.modelupdater.ModelEditor;
import org.eclipse.sensinact.studio.model.resource.utils.ResourceDescriptor;
import org.restlet.resource.Get;

import org.eclipse.sensinact.studio.resource.AccessMethodType;
import org.eclipse.sensinact.studio.resource.ResourcePackage;

/**
 * @author Etienne Gandrille
 */
public class ServiceInfoRoute extends SensinactServerResource {

	private static final Logger logger = Logger.getLogger(ServiceInfoRoute.class);
	
	@Get
	public String getValue(String params) {

		StringBuilder sb = new StringBuilder();

		try {
			String gatewayName = getRequestAttribute("gateway");
			String deviceName = getRequestAttribute("device");
			String serviceName = getRequestAttribute("service");

			String fullName = gatewayName + "/" + deviceName;
			
			sb.append("<b>" + fullName + "</b><br/>");

			List<String> serviceIds = ModelEditor.getInstance().getServicesId(gatewayName, deviceName);
			for (String serviceId : serviceIds) {

				// service name
				
				String symbol;
				String linkParams;
				if (serviceName.equals(serviceId)) {
					symbol = "-";
					linkParams = "'" + fullName + "'";
				} else {
					symbol = "+";
					linkParams = "'" + fullName + "','" + serviceId + "'";
				}
				String link = "updatePopupOnClick(" + linkParams + ")";				
				sb.append("<a href=\"#\" onclick=\"" + link + "\"> " + symbol + " " + serviceId + "</a><br/>\n");

				// resources, if needed
				if (serviceName.equals(serviceId)) {
					List<String> resourceIds = ModelEditor.getInstance().getResourcesId(gatewayName, deviceName, serviceName);
					for (String resourceId : resourceIds) {
						
						ResourceDescriptor descriptor = new ResourceDescriptor(gatewayName, deviceName, serviceName, resourceId);						
						int classifierID = ModelEditor.getInstance().getResourceClass(descriptor).getClassifierID();
	
						// ACTION
						if ( classifierID == ResourcePackage.ACTION) {
							String jsParams = "'" + gatewayName + "','" + deviceName + "','" + serviceName + "','" + resourceId + "'";
							
							// <a onclick="performAction(...)">...</a>
							String resourceValueWithLink = writeOnClickStatement("performAction", jsParams, "&lt;Action&gt;");
							
							sb.append("&nbsp;&nbsp;&nbsp;" + resourceId + ": " + resourceValueWithLink + "<br/>");							
						}
						
						// OTHER
						else {
							StudioRequest request = new StudioRequest(descriptor, AccessMethodType.GET);
							MsgSensinact response = request.sendRequest();
							
							String resourceValue = "<unknown>";
							if (response instanceof MsgGetResponse) {
								resourceValue = ((MsgGetResponse) response).getResponse().getValueAsString();
							}
							resourceValue = ((resourceValue == null) ? "null" : resourceValue);
							
							resourceValue = resourceValue.replaceAll("\n", "<br/>");
														
							// IMAGE
							if (isImageUrl(resourceValue)) {
								// <a onclick="showImage(...)">...</a>
								String resourceValueWithLink = writeOnClickStatement("showImage", "'" + resourceValue + "'", resourceValue);
								sb.append("&nbsp;&nbsp;&nbsp;" + resourceId + ": " + resourceValueWithLink + "<br/>");
							}
							// NOT AN IMAGE
							else {
								sb.append("&nbsp;&nbsp;&nbsp;" + resourceId + ": " + resourceValue + "<br/>");
							}
						}
					}
				}
			}

			return sb.toString();
		} catch (IOException | InterruptedException e) {
			logger.error("Service info route", e);
		}
		return "";
	}

	// returns '<a onclick="$jsFunction($jsParams)">$linkText</a>'
	private String writeOnClickStatement(String jsFunction, String jsParams, String linkText) {
		return "<a href=\"#\" onclick=\"" + jsFunction + "(" + jsParams + ")" +"\">" + linkText + "</a>";
	}
	
	private boolean isImageUrl(String resourceValue) {
		
		String[] exts ={"gif", "jpg", "jpeg", "png"};
		
		// protocol check : must be an url
		if (! resourceValue.startsWith("http://") && ! resourceValue.startsWith("https://"))
			return false;

		// extension check : must be an image
		for (String ext : exts) {
			if (resourceValue.toLowerCase().endsWith("." + ext))
				return true;
		}

		return false;
	}
}