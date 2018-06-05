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

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sensinact.studio.http.services.client.connectionmanager.ConnectionManager;
import org.eclipse.sensinact.studio.preferences.GatewayHttpConfig;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * @author Etienne Gandrille
 */
public class ConnectJob extends Job {

	private static final Logger logger = Logger.getLogger(ConnectJob.class);
	
	private final GatewayHttpConfig gateway;
	private Shell parent;
	public ConnectJob(final GatewayHttpConfig gateway, Shell parent){
		super(gateway.getName());
		this.gateway=gateway;
		this.parent=parent;
	}
	
	@Override
	protected IStatus run(IProgressMonitor monitor) {
		super.setThread(new Thread());
		monitor.beginTask("Connecting...", 100);
		try {

			if (monitor.isCanceled()) {
				throw new InterruptedException("Operation Canceled");
			}
			monitor.setTaskName("Subscribing to server events");

			ConnectionManager.getInstance().connect(gateway, monitor);
			
		} catch (Exception e) {
			monitor.setCanceled(true);
			Display.getDefault().asyncExec(new Runnable() {
				 public void run() {
					 MessageDialog.openError(parent, "Connection Error", "Connection to the gateway couldn't be established");
				 }
			});
			
			return Status.CANCEL_STATUS;
		} finally {
			monitor.done();
		}
		
		return Status.OK_STATUS;
	}
}
