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
package org.eclipse.sensinact.studio.navigator.device.ui.dialogs.resourceInvoker;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.sensinact.studio.http.services.client.GatewayHttpClient.RequestParameter;
import org.eclipse.sensinact.studio.navigator.device.ui.dialogs.resourceInvoker.parameterfield.ParameterField;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

import org.eclipse.sensinact.studio.resource.AccessMethod;
import org.eclipse.sensinact.studio.resource.Parameter;

/**
 * @author Etienne Gandrille
 */
public class ParametersComposite {

	private Composite globalComposite;
	private Label header;
	private Composite parameterListComposite;
	private List<ParameterField> fields = new ArrayList<>();

	ParametersComposite(Composite area) {
		globalComposite = new Composite(area, SWT.NONE);
		globalComposite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		globalComposite.setLayout(new GridLayout(1, false));
		globalComposite.setVisible(false);

		initHeader();
		initparameterListComposite(false);
	}

	private void initHeader() {
		header = new Label(globalComposite, SWT.NONE);
		header.setText("Parameters:");
	}
	
	private void initparameterListComposite(boolean visible) {
		parameterListComposite = new Composite(globalComposite, SWT.BORDER);
		parameterListComposite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		parameterListComposite.setLayout(new GridLayout(3, false));
		parameterListComposite.setVisible(visible);
	}
	
	private void init() {
		initHeader();
		initparameterListComposite(true);
	}
	
	/**
	 * This method is in charge of clearing the parameter composite by disposing
	 * all its children (the label as well as the parameter list) When the
	 * parameter composite is cleared, it is layouted
	 */
	void clearContent() {
		for (Control children : globalComposite.getChildren())
			if (children != null && !children.isDisposed())
				children.dispose();
		globalComposite.layout(true);
		fields.clear();
	}

	/**
	 * This method create the parameter list according to the access method
	 * (type and signature) selected. It begins to clear the parameter parameter
	 * composite if it already contains children (i.e. is an other access method
	 * has been selected before)
	 * 
	 * @param AccessMethod
	 *            accessMethod : the current access method
	 */
	void createParameterList(AccessMethod accessMethod) {
		clearContent();

		if (accessMethod.getParameter().size() == 0)
			return;

		init();

		// For each parameter
		for (int i = 0; i < accessMethod.getParameter().size(); i++) {
			final Parameter parameter = accessMethod.getParameter().get(i);
			String name = parameter.getName();
			String type = parameter.getType();
			ParameterField field = ParameterField.create(parameterListComposite, name, type);
			fields.add(field);
		}

		globalComposite.setVisible(true);
		globalComposite.layout(true);
	}

	public RequestParameter[] getParametersValues(AccessMethod accessMethod) {
		List<RequestParameter> params = new ArrayList<>();
		if (accessMethod != null) {
			for (int i = 0; i < accessMethod.getParameter().size(); i++) {
				Parameter parameter = accessMethod.getParameter().get(i);
				String name = parameter.getName();
				String type = parameter.getType();
				String value = getParameterValue(name);
				params.add(new RequestParameter(name, type, value));
			}
		}
		return params.toArray(new RequestParameter[0]);
	}

	private String getParameterValue(String name) {
		for (ParameterField field : fields)
			if (field.getName().equals(name))
				return field.getValue();
		throw new RuntimeException("No available field with name " + name);
	}
}

