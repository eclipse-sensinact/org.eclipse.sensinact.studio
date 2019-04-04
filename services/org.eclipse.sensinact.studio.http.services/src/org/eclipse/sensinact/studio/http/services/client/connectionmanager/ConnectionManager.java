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
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * @author Etienne Gandrille
 */
public class ConnectionManager {

	private static final Logger logger = Logger.getLogger(ConnectionManager.class);

	private static ConnectionManager INSTANCE = null;

	private final Map<String, Connection> conByGateway = new HashMap<>();
	
	private ConnectionManager() {
	}

	public synchronized static ConnectionManager getInstance() {
		if (INSTANCE == null)
			INSTANCE = new ConnectionManager();
		return INSTANCE;
	}
	
	public void connect(String gatewayName, URI url) throws ConnectException {
		logger.info("Connecting gateway " + gatewayName);
		Connection existingCon = conByGateway.get(gatewayName);
		if (existingCon != null) {
			if (! existingCon.isConnected()) {
				existingCon.connect(url);
			}
		} else {
			Connection con = new Connection(gatewayName);
			conByGateway.put(gatewayName, con);
			con.connect(url);
		}
	}
	
	public void disconnect(String gatewayName) throws ConnectException {
		logger.info("Disconnecting gateway " + gatewayName);
		Connection existingCon = conByGateway.get(gatewayName);
		if (existingCon == null) {
			throw new ConnectException("Gateway " + gatewayName + " is NOT connected");
		}
		existingCon.disconnect();
	}

	public boolean isConnected(String gatewayName) {
		Connection existingCon = conByGateway.get(gatewayName);
		if (existingCon != null) {
			return existingCon.isConnected();
		}
		return false;
	}
}
