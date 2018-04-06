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
/**
 * Navigator Widget with the filter bar on the top


 */
package org.eclipse.sensinact.studio.navigator.device;

import org.apache.log4j.Logger;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.sensinact.studio.model.manager.listener.modelset.ResourceModelSetListener;
import org.eclipse.sensinact.studio.model.manager.listener.modelset.ResourceModelSetManager;
import org.eclipse.sensinact.studio.model.manager.modelupdater.ModelEditor;
import org.eclipse.sensinact.studio.navigator.device.commands.OpenResourceInvokerHandler;
import org.eclipse.sensinact.studio.navigator.device.doubleclick.BasicQueryResourceHelper;
import org.eclipse.sensinact.studio.navigator.device.filter.SensinactFilteredTree;
import org.eclipse.sensinact.studio.navigator.device.filter.SensinactPatternFilter;
import org.eclipse.sensinact.studio.navigator.device.toolbar.dialog.GatewayConfigDialog;
import org.eclipse.sensinact.studio.preferences.ConfigurationManager;
import org.eclipse.sensinact.studio.preferences.GatewayHttpConfig;
import org.eclipse.sensinact.studio.resource.Gateway;
import org.eclipse.sensinact.studio.resource.Resource;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.internal.navigator.NavigatorContentService;
import org.eclipse.ui.navigator.CommonDragAdapter;
import org.eclipse.ui.navigator.INavigatorContentService;
import org.eclipse.ui.part.ViewPart;

/**
 * @author Etienne Gandrille
 */
public class DeviceNavigatorFilterView extends ViewPart implements ResourceModelSetListener,IDoubleClickListener {

	private static final Logger logger = Logger.getLogger(DeviceNavigatorFilterView.class);

	public static final String VIEW_ID = "org.eclipse.sensinact.studio.navigator.device";

	private TreeViewer viewer;
	private NavigatorContentService contentService;

	private FilteredTree tree;

	@Override
	public void createPartControl(Composite aParent) {

		contentService = new NavigatorContentService(super.getViewSite().getId());
		
		PatternFilter filter = new SensinactPatternFilter();
		filter.setIncludeLeadingWildcard(true);
		tree = new SensinactFilteredTree(this, aParent, SWT.H_SCROLL | SWT.V_SCROLL, filter, true);
		viewer = tree.getViewer();
		getSite().setSelectionProvider(viewer);
		GridData gd = new GridData(GridData.FILL_BOTH);
		tree.setLayoutData(gd);
				
		viewer.setSorter(new DeviceNavigatorSorter());
		viewer.setContentProvider(new DeviceNavigatorContentProvider());
		viewer.setLabelProvider(new DeviceNavigatorLabelProvider());
		viewer.setSelection(getSite().getSelectionProvider().getSelection());
		
		INavigatorContentService ncs = contentService;//getSite().getService(INavigatorContentService.class);
		CommonDragAdapter cd = new CommonDragAdapter(ncs, getSite().getSelectionProvider());
		int ops = org.eclipse.swt.dnd.DND.DROP_MOVE | org.eclipse.swt.dnd.DND.DROP_COPY;
		Transfer[] transfers = new Transfer[] { TextTransfer.getInstance() };
		viewer.addDragSupport(ops, transfers, cd);
		viewer.addDoubleClickListener(this);
		
		try {
			tree.getViewer().setInput(ModelEditor.getInstance().getViewerInput());
		} catch (InterruptedException e) {
			logger.error("Error while setting input for the view", e);
		} 
		
		IHandlerService handlerService = (IHandlerService) getSite()
				.getService(IHandlerService.class);
		OpenResourceInvokerHandler invoker=new OpenResourceInvokerHandler();
		handlerService.activateHandler(VIEW_ID,invoker);
		
		MenuManager menuMgr = new MenuManager();
		Menu menu = menuMgr.createContextMenu(tree.getViewer().getControl());
		tree.getViewer().getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, tree.getViewer());

		ResourceModelSetManager.getInstance().subscribe(this);
	}
	
	@Override
	public void doubleClick(DoubleClickEvent event) {

		IStructuredSelection selection = (IStructuredSelection) event.getSelection();
		Object element = selection.getFirstElement();
		Shell parent = getViewSite().getShell();
		
		if (element != null && element instanceof Resource) {
			Resource resource = (Resource) element;
			BasicQueryResourceHelper manager = new BasicQueryResourceHelper(parent, resource);
			try {
				manager.execute();
			} catch (InterruptedException e) {
				logger.error("Error during double click handler processing", e);
			}
		}

		if (element != null && element instanceof Gateway) {
			Gateway gateway = (Gateway) element;
			GatewayHttpConfig config = ConfigurationManager.getGateway(gateway.getName());
			
			if (config == null) {
				MessageDialog.openError(parent, "Error", "Can't find gateway " + gateway.getName());
				logger.error("Can't find gateway " + gateway.getName());
			} else {
				GatewayConfigDialog dialog = new GatewayConfigDialog(parent, config.getName(), config.getURL().getHost(), config.getURL().getPort(), config.getTimeout(), config.getUsername(), config.getPassword());
				
				if (dialog.open() == Window.OK) {
					GatewayHttpConfig gatewayConfig = dialog.getGateway();
					if (! ConfigurationManager.addGateway(gatewayConfig))
						MessageDialog.openError(parent, "Update Error", "Please check logs.");
				}
			}
		}
	}
	

	@Override
	public void modelSetUpdated(ResourceSetChangeEvent event) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				if(contentService!=null){
					contentService.getActivationService().persistExtensionActivations();
					contentService.update();
					contentService.dispose();
				}
//				tree.update();
				viewer.refresh();
			}
		});
	}

	@Override
	public void setFocus() {
		viewer.getTree().setFocus();		
	}
}
