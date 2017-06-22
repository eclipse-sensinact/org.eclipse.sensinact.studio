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

package org.eclipse.sensinact.studio.view.projectexplorer.handler;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.sensinact.studio.http.client.GatewayHttpClient;
import org.eclipse.sensinact.studio.http.client.snamessage.SnaMessage;
import org.eclipse.sensinact.studio.model.resource.utils.Constants;
import org.eclipse.sensinact.studio.model.resource.utils.ResourceDescriptor;
import org.eclipse.sensinact.studio.model.resource.utils.Segments;
import org.eclipse.sensinact.studio.view.projectexplorer.handler.sna2json.SnaToJsonUtil;
import org.eclipse.swt.widgets.Shell;
import org.json.JSONException;
import org.json.JSONObject;

import org.eclipse.sensinact.studio.language.sensinact.DSL_Resource;
import org.eclipse.sensinact.studio.language.sensinact.DSL_SENSINACT;
import org.eclipse.sensinact.studio.resource.AccessMethodType;

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
			String gatewayID = getGatewayID(sna);
			
			SnaMessage response = install(Constants.createInstallAppRD(gatewayID), app);
			String title = response.isValid() ? "Application deployed" : "Application deploy failed"; 
			displayResult(shell, title, fileName, response);		
		} catch (Exception e) {
			displayResult(shell, "Application deploy failed", fileName, e);
			logger.error("Application deploy failed", e);
			return null;
		}

		return null;
	}

	private SnaMessage install(ResourceDescriptor resource, JSONObject json) throws IOException {
		Segments path = new Segments.Builder().resource(resource).method(AccessMethodType.ACT).build();
		return GatewayHttpClient.sendPostRequest(path, json);		
	}
	
	private JSONObject generateJsonApplication(DSL_SENSINACT sna, String fileName) throws JSONException {
		SnaParsingResult parsingResult = SnaToJsonUtil.parseSnaFile(sna, fileName);
		JSONObject app = parsingResult.getApplication();
		logger.debug("json sent");
		logger.debug(app);
		return app;
	}

	private String getGatewayID(DSL_SENSINACT sna) {
		Set<String> gateways = new HashSet<>();
		
		if (sna == null)
			throw new IllegalArgumentException("");
		
		for (DSL_Resource resource : sna.getResources()) {
			gateways.add(resource.getGatewayID());
		}
		
		if (gateways.size() == 0) {
			throw new IllegalArgumentException("No gateway referenced in the sna file");
		} 
		if (gateways.size() == 1) {
			return gateways.iterator().next();
		}
		throw new IllegalArgumentException(gateways.size() + " gateways are referenced in the sna file. Only one is allowed.");
	}
}
