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
package org.eclipse.sensinact.studio.http.services.client;

import java.io.IOException;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.eclipse.sensinact.studio.http.messages.snamessage.MsgSensinact;
import org.eclipse.sensinact.studio.http.messages.snamessage.actresponse.MsgActResponse;
import org.eclipse.sensinact.studio.http.messages.snamessage.getresponse.MsgGetResponse;
import org.eclipse.sensinact.studio.http.services.client.UIResult.DialogStatus;
import org.eclipse.sensinact.studio.model.resource.utils.ResourceDescriptor;
import org.eclipse.sensinact.studio.model.resource.utils.Segments;
import org.eclipse.sensinact.studio.resource.AccessMethodType;
import org.restlet.data.Parameter;

/**
 * @author Etienne Gandrille
 */
public class StudioRequest {

	private final ResourceDescriptor descriptor;
	private final AccessMethodType type;
	
	private static final Logger logger = Logger.getLogger(StudioRequest.class);
	
	public StudioRequest(ResourceDescriptor descriptor, AccessMethodType type) {
		this.descriptor = descriptor;
		this.type = type;	
	}
	
	public MsgSensinact sendRequest(Collection<Parameter> queryParameter){
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
	
	public MsgSensinact sendRequest() throws IOException {
		return sendRequest(null);
	}
	
	public UIResult sendRequestForIU() {
		String title = descriptor.getDevice();
		String message;
		DialogStatus dialogType;
		MsgSensinact response=null;
		try {
			response = sendRequest();
			
			// errors 404,...
			if (response instanceof MsgActResponse) {
				MsgActResponse actResponse = (MsgActResponse) response;
				message = actResponse.getResponse().getTask();
				dialogType = DialogStatus.SUCCESS;
			} else if (response instanceof MsgGetResponse) {
				MsgGetResponse getResponse = (MsgGetResponse) response;
				message = getResponse.getResponse().getValueAsString();
				dialogType = DialogStatus.SUCCESS;
			} else {
				message = "Message type : " + response.getType();
				dialogType = response.isValid() ? DialogStatus.SUCCESS : DialogStatus.ERROR;
			}
		} catch (Exception e) {
			title = "Error";
			message = e.getMessage();
			dialogType = DialogStatus.ERROR;
		}
		logger.info(dialogType.toString() + " " + message);
		return new UIResult(title, message, dialogType);
	}
}
