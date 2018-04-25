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
package org.eclipse.sensinact.studio.navigator.device.doubleclick;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sensinact.studio.http.services.client.StudioRequest;
import org.eclipse.sensinact.studio.http.services.client.UIResult;
import org.eclipse.sensinact.studio.model.manager.modelupdater.ModelEditor;
import org.eclipse.sensinact.studio.model.resource.utils.ResourceDescriptor;
import org.eclipse.sensinact.studio.navigator.device.ui.dialogs.resourceInvoker.ResourceInvokerDialog;
import org.eclipse.sensinact.studio.navigator.device.ui.dialogs.resourceInvoker.methodprovider.APIDefinedMethodProvider;
import org.eclipse.sensinact.studio.ui.common.dialog.SimpleDialog;
import org.eclipse.sensinact.studio.ui.common.notification.NotifierDialog;
import org.eclipse.swt.widgets.Shell;
import org.json.JSONException;
import org.json.JSONObject;

import org.eclipse.sensinact.studio.resource.AccessMethod;
import org.eclipse.sensinact.studio.resource.AccessMethodType;
import org.eclipse.sensinact.studio.resource.NamedElement;
import org.eclipse.sensinact.studio.resource.Resource;
import org.eclipse.sensinact.studio.resource.ResourcePackage;

/**
 * @author Etienne Gandrille
 */
public class BasicQueryResourceHelper {
	
	private final ResourceDescriptor descriptor;

	private final int resourceClassClassifierID;
	
	private final Shell parent;

	public BasicQueryResourceHelper(Shell parent, Resource resource) {
		this.parent = parent;

		String gatewayID = ((NamedElement) resource.eContainer().eContainer().eContainer()).getName();
		String deviceID = ((NamedElement) resource.eContainer().eContainer()).getName();
		String serviceID = ((NamedElement) resource.eContainer()).getName();
		String resourceID = resource.getName();
		descriptor = new ResourceDescriptor(gatewayID, deviceID, serviceID, resourceID);

		// Represents the type of the resource as an integer
		resourceClassClassifierID = resource.eClass().getClassifierID();
	}

	public void execute() throws InterruptedException {

		// access method selection
		AccessMethodType type = null;
		int nbParam = -1;
		AccessMethod selectedMethod = null;
		for (AccessMethod method : ModelEditor.getInstance().getAccessMethods(descriptor)) {

			int curSize = method.getParameter().size();
			AccessMethodType curType = method.getType();

			if (isCompatibleResourceMethod(curType)) {
				if (nbParam == -1 || curSize < nbParam) {
					nbParam = curSize;
					type = curType;
					selectedMethod = method;
				}
			}
		}
	
		// no access method available
		if (nbParam == -1) {
			MessageDialog.openError(parent, "Error", "No default access method available");

			// method with NO parameters available (great !)
		} else if (nbParam == 0) {
			executeWithoutParameters(type);

			// execution WITH parameters
		} else {
			executeWithParameters(selectedMethod);
		}
	}

	private boolean isCompatibleResourceMethod(AccessMethodType type) {
		if (resourceClassClassifierID == ResourcePackage.ACTION)
			if (type == AccessMethodType.ACT)
				return true;
			else
				return false;
		if (type == AccessMethodType.GET)
			return true;
		if (type == AccessMethodType.SET)
			return true;
		return false;
	}

	private void executeWithParameters(AccessMethod selectedMethod) {
		ResourceInvokerDialog dialog = new ResourceInvokerDialog(null, descriptor, new APIDefinedMethodProvider(descriptor, selectedMethod));
		dialog.open();
	}

	private void executeWithoutParameters(AccessMethodType type) {
		StudioRequest request = new StudioRequest(descriptor, type);
		UIResult result = request.sendRequestForIU();
		
		switch(result.getStatus()) {
			case SUCCESS:
				if (type != AccessMethodType.ACT)
					try {
						new SimpleDialog(parent, result.getTitle(), new JSONObject(result.getMessage()).toString(4), MessageDialog.INFORMATION).open();
					} catch (JSONException e) {
						new SimpleDialog(parent, result.getTitle(), result.getMessage(), MessageDialog.INFORMATION).open();
					}
				else
					NotifierDialog.notify(result.getTitle(), result.getMessage());
				break;
			case ERROR:
				try {
					new SimpleDialog(parent, result.getTitle(), new JSONObject(result.getMessage()).toString(4), MessageDialog.ERROR).open();
				} catch (JSONException e) {
					new SimpleDialog(parent, result.getTitle(), result.getMessage(), MessageDialog.ERROR).open();
				}
				break;
		}
	}
}
