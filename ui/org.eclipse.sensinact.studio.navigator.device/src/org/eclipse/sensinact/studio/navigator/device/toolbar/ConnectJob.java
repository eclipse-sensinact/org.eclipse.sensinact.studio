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

import java.net.ConnectException;
import java.net.URI;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sensinact.studio.http.client.agent.Agent;
import org.eclipse.sensinact.studio.preferences.ConfigurationManager;
import org.eclipse.sensinact.studio.preferences.GatewayHttpConfig;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * @author Etienne Gandrille
 */
public class ConnectJob extends Job{

	private final GatewayHttpConfig gateway;
	private Shell parent;
	public ConnectJob(final GatewayHttpConfig gateway,Shell parent){
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

			boolean callbackRegistered;
			try {
				Agent.getInstance().subscribe(gateway);
				callbackRegistered = true;
			} catch (Exception e) {
				e.printStackTrace();
				callbackRegistered = false;
			}
			
			Boolean websocketConnected=false;
			monitor.worked(50);
			monitor.setTaskName("Connecting websocket");
			GatewayHttpConfig gatewayConfig=ConfigurationManager.getGateway(gateway.getName());
			System.out.println("Connecting ws:"+String.format("ws://%s:8080/ws/sensinact", gatewayConfig.getURL().getHost()));
			URI echoUri = new URI(String.format("ws://%s:8080/ws/sensinact", gatewayConfig.getURL().getHost()));
			try {
				SensinactWebSocketConnectionManager.getInstance().connect(gateway.getName(), echoUri);
				websocketConnected=true;
			}catch(ConnectException e){
				websocketConnected=false;
			}
			monitor.worked(50);
			monitor.setTaskName("Done.");
			
			if(!callbackRegistered && !websocketConnected){
				throw new Exception();
			}
			
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
