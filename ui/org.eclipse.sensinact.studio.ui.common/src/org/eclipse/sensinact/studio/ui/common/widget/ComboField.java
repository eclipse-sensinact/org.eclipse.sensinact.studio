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

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * @author Etienne Gandrille
 */
public class ComboField extends KeyValueField {

	private final List<String> keyList;
	
	public ComboField(List<String> keyList) {
		this.keyList = keyList;
	}

	@Override
	protected Control createControl(Composite parent) {
		Combo combo = new Combo(parent, SWT.BORDER);
		for (String key : keyList)
			combo.add(key);
		
		// combo.select(0); // less visual confusion is nothing is selected at

		return combo;
	}
	
	@Override
	public String getValue() {
		Combo combo = (Combo) getControl();
		return combo.getText();
	}

	@Override
	public void setValue(String value) {
		Combo combo = (Combo) getControl();
		combo.select(getIndex(value));
	}

	@Override
	public void resetValue() {
		Combo combo = (Combo) getControl();
		combo.select(0);
	}

	private int getIndex(String value) {
		Combo combo = (Combo) getControl();
		for (int i = 0; i < combo.getItemCount(); i++) {
			String name = combo.getItem(i);
			if (name.equals(value))
				return i;
		}

		// not found. A general purpose implementation would return -1 or throw
		// an exception
		return 0;
	}
}
