/**
 * Copyright (c) 2019 CEA.
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
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;

public class Connection {

	private final String gatewayName;
	
	private SensinactSocket socket;
	private WebSocketClient client;
	
	private static final Logger logger = Logger.getLogger(Connection.class);
	
	public Connection(String gatewayName) {
		this.gatewayName = gatewayName;
	}
	
	boolean isConnected() {
		return client != null && socket != null && socket.isConnected();
	}

	public void connect(URI url) throws ConnectException {
		if (isConnected())
			throw new ConnectException("Cant (re)connect gateway " + gatewayName + ": already connected");
		ClientUpgradeRequest request = new ClientUpgradeRequest();
		this.socket = new SensinactSocket(gatewayName);
		this.client = new WebSocketClient();
		
		try {
			client.start();
			client.connect(socket, url, request);
		} catch (Throwable t) {
			throw new ConnectException("Cant (re)connect gateway " + gatewayName + ": " + t.getMessage());
		}
	}

	public void disconnect() {
		if ( ! isConnected()) {
			logger.error("Can't disconnect " + gatewayName + ": gateway is NOT connected");
		}
		
		boolean error = false;
		if (client == null) {
			logger.error("Can't disconnect " + gatewayName + " correctly: client is null");
			error = true;
		}
		if (socket == null) {
			logger.error("Can't disconnect " + gatewayName + " correctly: socket is null");
			error = true;
		}
		
		if (!error) {
			try {
				socket.send(gatewayName+": Bye bye");
				client.stop();
			} catch (Exception e) {
				logger.error("Error closing websocket for gateway " + gatewayName, e);
			}
		}
		
		client = null;
		socket = null;
	}
}
