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
package org.eclipse.sensinact.studio.navigator.device.filter;

import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.dialogs.PatternFilter;

/**
 * PatternFilter extension that add the Children of those who matches in the
 * result list
 * 
 * @author Jander Nascimento
 *
 */
public class SensinactPatternFilter extends PatternFilter {

	protected boolean isChildMatch(Viewer viewer, Object element) {
		Object parent = ((ITreeContentProvider) ((AbstractTreeViewer) viewer).getContentProvider()).getParent(element);

		if (parent != null) {
			return (isLeafMatch(viewer, parent) ? true : isChildMatch(viewer, parent));
		}
		return false;

	}

	@Override
	protected boolean isLeafMatch(Viewer viewer, Object element) {
		String labelText = ((ILabelProvider) ((StructuredViewer) viewer).getLabelProvider()).getText(element);

		if (labelText == null) {
			return false;
		}

		return (wordMatches(labelText) ? true : isChildMatch(viewer, element));
	}
}
