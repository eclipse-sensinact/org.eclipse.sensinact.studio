/**
 * Copyright (c) 2019 CEA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     CEA - initial API and implementation and/or initial documentation
 */
package org.eclipse.sensinact.studio.view.projectexplorer.handler;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.sensinact.studio.http.messages.snamessage.MsgSensinact;
import org.eclipse.sensinact.studio.http.services.client.GatewayHttpClient;
import org.eclipse.sensinact.studio.model.manager.modelupdater.ModelEditor;
import org.eclipse.sensinact.studio.model.resource.utils.Constants;
import org.eclipse.sensinact.studio.model.resource.utils.JsonUtil;
import org.eclipse.sensinact.studio.model.resource.utils.ResourceDescriptor;
import org.eclipse.sensinact.studio.model.resource.utils.Segments;
import org.eclipse.sensinact.studio.resource.AccessMethodType;
import org.eclipse.sensinact.studio.ui.common.dialog.BasicListDialog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Etienne Gandrille
 */
public class SnaRemoveHandler extends SnaAppHandler {

	private static final Logger logger = Logger.getLogger(SnaRemoveHandler.class);
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		URI snaFileURI = selection2fileURI(event);
		String fileName = computeRuleName(snaFileURI);
		
		try {
			List<String> gatewayIds = ModelEditor.getInstance().findApplications().stream().filter(sd -> sd.getService().equals(fileName)).map(sd -> sd.getGateway()).collect(Collectors.toList());
			
			if (gatewayIds.size() == 0) {
				MessageDialog.openError(getShell(event), "Application removal failed", "Application not found.\nIs the gateway connected?");
			} else {
				BasicListDialog listDialog = new BasicListDialog(getShell(event), "Connected gateways", "Please choose a Gateway", gatewayIds.toArray(new String[0]));
				if (listDialog.open() == Window.OK) {
					String gatewayID = listDialog.getFirstResult();
					MsgSensinact response = uninstall(Constants.createUninstallAppRD(gatewayID), fileName);
					displayResult(getShell(event), "Application removed", fileName, response);					
				}
			}
		} catch (Exception e) {
			displayResult(getShell(event), "Application removed", fileName, e);
			logger.error("Application removal failed", e);
			return null;
		}

		return null;
	}

	private MsgSensinact uninstall(ResourceDescriptor resource, String name) throws JSONException, IOException {
		JSONArray jsonParameters = new JSONArray();
		JSONObject info = JsonUtil.createNameTypeValue("name", String.class.getName(), name);
		jsonParameters.put(info);
		JSONObject params = new JSONObject();
		params.put("parameters", jsonParameters);
		Segments path = new Segments.Builder().resource(resource).method(AccessMethodType.ACT).build();
		MsgSensinact msg = GatewayHttpClient.sendPostRequest(path, jsonParameters);
		return msg;
	}
}
