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
package org.eclipse.sensinact.studio.ui.common.dialog;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ListDialog;

/**
 * Dialog to pick a SINGLE element from a list.
 * 
 * getFirstResult method added for convinience. 
 * 
 * @author Etienne Gandrille
 */
public class BasicListDialog extends ListDialog {
	public BasicListDialog(Shell parent, String title, String message, String[] elements) {
		super(parent);
		setTitle(title);
		setMessage(message);
		setAddCancelButton(true);
		setInput(elements);
		setHelpAvailable(false);
		
		setContentProvider(new IStructuredContentProvider() {
			public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			}

			public void dispose() {
			}

			public Object[] getElements(Object inputElement) {
				return (String[]) inputElement;
			}
		});
		
		setLabelProvider(new LabelProvider());
	}
	
	@Override
	public String[] getResult() {
		Object[] result = super.getResult();
		if (result == null || result.length == 0)
			return null;
		
		List<String> list = new ArrayList<String>(); 
		for (Object o : result)
			list.add((String) o);
		
		return list.toArray(new String[0]);
	}
	
	public String getFirstResult() {
		String[] results = getResult();
		if (results == null || results.length == 0)
			return null;
		return results[0];
	}	
}
