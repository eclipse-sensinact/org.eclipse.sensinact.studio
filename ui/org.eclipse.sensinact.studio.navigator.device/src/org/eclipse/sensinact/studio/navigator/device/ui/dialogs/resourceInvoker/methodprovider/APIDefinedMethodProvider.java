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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import org.eclipse.sensinact.studio.resource.AccessMethod;

/**
 * @author Etienne Gandrille
 */
public class APIDefinedMethodProvider extends MethodProvider {

	private final AccessMethod method;
	
	public APIDefinedMethodProvider(ResourceDescriptor descriptor, AccessMethod method) {
		super(descriptor);
		this.method = method;
	}

	@Override
	public Control createDialogArea(Composite area) {
		return area;
	}

	protected void updateWidgets() {
		super.updateWidgets();
	}
	
	@Override
	public String getAccessMethodType() {
		return method.getType().getLiteral();
	}
	
	@Override
	public AccessMethod getAccessMethod() {
		return method;
	}
}
