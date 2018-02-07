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
package org.eclipse.sensinact.studio.ui.common.widget;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

/**
 * @author Etienne Gandrille
 */
public class TextField extends KeyValueField {
	
	@Override
	protected Control createControl(Composite parent) {
		return new Text(parent, SWT.BORDER);
	}
	
	@Override
	public String getValue() {
		Text text = (Text) getControl();
		return text.getText();
	}

	@Override
	public void setValue(String value) {
		Text text = (Text) getControl();
		text.setText(value);
	}

	@Override
	public void resetValue() {
		setValue("");
	}
}
