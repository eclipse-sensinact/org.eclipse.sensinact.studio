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

import java.util.Arrays;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * @author Etienne Gandrille
 */
public class BooleanField extends ParameterField {

	protected BooleanField(Composite composite, String name, String type) {
		super(composite, name, type, "false");
	}
	
	public static List<String> getAcceptedTypes() {
		return Arrays.asList("boolean", "bool", "Boolean");
	}
	
	protected Control createWidget(Composite parameterListComposite, final String name) {

		final Button control = new Button(parameterListComposite, SWT.CHECK);
		control.setSelection(false);
				
		control.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		control.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				String value = Boolean.toString(control.getSelection());
				setValue(value);
			}
			
			@Override
			public void focusGained(FocusEvent e) {
			}
		});

		return control;
	}
}
