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
package org.eclipse.sensinact.studio.http.services.client.connectionmanager;

import java.net.ConnectException;
import java.net.URI;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.sensinact.studio.http.services.client.subscribe.agent.Agent;
import org.eclipse.sensinact.studio.http.services.client.websockets.SensinactWebSocketConnectionManager;
import org.eclipse.sensinact.studio.preferences.ConfigurationManager;
import org.eclipse.sensinact.studio.preferences.GatewayHttpConfig;

/**
 * @author Etienne Gandrille
 */
public class ConnectionManager {

	private static final Logger logger = Logger.getLogger(ConnectionManager.class);

	private static ConnectionManager INSTANCE = null;

	private ConnectionManager() {
	}

	public synchronized static ConnectionManager getInstance() {
		if (INSTANCE == null)
			INSTANCE = new ConnectionManager();
		return INSTANCE;
	}

	
	public void connect(GatewayHttpConfig gateway, IProgressMonitor monitor) throws Exception {
		
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
		GatewayHttpConfig gatewayConfig = ConfigurationManager.getGateway(gateway.getName());
		logger.info("Connecting ws:" + String.format("ws://%s:8080/ws/sensinact", gatewayConfig.getURL().getHost()));
		URI echoUri = new URI(String.format("ws://%s:8080/ws/sensinact", gatewayConfig.getURL().getHost()));
		try {
			SensinactWebSocketConnectionManager.getInstance().connect(gateway.getName(), echoUri);
			websocketConnected=true;
		} catch(ConnectException e) {
			websocketConnected=false;
		}
		monitor.worked(50);
		monitor.setTaskName("Done.");
		
		if(!callbackRegistered && !websocketConnected) {
			throw new Exception();
		}
	}
	
	
	public void disconnect() {
		// TODO Auto-generated method stub
	}	
}
