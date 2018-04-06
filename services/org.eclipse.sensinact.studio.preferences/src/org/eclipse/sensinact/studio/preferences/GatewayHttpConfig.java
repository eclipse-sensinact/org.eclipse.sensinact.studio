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
package org.eclipse.sensinact.studio.preferences;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Etienne Gandrille
 */
public class GatewayHttpConfig {

	private final String name;
	private final URL gatewayURL;
	private final int timeout;
	private final String username;
	private final String password;
	
	public GatewayHttpConfig(String name, String address, int port, int timeout, String username, String password) {
		this(name, generateGatewayURL(address, port), timeout, username, password);		
	}
	
	private static URL generateGatewayURL(String address, int port) {
		if (address == null || address.isEmpty())
			throw new IllegalArgumentException("address can't be null or empty");
		if (address.startsWith("http://")) {
			address = address.substring(7, address.length());
		}
		
		if (port <= 0)
			throw new IllegalArgumentException("port must be positive");
		
		try {
			return new URL("http", address, port, "");
		} catch (MalformedURLException e) {
			throw new IllegalArgumentException("Malformed URL", e);
		}
	}

	public GatewayHttpConfig(String name, URL gatewayURL, int timeout, String username, String password) {	
		if (name == null || name.isEmpty())
			throw new IllegalArgumentException("name can't be null or empty");
		this.name = name;
		
		if (gatewayURL == null)
			throw new IllegalArgumentException("gatewayURL can't be null");
		this.gatewayURL = gatewayURL ;
		
		if (timeout <= 0)
			throw new IllegalArgumentException("timeout must be positive");
		this.timeout = timeout;
		
		this.username = username == null ? "" : username;
		this.password = password == null ? "" : password;
	}
	
	public boolean hasAuthentication() {
		return username != null && (!username.isEmpty());
	}
	
	public String getName() {
		return name;
	}
	
	public URL getURL() {
		return gatewayURL;
	}
	
	public int getTimeout() {
		return timeout;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	@Override
	public String toString() {
		return gatewayURL.toString();
	}

	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (!(other instanceof GatewayHttpConfig))
			return false;
		final GatewayHttpConfig that = (GatewayHttpConfig) other;
		return this.getTimeout() == that.getTimeout() && this.getURL() == that.getURL();
	}

	public int hashCode() {
		return gatewayURL.hashCode() + timeout;
	}
}
