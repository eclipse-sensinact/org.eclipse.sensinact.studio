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
package org.eclipse.sensinact.studio.navigator.device.ui.dialogs.resourceInvoker.methodprovider;

import org.eclipse.sensinact.studio.model.resource.utils.ResourceDescriptor;
import org.eclipse.sensinact.studio.navigator.device.ui.dialogs.resourceInvoker.ResourceInvokerDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import org.eclipse.sensinact.studio.resource.AccessMethod;

/**
 * @author Etienne Gandrille
 */
public abstract class MethodProvider {

	protected ResourceInvokerDialog resourceInvokerDialog;
	
	protected final ResourceDescriptor descriptor;
	
	public MethodProvider(ResourceDescriptor descriptor) {
		this.descriptor = descriptor;
	}
	
	protected void setDialogMessage(String message, int type) {
		resourceInvokerDialog.setMessage(message, type);
	}
	
	public abstract Control createDialogArea(Composite parent);
	
	public abstract String getAccessMethodType();
	
	public abstract AccessMethod getAccessMethod();
	
	protected void updateWidgets() {
		resourceInvokerDialog.updateWidgets();
	}

	public void registerResourceInvokerDialog(ResourceInvokerDialog resourceInvokerDialog) {
		this.resourceInvokerDialog = resourceInvokerDialog;
	}
}
