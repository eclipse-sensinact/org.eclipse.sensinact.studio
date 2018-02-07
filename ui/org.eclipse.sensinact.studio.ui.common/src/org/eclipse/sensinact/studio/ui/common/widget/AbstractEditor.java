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

import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

/**
 * An editor is a dialog part. From SWT point of view, it's a composite composed
 * of a few SWT widgets. Here is a base class for implementing editors, such as
 * list editors and map editors.
 * 
 * @author Etienne Gandrille
 */
public abstract class AbstractEditor {

	/** The parent Shell */
	protected Shell shell;

	// labels
	protected final String addLabel = "Add";
	protected final String removeLabel = "Remove";

	/** The JFace viewer */
	protected StructuredViewer jFaceViewer;

	/** The main composite for this widget. */
	protected Composite widgetComposite;

	public AbstractEditor(Composite parent) {
		this.shell = parent.getShell();
	}

	/**
	 * Sets the comparator, for sorting values.
	 * 
	 * @param comparator
	 *            the new comparator
	 */
	public void setComparator(ViewerComparator comparator) {
		jFaceViewer.setComparator(comparator);
		refresh();
	}

	/**
	 * Gets the default comparator.
	 * 
	 * @return the default comparator
	 */
	protected abstract ViewerComparator getDefaultComparator();

	/**
	 * Sets the composite layout data.
	 */
	public void setLayoutData(Object layoutData) {
		widgetComposite.setLayoutData(layoutData);
	}

	/**
	 * Repaints the widget.
	 */
	public abstract void refresh();
}
