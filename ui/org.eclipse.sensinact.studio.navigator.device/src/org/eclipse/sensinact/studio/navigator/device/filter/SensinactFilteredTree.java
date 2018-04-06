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
import org.eclipse.sensinact.studio.model.manager.listener.modelset.ResourceModelSetListener;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;

/**
 * Class that allows to interfere with the filter submitted to the tree
 * 
 * @author Jander Nascimento
 */
public class SensinactFilteredTree extends FilteredTree {

	private ResourceModelSetListener listener;

	public SensinactFilteredTree(Composite parent, boolean useNewLook) {
		super(parent, useNewLook);
	}

	public SensinactFilteredTree(ResourceModelSetListener listener, Composite parent, int treeStyle,
			PatternFilter filter, boolean useNewLook) {
		super(parent, treeStyle, filter, useNewLook);
		this.listener = listener;
		super.getFilterControl().addTraverseListener(new TraverseListener() {
			
			@Override
			public void keyTraversed(TraverseEvent e) {
				if(e.keyCode==13){
					doCreateRefreshJob();
				}
			}
		});
	}

	@Override
	protected TreeViewer doCreateTreeViewer(Composite parent, int style) {
		// TODO Auto-generated method stub
		return new SensinactTreeViewer(parent,style);//super.doCreateTreeViewer(parent, style);
	}

    @Override
    protected void updateToolbar(boolean visible) {
        super.updateToolbar(visible);
    }
	
	@Override
	protected void textChanged() {
		
		super.textChanged();
/*
		if(super.getFilterString().trim().equals("")){
			doCreateRefreshJob();	
		}
		
		if (listener != null) {
			listener.modelSetUpdated(null);
		}
		
		*/
	}

	
	
}
