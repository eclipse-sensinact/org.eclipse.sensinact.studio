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

import org.apache.log4j.Logger;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.sensinact.studio.navigator.device.toolbar.dialog.GatewayConfigDialog;
import org.eclipse.sensinact.studio.preferences.ConfigurationManager;
import org.eclipse.sensinact.studio.preferences.GatewayHttpConfig;
import org.eclipse.sensinact.studio.ui.common.dialog.SnaHandler;
import org.eclipse.swt.widgets.Shell;

/**
 * @author Etienne Gandrille
 */
public class AddHandler extends SnaHandler {

	private static final Logger logger = Logger.getLogger(AddHandler.class);
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		Shell shell = getShell(event);
		
		GatewayConfigDialog dialog = new GatewayConfigDialog(shell, ConfigurationManager.getGatewayNames());		
		dialog.create();
	
		if (dialog.open() == Window.OK) {
			GatewayHttpConfig gateway = dialog.getGateway();
			if (! ConfigurationManager.addGateway(gateway)) {
				MessageDialog.openError(shell, "Update Error", "Please check logs.");
				logger.error("Error while adding a new gateway with config:" + gateway);
			}
		}
		
		return null;
	}
}
