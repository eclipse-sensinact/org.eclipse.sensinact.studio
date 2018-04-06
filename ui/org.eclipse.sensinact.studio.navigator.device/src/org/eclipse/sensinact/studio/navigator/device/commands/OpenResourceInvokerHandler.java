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
package org.eclipse.sensinact.studio.navigator.device.commands;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.sensinact.studio.model.resource.utils.ResourceDescriptor;
import org.eclipse.sensinact.studio.navigator.device.ui.dialogs.resourceInvoker.ResourceInvokerDialog;
import org.eclipse.sensinact.studio.navigator.device.ui.dialogs.resourceInvoker.methodprovider.GUIDefinedMethodProvider;
import org.eclipse.ui.PlatformUI;

import org.eclipse.sensinact.studio.resource.Device;
import org.eclipse.sensinact.studio.resource.Gateway;
import org.eclipse.sensinact.studio.resource.Resource;
import org.eclipse.sensinact.studio.resource.Service;

/**
 * @author Nicolas Hili
 */
public class OpenResourceInvokerHandler extends AbstractHandler {

	/* (non-Javadoc)
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		showMenu(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection());
		return null;
	}
	
	public void showMenu(ISelection iselection){
		Object selection = iselection;
		// Get first element if the selection is an IStructuredSelection
		if(selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection)selection;
			selection = structuredSelection.getFirstElement();
		}
		
		// Treat non-null selected object (try to adapt and return EObject)
		if(selection instanceof Resource) {
			Resource resource = (Resource) selection;
			Service service = (Service) resource.eContainer();
			Device device = (Device) service.eContainer();
			Gateway gateway = (Gateway) device.eContainer();
			
			String deviceId = device.getName();
			String serviceId = service.getName();
			String resourceId = resource.getName();
			String gatewayId = gateway.getName();
			ResourceDescriptor descriptor = new ResourceDescriptor(gatewayId, deviceId, serviceId, resourceId);
			
			// TODO new Shell() pour le parent ???? 
			ResourceInvokerDialog dialog = new ResourceInvokerDialog(null, descriptor, new GUIDefinedMethodProvider(descriptor));
			dialog.create();
			dialog.open();
		}
	}
	
	@Override
	public boolean isEnabled() {
		return super.isEnabled();
	}
}
