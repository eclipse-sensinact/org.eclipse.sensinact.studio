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

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * @author Etienne Gandrille
 */
public abstract class KeyValueField {

	Composite parent = null;
	Control control = null;
	
	public void setParent(Composite parent) {
		this.parent = parent;
	}
	
	public Control getControl() {
		if (control == null) {
			if (parent == null)
				throw new RuntimeException("parent should be set");
			control = createControl(parent);
		}
		return control;
	}
	
	public void setLayoutData(Object layoutData) {
		getControl().setLayoutData(layoutData);
	}

	public void setFocus() {
		getControl().setFocus();
	}
	
	protected abstract Control createControl(Composite parent);
	
	public abstract String getValue();
	
	public abstract void setValue(String value);
	
	public abstract void resetValue();
}

