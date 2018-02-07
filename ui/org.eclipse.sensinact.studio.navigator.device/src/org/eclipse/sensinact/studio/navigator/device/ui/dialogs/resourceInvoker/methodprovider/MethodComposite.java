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

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.sensinact.studio.model.manager.modelupdater.ModelEditor;
import org.eclipse.sensinact.studio.model.resource.utils.ResourceDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import org.eclipse.sensinact.studio.resource.AccessMethod;
import org.eclipse.sensinact.studio.resource.AccessMethodType;
import org.eclipse.sensinact.studio.resource.Parameter;

/**
 * @author Etienne Gandrille
 */
public class MethodComposite {

	private static final Logger logger = Logger.getLogger(MethodComposite.class);
	
	/**
	 * A composite to hold both type and signature labels and combo widgets.
	 */
	private Composite methodComposite;

	/**
	 * The label for the access method type
	 */
	private Label typeLabel;
	
	/**
	 * The combo widget for the access method type (SET, ACT, etc.)
	 */
	private Combo typeCombo;

	/**
	 * The label for the signatures of a particular access method
	 */
	private Label signatureLabel;

	/**
	 * The combo widget for the access method signature
	 */
	private Combo signatureCombo;
	
	private final ResourceDescriptor descriptor;
	
	MethodComposite(Composite area, ResourceDescriptor descriptor) {
		
		this.descriptor = descriptor;
		
		methodComposite = new Composite(area, SWT.BORDER);
		methodComposite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		methodComposite.setLayout(new GridLayout(2, true));
		
		typeLabel = new Label(methodComposite, SWT.NONE);
		typeLabel.setText("Type:");
		
		signatureLabel = new Label(methodComposite, SWT.NONE);
		signatureLabel.setText("Signature:");
		signatureLabel.setVisible(false);
		
		typeCombo = new Combo(methodComposite, SWT.NONE | SWT.DROP_DOWN | SWT.READ_ONLY);
		
		// populate type combo
		ArrayList<String> items = new ArrayList<String>();
		items.add("Choose type...");
		
		try {
			for (AccessMethod accessMethod : ModelEditor.getInstance().getAccessMethods(descriptor)) {
				String type = accessMethod.getType().getLiteral();
				if (!items.contains(type)) {
					items.add(type);
				}
			}
		} catch (InterruptedException e) {
			logger.error("Error while getting access methods");
		}
		
		typeCombo.setItems(items.toArray(new String[]{}));
		typeCombo.select(0);
		typeCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));	
		signatureCombo = new Combo(methodComposite, SWT.NONE | SWT.DROP_DOWN | SWT.READ_ONLY);
		signatureCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		signatureCombo.setVisible(false);
	}
	
	void updateAccessMethods() throws InterruptedException {
		String type = getSelectedAccessMethodType();
		
        // if the user did not choose an access method
		if (type == null) {								
			setVisibleSignature(false);
		} else {
			// Get all access methods for this type
			List<AccessMethod> accessMethods = ModelEditor.getInstance().getAccessMethodsWithType(descriptor, AccessMethodType.get(type));
			
			// Fill the signature combo
			if (accessMethods.size() > 1) {				
				signatureCombo.clearSelection();
				ArrayList<String> signatures = new ArrayList<String>();
				signatures.add("Choose signature...");
				for (AccessMethod accessMethod : accessMethods) {
					String signature = "";
					for (Parameter parameter : accessMethod.getParameter())
						signature = signature.concat(parameter.getName() + " : " + parameter.getType() + ", ");
					if (signature.endsWith(", "))
						signature = signature.substring(0, signature.length()-2);
					if (signature.equals(""))
						signature = "<no parameter>";
					signatures.add(signature);
				}
				signatureCombo.setItems(signatures.toArray(new String[]{}));
				signatureCombo.select(0);
				
				// Display signature combo and label
				setVisibleSignature(true);
			}
			
			// If there is only one access method, create the parameterList
			else { 
				setVisibleSignature(false);
			}
		}
	}
	
	String getSelectedAccessMethodType() {
		int index = typeCombo.getSelectionIndex();
		if (index == 0)
			return null;
		else 
			return typeCombo.getItem(index);
	}
	
	AccessMethod getSelectedAccessMethod() throws InterruptedException {
		String type = getSelectedAccessMethodType();
		
		if (type == null)
			return null;
		
		List<AccessMethod> accessMethods = ModelEditor.getInstance().getAccessMethodsWithType(descriptor, AccessMethodType.get(type));		
		if (accessMethods.size() > 1) {
			int index = signatureCombo.getSelectionIndex();
			if (index == 0 || index == -1)
				return null;
			return ModelEditor.getInstance().getAccessMethodsWithType(descriptor, AccessMethodType.get(type)).get(index-1);	
		} else {
			return accessMethods.get(0);
		}
	}
	
	void addTypeComboListener(SelectionListener listener) {
		typeCombo.addSelectionListener(listener);
	}

	void addSignatureComboListener(SelectionListener listener) {
		signatureCombo.addSelectionListener(listener);		
	}
	
	private void setVisibleSignature(boolean isVisible) {
		signatureCombo.setVisible(isVisible);
		signatureLabel.setVisible(isVisible);
	}
}
