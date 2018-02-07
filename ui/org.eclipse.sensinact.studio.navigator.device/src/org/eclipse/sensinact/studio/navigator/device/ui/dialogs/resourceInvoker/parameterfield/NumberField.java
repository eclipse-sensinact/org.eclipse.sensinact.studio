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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Spinner;


/**
 * @author Etienne Gandrille
 */
public class NumberField extends ParameterField {

	protected NumberField(Composite composite, String name, String type) {
		super(composite, name, type, "0");
	}

	public static List<String> getAcceptedTypes() {
		return Arrays.asList(Integer.class.getName(), "int", Double.class.getName());
	}
	
	protected Control createWidget(Composite parameterListComposite, final String name) {

		final Spinner control = new Spinner(parameterListComposite, SWT.BORDER);

		control.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		control.setMaximum(65000); // default is 100

		control.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				String value = Integer.toString(control.getSelection());
				setValue(value);
			}

			@Override
			public void focusGained(FocusEvent e) {
			}
		});

		return control;
	}
}
