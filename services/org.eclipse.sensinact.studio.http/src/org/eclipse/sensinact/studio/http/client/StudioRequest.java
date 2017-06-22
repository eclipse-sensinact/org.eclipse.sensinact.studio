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
package org.eclipse.sensinact.studio.http.client;

import java.io.IOException;
import java.util.Collection;

import org.eclipse.sensinact.studio.http.client.UIResult.DialogStatus;
import org.eclipse.sensinact.studio.http.client.snamessage.SnaMessage;
import org.eclipse.sensinact.studio.model.resource.utils.ResourceDescriptor;
import org.eclipse.sensinact.studio.model.resource.utils.Segments;
import org.restlet.data.Parameter;

import org.eclipse.sensinact.studio.resource.AccessMethodType;

/**
 * @author Etienne Gandrille
 */
public class StudioRequest {

	private final ResourceDescriptor descriptor;
	private final AccessMethodType type;
		
	public StudioRequest(ResourceDescriptor descriptor, AccessMethodType type) {
		this.descriptor = descriptor;
		this.type = type;	
	}
	
	public SnaMessage sendRequest(Collection<Parameter> queryParameter){
		Segments segments = new Segments.Builder().resource(descriptor).method(type).build();
		try {
			if (type.equals(AccessMethodType.GET)) {					
				return GatewayHttpClient.sendGetRequest(segments);
			} else if (type.equals(AccessMethodType.ACT)) {
				
					return GatewayHttpClient.sendPostRequest(segments,null,queryParameter);
				
			} else {
				throw new IllegalArgumentException("BasicRequest not implemented with " + type.getName() + " method");
			}
		} catch (IOException e) {
			throw new IllegalArgumentException("BasicRequest not implemented with " + type.getName() + " method");
		}
	}
	public SnaMessage sendRequest() throws IOException {
		return sendRequest(null);
	}
	
	public UIResult sendRequestForIU() {
		String title;
		String message;
		DialogStatus dialogType;
		SnaMessage response=null;
		try {
			response = sendRequest();
			title = descriptor.getDevice();
			message = String.format("%s: %s", descriptor.getResource(),response.getFullDescription());
			dialogType = response.isValid() ? DialogStatus.SUCCESS : DialogStatus.ERROR;
		} catch (Exception e) {
			title = "Error";
			message = response!=null?response.getJson().toString():e.getMessage();
			dialogType = DialogStatus.ERROR;
		}

		return new UIResult(title, message, dialogType);
	}
}
