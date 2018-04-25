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
package org.eclipse.sensinact.studio.http.services.client.websockets;

import java.net.ConnectException;
import java.net.URI;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;

/**
 * @author Jander Nascimento
 */
public class SensinactWebSocketConnectionManager implements Cloneable {
	
	private static final Logger logger = Logger.getLogger(SensinactWebSocketConnectionManager.class);
	private static SensinactWebSocketConnectionManager instance;
	private HashMap<String, WebSocketClient> servers=new HashMap<String, WebSocketClient>();
	private HashMap<String, SensinactSocket> sockets=new HashMap<String, SensinactSocket>();

	private SensinactWebSocketConnectionManager() {
	}

	public static SensinactWebSocketConnectionManager getInstance() {

		if (instance == null) {
			instance = new SensinactWebSocketConnectionManager();
		}

		return instance;
	}

	public void connect(String gatewayName, URI url) throws ConnectException {
		ClientUpgradeRequest request = new ClientUpgradeRequest();
		SensinactSocket socket = new SensinactSocket(gatewayName);
		WebSocketClient client = new WebSocketClient();
		try {
			client.start();
			client.connect(socket, url, request);
			socket.awaitClose(5, TimeUnit.SECONDS);
			servers.put(gatewayName,client);
			sockets.put(gatewayName,socket);
		} catch (Throwable t) {
			throw new ConnectException();
		}
	}
	
	public void disconnect(String gatewayName){
		WebSocketClient client=servers.remove(gatewayName);
		SensinactSocket socket=sockets.remove(gatewayName);
		if(client!=null&&socket.getSession()!=null&&socket.getSession().getRemote()!=null){
			try {
				socket.getSession().getRemote().sendString(gatewayName+": Bye bye");
				client.stop();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			logger.warn(String.format("Client %s is not available thus could not be removed from the list of connected websocket servers",gatewayName).toString());
		}
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("This class is a singleton and cannot be cloned");
	}
}
