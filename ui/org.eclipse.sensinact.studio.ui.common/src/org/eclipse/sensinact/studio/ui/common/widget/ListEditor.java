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

import java.util.Comparator;
import java.util.List;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

/**
 * A simple list<String> editor, with an add an a remove button.
 * 
 * @author Etienne Gandrille
 */
public class ListEditor extends AbstractEditor {

	private List<String> model;

	private Text text;

	private IInputValidator validator = null;
	
	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent composite.
	 * @param model
	 *            the input, which can be an empty list, but mustn't be null.
	 */
	public ListEditor(Composite parent, List<String> model) {
		super(parent);

		this.model = model;

		// Composite
		widgetComposite = new Composite(parent, SWT.NONE);
		widgetComposite.setLayout(new GridLayout(2, false));

		// Text
		text = new Text(widgetComposite, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));

		// Add Button
		final Button btnAdd = new Button(widgetComposite, SWT.NONE);
		btnAdd.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
		btnAdd.setText(addLabel);

		// JFace List Viewer
		jFaceViewer = new ListViewer(widgetComposite, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		jFaceViewer.setContentProvider(new ArrayContentProvider());
		jFaceViewer.setLabelProvider(new LabelProvider());
		jFaceViewer.setInput(model);
		jFaceViewer.setComparator(getDefaultComparator());
		jFaceViewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		// Remove Button
		final Button btnRemove = new Button(widgetComposite, SWT.NONE);
		btnRemove.setText(removeLabel);
		btnRemove.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false));

		// Listeners
		btnAdd.addMouseListener(new AddButtonListener(shell, text, jFaceViewer));
		btnRemove.addMouseListener(new RemoveButtonListener(shell, jFaceViewer));
	}

	public void setValidator(IInputValidator validator) {
		this.validator = validator;
	}
	
	private class AddButtonListener implements MouseListener {

		private Text text;
		private Shell shell;
		private StructuredViewer list;

		public AddButtonListener(Shell shell, Text text, StructuredViewer list) {
			this.shell = shell;
			this.text = text;
			this.list = list;
		}

		@Override
		public void mouseDoubleClick(MouseEvent e) {
		}

		@Override
		public void mouseDown(MouseEvent e) {
		}

		@Override
		public void mouseUp(MouseEvent e) {
			String str = text.getText().trim();

			if (str.isEmpty()) {
				displayError("Can't add an empty string");
				return;
			} 
			
			if (model.contains(str)) {
				displayError("\"" + str + "\"" + " is already in the list.");
				return;
			}
			
			if (validator != null) {
				String msg = validator.isValid(str);
				if (msg != null) {
					displayError(msg);
					return;
				}
			}
			
			model.add(str);
			list.refresh();

			text.setText("");
			text.setFocus();
		}
		
		void displayError(String message) {
			MessageDialog.openError(shell, "Error", message);
		}
	}

	/**
	 * Listener called when clicking on the remove button.
	 */
	private class RemoveButtonListener implements MouseListener {

		private Shell shell;
		private StructuredViewer list;

		public RemoveButtonListener(Shell shell, StructuredViewer list) {
			this.shell = shell;
			this.list = list;
		}

		@Override
		public void mouseDoubleClick(MouseEvent e) {
		}

		@Override
		public void mouseDown(MouseEvent e) {
		}

		@Override
		public void mouseUp(MouseEvent e) {
			StructuredSelection sel = (StructuredSelection) list.getSelection();
			String str = (String) sel.getFirstElement();

			if (str == null)
				MessageDialog.openError(shell, "Error", "Please select an element first.");
			else
				model.remove(str);
			list.refresh();
		}
	}

	@Override
	public void refresh() {
	}

	@Override
	protected ViewerComparator getDefaultComparator() {
		return new ViewerComparator(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.toUpperCase().compareTo(o2.toUpperCase());
			}
		});
	}
}
