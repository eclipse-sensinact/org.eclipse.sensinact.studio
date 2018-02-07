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

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

/**
 * @author Etienne Gandrille
 */
public class KeyValueWidget {

	private ControlListener resizeListener;
	private final Control control;

	KeyValueWidget(Composite parent, Map<String, String> input, String keyLabel, String valueLabel) {
		control = createComposite(parent, input, keyLabel, valueLabel);
	}

	public Control getControl() {
		return control;
	}

	public void setLayoutData(Object layoutData) {
		control.setLayoutData(layoutData);
	}

	private Control createComposite(Composite parent, Map<String, String> input, String keyLabel, String valueLabel) {

		// JFace Table Viewer
		StructuredViewer jFaceViewer = new TableViewer(parent, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		jFaceViewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		final TableViewerColumn col1 = createTableViewerColumn(jFaceViewer, 0, keyLabel);
		final TableViewerColumn col2 = createTableViewerColumn(jFaceViewer, 1, valueLabel);
		jFaceViewer.setContentProvider(new TableContentProvider());
		jFaceViewer.setInput(input);
		jFaceViewer.setComparator(getDefaultComparator());

		// SWT Table widget configuration
		Table swtTable = ((TableViewer) jFaceViewer).getTable();
		swtTable.setHeaderVisible(true);
		swtTable.setLinesVisible(true);

		// Listener
		resizeListener = new ResizeListener(col1, col2, jFaceViewer);
		jFaceViewer.getControl().addControlListener(resizeListener);

		return jFaceViewer.getControl();
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
		column.setAlignment(SWT.LEFT);

		viewerColumn.setLabelProvider(new ColumnLabelProvider() {
			private String getTextFromObject(Object element) {
				String[] keyValue = (String[]) element;
				return keyValue[index];
			}

			@Override
			public String getText(Object element) {
				return getTextFromObject(element);
			}

			@Override
			public String getToolTipText(Object element) {
				return getTextFromObject(element);
			}
		});

		return viewerColumn;
	}

	/**
	 * Resize the table column as soon as a composite is resized.
	 * 
	 * @see ResizeEvent
	 */
	private static class ResizeListener implements ControlListener {

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
		}

		@Override
		public void controlMoved(ControlEvent e) {
			// do nothing
		}
	}

	private static ViewerComparator getDefaultComparator() {
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
