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
package org.eclipse.sensinact.studio.navigator.device;

import org.apache.log4j.Logger;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.sensinact.studio.model.manager.listener.modelset.ResourceModelSetListener;
import org.eclipse.sensinact.studio.model.manager.listener.modelset.ResourceModelSetManager;
import org.eclipse.sensinact.studio.model.manager.modelupdater.ModelEditor;
import org.eclipse.sensinact.studio.navigator.device.doubleclick.BasicQueryResourceHelper;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.navigator.INavigatorContentService;

import org.eclipse.sensinact.studio.resource.Resource;

/**
 * @author Nicolas Hili, Etienne Gandrille
 */
public class DeviceNavigatorView extends CommonNavigator implements ResourceModelSetListener {

	private static final Logger logger = Logger.getLogger(DeviceNavigatorView.class);
	
	public static final String VIEW_ID = "org.eclipse.sensinact.studio.navigator.device";
	
	@Override
	protected void initListeners(TreeViewer viewer) {
		super.initListeners(viewer);
		ResourceModelSetManager.getInstance().subscribe(this);
	}
	
	@Override
	public void modelSetUpdated(ResourceSetChangeEvent event) {
		Display.getDefault().asyncExec(new Runnable() {
			  public void run() {
				  INavigatorContentService contentService = getNavigatorContentService();		            
				  contentService.getActivationService().persistExtensionActivations();
				  contentService.update();
				  contentService.dispose();
			  }
		});
	}
	
	@Override
	protected Object getInitialInput() {
		try {
			return ModelEditor.getInstance().getViewerInput();
		} catch (InterruptedException e) {
			logger.error("Can't get initial value for tree viewer", e);
			return null;
		}
	}

	@Override
	protected void handleDoubleClick(DoubleClickEvent event) {

		IStructuredSelection selection = (IStructuredSelection) event.getSelection();
		Object element = selection.getFirstElement();

		if (element != null && element instanceof Resource) {
			Resource resource = (Resource) element;
			BasicQueryResourceHelper manager = new BasicQueryResourceHelper(getViewSite().getShell(), resource);
			try {
				manager.execute();
				return;
			} catch (InterruptedException e) {
				logger.error("Error during double click handler processing", e);
			}
		}

		// if no special action, perform the default one
		super.handleDoubleClick(event);
	}
}
