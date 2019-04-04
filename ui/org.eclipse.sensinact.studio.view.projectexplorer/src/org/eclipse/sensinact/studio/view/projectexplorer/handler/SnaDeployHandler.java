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
import org.eclipse.sensinact.studio.model.resource.utils.ResourceDescriptor;
import org.eclipse.sensinact.studio.model.resource.utils.Segments;
import org.eclipse.sensinact.studio.view.projectexplorer.handler.sna2json.SnaToJsonUtil;
import org.eclipse.swt.widgets.Shell;
import org.json.JSONException;
import org.json.JSONObject;

import org.eclipse.sensinact.studio.language.sensinact.DSL_SENSINACT;
import org.eclipse.sensinact.studio.resource.AccessMethodType;
import org.eclipse.sensinact.studio.ui.common.dialog.BasicListDialog;

/**
 * @author Etienne Gandrille
 */
public class SnaDeployHandler extends SnaAppHandler {

	private static final Logger logger = Logger.getLogger(SnaDeployHandler.class);
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
			
		Shell shell = getShell(event);
		URI snaFileURI = selection2fileURI(event);
		String fileName = computeRuleName(snaFileURI);
		
		try {
			DSL_SENSINACT sna = fileURI2eca(snaFileURI);
			JSONObject app = generateJsonApplication(sna, fileName);
			
			List<String> gatewayIds = ModelEditor.getInstance().getConnectedGatewaysId();
			if (gatewayIds.size() == 0) {
				MessageDialog.openError(getShell(event), "Application installation failed", "No connected gateway available.");
			} else {
				BasicListDialog listDialog = new BasicListDialog(getShell(event), "Connected gateways", "Please choose a Gateway", gatewayIds.toArray(new String[0]));
				if (listDialog.open() == Window.OK) {
					String gatewayID = listDialog.getFirstResult();
					MsgSensinact response = install(Constants.createInstallAppRD(gatewayID), app);
					String title = response.isValid() ? "Application deployed" : "Application deploy failed"; 
					displayResult(shell, title, fileName, response);
				}
			}
		} catch (Exception e) {
			displayResult(shell, "Application deploy failed", fileName, e);
			logger.error("Application deploy failed", e);
			return null;
		}

		return null;
	}

	private MsgSensinact install(ResourceDescriptor resource, JSONObject json) throws IOException {
		Segments path = new Segments.Builder().resource(resource).method(AccessMethodType.ACT).build();
		return GatewayHttpClient.sendPostRequest(path, json);
	}
	
	private JSONObject generateJsonApplication(DSL_SENSINACT sna, String fileName) throws JSONException {
		SnaParsingResult parsingResult = SnaToJsonUtil.parseSnaFile(sna, fileName);
		JSONObject app = parsingResult.getApplication();
		logger.debug("json generated");
		logger.debug(app);
		return app;
	}
}
