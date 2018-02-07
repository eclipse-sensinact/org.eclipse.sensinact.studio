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
package org.eclipse.sensinact.studio.navigator.device.ui.dialogs.resourceInvoker.parameterfield;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

/**
 * @author Etienne Gandrille
 */
public abstract class ParameterField {

	// graphic
	private Label namelabel;
	private Control widget;
	private Label typeLabel;
	
	// model
	private String name;
	private String value;
	
	public static ParameterField create(Composite composite, String name, String type) {	
		
		if (NumberField.getAcceptedTypes().contains(type))
			return new NumberField(composite, name, type);
		
		if (TextField.getAcceptedTypes().contains(type))
			return new TextField(composite, name, type);
		
		if (BooleanField.getAcceptedTypes().contains(type))
			return new BooleanField(composite, name, type);
		
		throw new RuntimeException("No field available to display variable " + name + " of type " + type);
	}
	
	protected ParameterField(Composite composite, String name, String type, String defaultValue) {
		this.namelabel = createNameLabel(composite, name);
		this.widget = createWidget(composite, name);
		this.typeLabel = createTypeLabel(composite, type);
		this.name = name;
		this.value = defaultValue;
	}
	
	private static Label createNameLabel(Composite composite, String name) {
		Label label = new Label(composite, SWT.NONE);
		label.setText(name + ":");
		return label;
	}
	
	protected abstract Control createWidget(Composite parameterListComposite, final String name);
	
	private static Label createTypeLabel(Composite parameterListComposite, String type) {
		Label typeLabel = new Label(parameterListComposite, SWT.NONE);
		typeLabel.setText(type);
		typeLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		return typeLabel;		
	}
	
	protected void setValue(String value) {
		this.value = value;
	}
	
	public String getName() {
		return name;
	}
	
	public String getValue() {
		return value;
	}
}
