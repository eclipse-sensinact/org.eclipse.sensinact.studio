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
package org.eclipse.sensinact.studio.ui.common.widget.MultiColumnTableWidget;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

/**
 * @author Etienne Gandrille
 */
public class MultiColumnsTableWidget {

	final TableViewer jFaceViewer;

	public MultiColumnsTableWidget(Composite parent, Object layoutData, boolean headerVisible, boolean linesVisible, String[] headers, int[] colWeight,
			String[][] model, ViewerComparator comparator, final DoubleClickListener listener) {

		// default comparator
		if (comparator == null)
			comparator = ViewerComparatorFactory.getAlphanumericalComparator();

		// JFace Table Viewer
		jFaceViewer = new TableViewer(parent, SWT.V_SCROLL | SWT.BORDER);
		
		jFaceViewer.getControl().setLayoutData(layoutData);
		jFaceViewer.getControl().setSize(jFaceViewer.getControl().computeSize(600, 200, true));
		List<TableViewerColumn> cols = new ArrayList<>();
		for (int i = 0; i < headers.length; i++) {
			cols.add(createTableViewerColumn(jFaceViewer, i, headers[i]));
		}
		jFaceViewer.setContentProvider(new TableContentProvider());
		jFaceViewer.setInput(model);
		jFaceViewer.setComparator(comparator);

		// Double click on Table cell
		if (listener != null) {
			jFaceViewer.getTable().addListener(SWT.MouseDoubleClick, new Listener() {
				@Override
				public void handleEvent(Event event) {
					Point clickPoint = new Point(event.x, event.y);
					Table swtTable = jFaceViewer.getTable();

					for (int lineNb = swtTable.getTopIndex(); lineNb < swtTable.getItemCount(); lineNb++) {
						final TableItem curLine = swtTable.getItem(lineNb);
						for (int columnNb = 0; columnNb < swtTable.getColumnCount(); columnNb++) {
							Rectangle cellArea = curLine.getBounds(columnNb);
							if (cellArea.contains(clickPoint)) {
								String[] element = (String[]) jFaceViewer.getElementAt(lineNb);
								listener.onDoubleClick(element, columnNb);
							}
						}
					}
				}
			});
		}

		// SWT Table widget configuration
		Table swtTable = jFaceViewer.getTable();
		swtTable.setHeaderVisible(headerVisible);
		swtTable.setLinesVisible(linesVisible);

		// resize listener
		ResizeOnPaintListener resizeListener = new ResizeOnPaintListener(cols, colWeight, jFaceViewer);
		parent.addPaintListener(resizeListener);
	}

	public Control getControl(){
		return jFaceViewer.getControl();
	}
	
	public String[][] getModel() {
		return (String[][]) jFaceViewer.getInput();
	}

	public void setModel(String[][] model) {
		jFaceViewer.setInput(model);
	}

	public String[] getSelectedElement() {
		TableItem[] sel = jFaceViewer.getTable().getSelection();
		if (sel.length != 0) {
			return (String[]) sel[0].getData();
		}
		return null;
	}

	public Object getLayoutData() {
		return jFaceViewer.getTable().getLayoutData();
	}

	public void setFocus() {
		jFaceViewer.getTable().setFocus();
	}

	private static TableViewerColumn createTableViewerColumn(TableViewer viewer, final int index, String title) {
		final TableViewerColumn viewerColumn = new TableViewerColumn(viewer, SWT.NONE);
		final TableColumn column = viewerColumn.getColumn();
		column.setWidth(200);
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

	private static class TableContentProvider implements IStructuredContentProvider {
		@Override
		public Object[] getElements(Object inputElement) {
			if (inputElement == null)
				return new String[0][0];
			else
				return (String[][]) inputElement;
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

	private class ResizeOnPaintListener implements PaintListener {
		final List<TableViewerColumn> cols;
		final int[] colWeight;
		final int sumWeight;
		final StructuredViewer table;

		public ResizeOnPaintListener(List<TableViewerColumn> cols, int[] colWeight, StructuredViewer table) {
			this.cols = cols;
			this.colWeight = colWeight;
			this.sumWeight = computeSumWeight(colWeight);
			this.table = table;
		}

		private int computeSumWeight(int[] colWeight2) {
			int sum = 0;
			for (int cur : colWeight2)
				sum += cur;
			return sum;
		}

		@Override
		public void paintControl(PaintEvent e) {
			Control control = table.getControl();
			int availableWidth = control.getBounds().width - 2;
			BigDecimal pointValue = new BigDecimal(availableWidth).divide(new BigDecimal(sumWeight), BigDecimal.ROUND_DOWN);
			for (int i = 0; i < cols.size(); i++) {
				BigDecimal curWidth = pointValue.multiply(new BigDecimal(colWeight[i]));
				cols.get(i).getColumn().setWidth(curWidth.intValue() - 1);
			}
			table.refresh();
			table.getControl().redraw();
		}
	}
}
