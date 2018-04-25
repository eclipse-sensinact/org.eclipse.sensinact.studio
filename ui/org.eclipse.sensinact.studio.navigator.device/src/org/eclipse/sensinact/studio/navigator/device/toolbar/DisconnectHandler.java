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
package org.eclipse.sensinact.studio.navigator.device.toolbar;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sensinact.studio.http.services.client.subscribe.agent.Agent;
import org.eclipse.sensinact.studio.http.services.client.websockets.SensinactWebSocketConnectionManager;
import org.eclipse.sensinact.studio.model.manager.modelupdater.ModelEditor;
import org.eclipse.sensinact.studio.preferences.ConfigurationManager;
import org.eclipse.sensinact.studio.preferences.GatewayHttpConfig;
import org.eclipse.sensinact.studio.ui.common.dialog.SnaHandler;
import org.eclipse.swt.widgets.Shell;
import org.json.JSONException;
import org.eclipse.sensinact.studio.resource.Gateway;

/**
 * @author Etienne Gandrille
 */
public class DisconnectHandler extends SnaHandler {

	private static final Logger logger = Logger.getLogger(DisconnectHandler.class);
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		Shell parent = getShell(event);

		Object element = getSelectedElement(event);
		if (element != null && element instanceof Gateway) {
			Gateway gateway = (Gateway) element;
			String name = gateway.getName();
			GatewayHttpConfig gwConfig = ConfigurationManager.getGateway(name);
			if (gwConfig == null) {
				MessageDialog.openError(parent, "Error", "Can't find gateway info.");
				logger.error("Error while getting gateway config for " + name);
			} else if ( ! Agent.getInstance().isConnected(name)) {
				MessageDialog.openError(parent, "Error", "Gateway is not connected.");
			} else {
				disconnect(parent, gwConfig);
			}
		} else {
			MessageDialog.openError(parent, "Error", "Please select a gateway in the tree viewer.");
		}
		
		return null;
	}

	private void disconnect(Shell parent, GatewayHttpConfig gwConfig) {
		try {
			Agent.getInstance().unsubscribe(gwConfig);
		} catch (IOException | JSONException e) {
			logger.warn("Error while disconnecting gateway", e);
		}
		SensinactWebSocketConnectionManager.getInstance().disconnect(gwConfig.getName());
		ModelEditor.getInstance().clearGatewayContent(gwConfig.getName());
	}
}
