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

import java.io.IOException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.util.Enumeration;

import org.apache.log4j.Logger;

/**
 * @author Etienne Gandrille
 */
public class StudioHttpConfig {

	private final int port;
	private final URL url;
	
	private static final Logger logger = Logger.getLogger(StudioHttpConfig.class);
	
	public StudioHttpConfig(GatewayHttpConfig gwConfig, int port) {
		this.port = port;		
		URL url = null;
		try {
			url = computeStudioURL(port, gwConfig);
		} catch (IOException e) {
			logger.error("Can't compute studio URL");
		}
		this.url = url;
	}

	public int getPort() {
		return port;
	}
	
	public URL getUrl() throws IOException {
		if (isValid())
			return url;
		throw new IOException("Didn't mange to compute the Studio URL");
	}
	
	public boolean isValid() {
		return url != null;
	}
	
	private static URL computeStudioURL(int studioPort, GatewayHttpConfig gwConfig) throws IOException {
		try {
			String gwHost = gwConfig.getURL().getHost();
			InetAddress inetAddressGateway = InetAddress.getByName(gwHost);
			String hostAddress = getHostAddress(inetAddressGateway, 1000);
			return new URL("http", hostAddress, studioPort, "");
		} catch (Exception e) {
			throw new IOException("Can't compute studio URL", e);
		}
	}
	
	private static String getHostAddress(InetAddress gatewayAddress, int timeout) throws SocketException, IOException {
		Enumeration<NetworkInterface> localInterfaces = NetworkInterface.getNetworkInterfaces();
		logger.info("Gateway address: " + gatewayAddress.getHostAddress());
		while (localInterfaces.hasMoreElements()) {
			NetworkInterface localInterface = localInterfaces.nextElement();
			logger.info(" * Analyzing Interface: " + localInterface.getInterfaceAddresses());

			Enumeration<InetAddress> addresses = localInterface.getInetAddresses();
			
			if(localInterface.isUp())
			while (addresses.hasMoreElements()) {
				InetAddress address = addresses.nextElement();
				logger.info("    - Verify IPv4: " + address.getHostAddress());
				if (address instanceof Inet4Address) {
					logger.debug("    - Checking IPv4 address: " + address);
					String retval = address.getHostAddress();
					if (retval != null && ! retval.isEmpty() && gatewayAddress.isReachable(localInterface, 64, timeout)) {
						logger.info("--> Selected for Studio IP --->"+retval);
						return retval;
					}
				} else if (address instanceof Inet6Address) {
					logger.debug("    - IPv6 address ignored: " + address);
				}
			}			
		}
		throw new IOException("Can't compute studio IP address");
	}
	
	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (!(other instanceof StudioHttpConfig))
			return false;
		final StudioHttpConfig that = (StudioHttpConfig) other;
		
		if (this.getPort() != that.getPort())
			return false;
		
		URL thisURL = null;
		try {
			thisURL = this.getUrl();
		} catch (IOException e) {
			// doNothing
		}
		
		URL thatURL = null;
		try {
			thatURL = that.getUrl();
		} catch (IOException e) {
			// doNothing
		}
		
		if (thisURL == null)
			return thatURL == null;
		return thisURL.equals(thatURL);
	}

	public int hashCode() {
		return url.hashCode() % (port+7);
	}
}
