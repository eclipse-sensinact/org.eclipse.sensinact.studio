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
package org.eclipse.sensinact.studio.navigator.device.toolbar;

import java.lang.reflect.InvocationTargetException;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.sensinact.studio.http.services.client.subscribe.agent.Agent;
import org.eclipse.sensinact.studio.model.manager.modelupdater.ModelUpdater;
import org.eclipse.sensinact.studio.preferences.ConfigurationManager;
import org.eclipse.sensinact.studio.preferences.GatewayHttpConfig;
import org.eclipse.sensinact.studio.resource.Gateway;
import org.eclipse.sensinact.studio.ui.common.dialog.SnaHandler;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * @author Etienne Gandrille
 */
public class ConnectHandler extends SnaHandler {
	
	private static final Logger logger = Logger.getLogger(ConnectHandler.class);

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		Shell parent = getShell(event);

		Object element = getSelectedElement(event);
		if (element != null && element instanceof Gateway) {
			Gateway gateway = (Gateway) element;
			String name = gateway.getName();
			GatewayHttpConfig gwConfig = ConfigurationManager.getGateway(name);
			if (gwConfig == null) {
				MessageDialog.openError(parent, "Error", "Can't find gateway info.");
				logger.error("Error while getting gateway config for " + name);
			} else if (Agent.getInstance().isConnected(name)) {
				MessageDialog.openError(parent, "Error", "Gateway already connected.");
			} else {
				connect(parent, gwConfig);
			}
		} else {
			MessageDialog.openError(parent, "Error", "Please select a gateway in the tree viewer.");
		}

		return null;
	}

	private void connect(final Shell parent, final GatewayHttpConfig gateway) {

		ProgressMonitorDialog dialog = new ProgressMonitorDialog(parent);

		try {
			dialog.run(false, false, new IRunnableWithProgress() {
				public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
					ModelUpdater mu = ModelUpdater.getInstance();
					monitor.subTask("Fetching devices from:" + gateway.getURL());
					try {
						mu.updateDevices(gateway.getName());
						if (monitor.isCanceled()) {
							throw new InterruptedException("Operation Canceled");
						}
						monitor.worked(100);
						Job connectJob=new ConnectJob(gateway,parent);
						connectJob.schedule();
					} catch (Exception e) {
						Display.getDefault().asyncExec(new Runnable() {
							 public void run() {
								 MessageDialog.openError(parent, "Connection Error", "Connection failed.");
							 }
							});
						throw new InvocationTargetException(new Exception("Connection Failed"));
					}
				}
			});
		} catch (Exception e2) {
			logger.error("Exception during update", e2);
		}
	}
}
