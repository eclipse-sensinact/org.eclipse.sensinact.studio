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
package org.eclipse.sensinact.studio.view.projectexplorer.handler;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.sensinact.studio.http.client.GatewayHttpClient;
import org.eclipse.sensinact.studio.http.client.snamessage.SnaMessage;
import org.eclipse.sensinact.studio.model.resource.utils.Constants;
import org.eclipse.sensinact.studio.model.resource.utils.JsonUtil;
import org.eclipse.sensinact.studio.model.resource.utils.ResourceDescriptor;
import org.eclipse.sensinact.studio.model.resource.utils.Segments;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import org.eclipse.sensinact.studio.resource.AccessMethodType;

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
			// TODO remove this when gateway management will be implemented
			String gatewayID = null;

			SnaMessage response = uninstall(Constants.createUninstallAppRD(gatewayID), fileName);
			displayResult(getShell(event), "Application removed", fileName, response);
		} catch (Exception e) {
			displayResult(getShell(event), "Application removed", fileName, e);
			logger.error("Application removal failed", e);
			return null;
		}

		return null;
	}

	private SnaMessage uninstall(ResourceDescriptor resource, String name) throws JSONException, IOException {
		JSONArray jsonParameters = new JSONArray();
		JSONObject info = JsonUtil.createNameTypeValue("name", String.class.getName(), name);
		jsonParameters.put(info);
		JSONObject params = new JSONObject();
		params.put("parameters", jsonParameters);
		Segments path = new Segments.Builder().resource(resource).method(AccessMethodType.ACT).build();
		return GatewayHttpClient.sendPostRequest(path, jsonParameters);
	}
}
