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

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.events.TreeEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;

/**
 * @author Jander Nascimento
 */
public class SensinactTreeViewer extends TreeViewer {

	public SensinactTreeViewer(Composite parent) {
		super(parent);
	}
	
	public SensinactTreeViewer(Composite parent, int style) {
		super(parent, style);
	}

	public SensinactTreeViewer(Tree tree) {
		super(tree);
	}

	public void handleEvent(TreeEvent event){
		super.handleTreeExpand(event);
	}
}
