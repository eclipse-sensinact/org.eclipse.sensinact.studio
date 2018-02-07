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

import org.apache.log4j.Logger;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.sensinact.studio.model.resource.utils.ResourceDescriptor;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import org.eclipse.sensinact.studio.resource.AccessMethod;

/**
 * @author Etienne Gandrille
 */
public class GUIDefinedMethodProvider extends MethodProvider {

	private MethodComposite methodComposite;
	
	private static final Logger logger = Logger.getLogger(GUIDefinedMethodProvider.class);
	
	public GUIDefinedMethodProvider(ResourceDescriptor descriptor) {
		super(descriptor);
	}

	@Override
	public Control createDialogArea(Composite area) {
		methodComposite = new MethodComposite(area, descriptor) ;
		addListeners();
		return area;
	}
	
	private void addListeners() {
		// listeners
		methodComposite.addTypeComboListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				updateWidgets();
				try {
					methodComposite.updateAccessMethods();
				} catch (InterruptedException e) {
					logger.error("Error while updating access methods", e);
				}
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}
		});
		
		methodComposite.addSignatureComboListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateWidgets();
			}
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}
		});
	}

	protected void updateWidgets() {
		super.updateWidgets();
		
		if (getAccessMethod() != null) {
			setDialogMessage("", IMessageProvider.NONE);
		} else {
			if (getAccessMethodType() == null) {
				setDialogMessage("Select one access method", IMessageProvider.WARNING);
			} else {
				setDialogMessage("Multiple signatures for the access method " + getAccessMethodType() + ". Please select one signature", IMessageProvider.INFORMATION);		
			}
		}
	}
	
	@Override
	public String getAccessMethodType() {
		return methodComposite.getSelectedAccessMethodType();
	}
	
	@Override
	public AccessMethod getAccessMethod() {
		try {
			return methodComposite.getSelectedAccessMethod();
		} catch (InterruptedException e) {
			logger.error("Error while getting selected access method", e);
			return null;
		}
	}
}
