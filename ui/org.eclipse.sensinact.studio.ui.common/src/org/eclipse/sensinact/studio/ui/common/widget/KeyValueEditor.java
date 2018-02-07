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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

/**
 * Base class for implementing key value editors.
 * 
 * @author Etienne Gandrille
 */
public class KeyValueEditor extends AbstractEditor {

	private final Map<String, String> model;

	// header widgets
	private final KeyValueField keyField;
	private final KeyValueField valueField;

	// validators
	private IInputValidator keyValidator = null;
	private IInputValidator valueValidator = null;
	
	// table labels
	private final String keyLabel;
	private final String valueLabel;

	private final ResizeListener resizeListener;

	public KeyValueEditor(Composite parent, Map<String, String> input, String keyLabel, String valueLabel, KeyValueField keyField, KeyValueField valueField) {
		super(parent);

		this.model = input;
		this.keyLabel = keyLabel;
		this.valueLabel = valueLabel;
		this.keyField = keyField;
		this.valueField = valueField;
		
		
		// Composite
		widgetComposite = new Composite(parent, SWT.NONE);
		widgetComposite.setLayout(new GridLayout(3, false));

		// fields
		keyField.setParent(widgetComposite);
		keyField.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		valueField.setParent(widgetComposite);
		valueField.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		
		// Add Button
		final Button btnAdd = new Button(widgetComposite, SWT.NONE);
		btnAdd.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));
		btnAdd.setText(addLabel);

		// JFace Table Viewer
		jFaceViewer = new TableViewer(widgetComposite, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		jFaceViewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		final TableViewerColumn col1 = createTableViewerColumn(jFaceViewer, 0, keyLabel);
		final TableViewerColumn col2 = createTableViewerColumn(jFaceViewer, 1, valueLabel);
		jFaceViewer.setContentProvider(new TableContentProvider());
		jFaceViewer.setInput(input);
		jFaceViewer.setComparator(getDefaultComparator());

		// SWT Table widget configuration
		Table swtTable = ((TableViewer) jFaceViewer).getTable();
		swtTable.setHeaderVisible(true);
		swtTable.setLinesVisible(true);

		// Remove Button
		final Button btnRemove = new Button(widgetComposite, SWT.NONE);
		btnRemove.setText(removeLabel);
		btnRemove.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false));

		// Listeners
		btnAdd.addMouseListener(new AddButtonListener(jFaceViewer));
		resizeListener = new ResizeListener(col1, col2, jFaceViewer);
		widgetComposite.addControlListener(resizeListener);
		jFaceViewer.addSelectionChangedListener(new SelectTableListener());
		btnRemove.addMouseListener(new RemoveButtonListener(parent.getShell(), jFaceViewer));
	}

	public Map<String, String> getModel() {
		return model;
	}

	public void setKeyValidator(IInputValidator keyValidator) {
		this.keyValidator = keyValidator;
	}

	public void setValueValidator(IInputValidator valueValidator) {
		this.valueValidator = valueValidator;
	}

	private static class TableContentProvider implements IStructuredContentProvider {

		@Override
		public Object[] getElements(Object inputElement) {

			@SuppressWarnings("unchecked")
			Map<String, String> items = (Map<String, String>) inputElement;

			List<String[]> retval = new ArrayList<String[]>();

			for (String key : items.keySet()) {
				String value = items.get(key);
				String[] keyValue = new String[2];
				keyValue[0] = key;
				keyValue[1] = value;
				retval.add(keyValue);
			}

			return retval.toArray();
		}

		@Override
		public void dispose() {
			// do nothing
		}

		@Override
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// do nothing
		}
	}

	private static TableViewerColumn createTableViewerColumn(StructuredViewer viewer, final int index, String title) {
		final TableViewerColumn viewerColumn = new TableViewerColumn(((TableViewer) viewer), SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();
		column.setText(title);
		column.setResizable(false);
		column.setMoveable(false);
		column.setAlignment(SWT.CENTER);

		viewerColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				String[] keyValue = (String[]) element;
				return keyValue[index];
			}
		});

		return viewerColumn;
	}

	private class AddButtonListener implements MouseListener {
		
		/** The table. */
		private StructuredViewer table;

		public AddButtonListener(StructuredViewer table) {
			this.table = table;
		}

		@Override
		public void mouseDoubleClick(MouseEvent e) {
			// do nothing
		}

		@Override
		public void mouseDown(MouseEvent e) {
			// do nothing
		}

		@Override
		public void mouseUp(MouseEvent e) {
			String str1 = keyField.getValue().trim();
			String str2 = valueField.getValue().trim();

			if (keyValidator != null) {
				String msg = keyValidator.isValid(str1);
				if (msg != null) {
					String title = "Invalid \"" + keyLabel + "\" value";
					MessageDialog.openError(shell, title, msg);
					keyField.setFocus();
					return;
				}
			}

			if (valueValidator != null) {
				String msg = valueValidator.isValid(str2);
				if (msg != null) {
					String title = "Invalid \"" + valueLabel + "\" value";
					MessageDialog.openError(shell, title, msg);
					valueField.setFocus();
					return;
				}
			}

			model.remove(str1);
			model.put(str1, str2);
			table.refresh();

			keyField.resetValue();
			valueField.resetValue();		
			keyField.setFocus();
		}
	}

	/**
	 * Resize the table column as soon as a composite is resized.
	 * 
	 * @see ResizeEvent
	 */
	private class ResizeListener implements ControlListener {

		final TableViewerColumn col1;
		final TableViewerColumn col2;
		final StructuredViewer table;

		public ResizeListener(TableViewerColumn col1, TableViewerColumn col2, StructuredViewer table) {
			this.col1 = col1;
			this.col2 = col2;
			this.table = table;
		}

		@Override
		public void controlResized(ControlEvent e) {
			Control control = table.getControl();
			int width = control.getBounds().width / 2 - 2;
			col1.getColumn().setWidth(width);
			col2.getColumn().setWidth(width);
			table.refresh();
			table.getControl().redraw();
		}

		@Override
		public void controlMoved(ControlEvent e) {
			// do nothing
		}
	}

	/**
	 * Listener called when an element is selected in the table.
	 * 
	 * @see SelectTableEvent
	 */
	public class SelectTableListener implements ISelectionChangedListener {

		public SelectTableListener() {
		}

		@Override
		public void selectionChanged(SelectionChangedEvent event) {
			StructuredSelection sel = (StructuredSelection) jFaceViewer.getSelection();
			String[] line = (String[]) sel.getFirstElement();

			if (line != null) {
				String key = line[0];
				String value = line[1];
				
				keyField.setValue(key);
				valueField.setValue(value);
			}
		}
	}

	private class RemoveButtonListener implements MouseListener {

		private Shell shell;
		private StructuredViewer table;

		public RemoveButtonListener(Shell shell, StructuredViewer table) {
			this.shell = shell;
			this.table = table;
		}

		@Override
		public void mouseDoubleClick(MouseEvent e) {
		}

		@Override
		public void mouseDown(MouseEvent e) {
		}

		@Override
		public void mouseUp(MouseEvent e) {
			StructuredSelection sel = (StructuredSelection) table.getSelection();
			String[] line = (String[]) sel.getFirstElement();

			if (line == null) {
				MessageDialog.openError(shell, "Error", "Please select an element first.");
			} else {
				model.remove(line[0]);
				table.refresh();
			}
		}
	}

	public void refresh() {
		resizeListener.controlResized(null);
	}

	@Override
	protected ViewerComparator getDefaultComparator() {
		return new ViewerComparator() {
			@Override
			public int compare(Viewer viewer, Object e1, Object e2) {
				String str1 = ((String[]) e1)[0];
				String str2 = ((String[]) e2)[0];
				return (str1.toUpperCase()).compareTo(str2.toUpperCase());
			}
		};
	}
}
