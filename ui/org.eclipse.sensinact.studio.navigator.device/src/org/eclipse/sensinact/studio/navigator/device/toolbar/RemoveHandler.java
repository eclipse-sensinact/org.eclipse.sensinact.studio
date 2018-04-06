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
import org.eclipse.sensinact.studio.preferences.ConfigurationManager;
import org.eclipse.sensinact.studio.resource.Gateway;
import org.eclipse.sensinact.studio.ui.common.dialog.SnaHandler;

/**
 * @author Etienne Gandrille
 */
public class RemoveHandler extends SnaHandler {

	private static final Logger logger = Logger.getLogger(RemoveHandler.class);

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		Object element = getSelectedElement(event);
		if (element != null && element instanceof Gateway) {
			Gateway gateway = (Gateway) element;
			String name = gateway.getName();
			if (MessageDialog.openConfirm(getShell(event), "Please confirm", "Do you want to remove the gateway " + name + "?")) {
				if (!ConfigurationManager.removeGateway(name)) {
					logger.error("Error while removing gateway with name " + name);
				}
			}
		} else {
			MessageDialog.openError(getShell(event), "Error", "Please select the gateway to be deleted in the ree viewer.");
		}

		return null;
	}
}
