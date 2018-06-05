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


import java.util.ArrayList;
import java.util.List;

import org.osgi.service.prefs.BackingStoreException;
import org.osgi.service.prefs.Preferences;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;

/**
 * @author Etienne Gandrille
 */
public class ConfigurationManager {

	private static String NODE = ConfigurationManager.class.getName();
	private static String GATEWAYS_NODE = "gateway";
	private static String STUDIO_NODE = "studio";
	private static String ADDRESS_KEY = "address";
	private static String PORT_KEY = "port";
	private static String TIMEOUT_KEY = "timeout";
	private static String USERNAME_KEY = "username";
	private static String PASSWORD_KEY = "password";
		
	private static final Logger logger = Logger.getLogger(ConfigurationManager.class);
	
	public static final List<ConfigurationListerner> listeners = new ArrayList<>();
	
	private ConfigurationManager() {	
	}

	/* ========= */
	/* LISTENERS */
	/* ========= */
	
	public static void addListener(ConfigurationListerner listener) {
		listeners.add(listener);
	}
	
	public static void removeListener(ConfigurationListerner listener) {
		listeners.remove(listener);
	}
	
	/* ======= */
	/* GETTERS */
	/* ======= */
	
	public static GatewayHttpConfig[] getGateways() {
		List<GatewayHttpConfig> gateways = new ArrayList<GatewayHttpConfig>();
		
		IEclipsePreferences root = ConfigurationScope.INSTANCE.getNode(NODE);
		Preferences gatewaysNode = root.node(GATEWAYS_NODE);
		
		try {
			for (String name : gatewaysNode.childrenNames()) {
				Preferences gwPref = gatewaysNode.node(name);
				String address = gwPref.get(ADDRESS_KEY, "");
				int port = gwPref.getInt(PORT_KEY, 0);
				int timeout = gwPref.getInt(TIMEOUT_KEY, 0);
				String username = gwPref.get(USERNAME_KEY, "");
				String password = gwPref.get(PASSWORD_KEY, "");
				
				try {
					GatewayHttpConfig gateway = new GatewayHttpConfig(name, address, port, timeout, username, password);
					gateways.add(gateway);
				} catch (IllegalArgumentException e) {
					// ignore
				}
			}
		} catch (BackingStoreException e) {
			logger.error("Preferences read failed", e);
		}
		
		return gateways.toArray(new GatewayHttpConfig[0]);
	}
	
	public static String[] getGatewayNames() {
		List<String> names = new ArrayList<>();
		
		for (GatewayHttpConfig gateway : getGateways())
			names.add(gateway.getName());
		
		return names.toArray(new String[0]);
	}
	
	public static GatewayHttpConfig getGateway(String name) {
		for (GatewayHttpConfig gateway : getGateways())
			if (gateway.getName().equals(name))
				return gateway;
		return null;
	}	
	
	public static int getStudioPort() {
		IEclipsePreferences root = ConfigurationScope.INSTANCE.getNode(NODE);
		Preferences studioNode = root.node(STUDIO_NODE);
		return studioNode.getInt(PORT_KEY, 8081);
	}
	
	/* ======= */
	/* UPDATES */
	/* ======= */
	
	public static boolean addGateway(GatewayHttpConfig gateway) {
		
		IEclipsePreferences root = ConfigurationScope.INSTANCE.getNode(NODE);
		Preferences gatewaysNode = root.node(GATEWAYS_NODE);

		Preferences curGatewayNode = gatewaysNode.node(gateway.getName());
		curGatewayNode.put(ADDRESS_KEY, gateway.getURL().getHost());
		curGatewayNode.putInt(PORT_KEY, gateway.getURL().getPort());
		curGatewayNode.putInt(TIMEOUT_KEY, gateway.getTimeout());
		curGatewayNode.put(USERNAME_KEY, gateway.getUsername());
		curGatewayNode.put(PASSWORD_KEY, gateway.getPassword());	
		
		try {
			root.flush();
		} catch (BackingStoreException e) {
			logger.error("Preferences write failed", e);
			return false;
		}
		logger.info("Preferences write success");
		
		gatewayAddedOrUpdated(gateway);
		
		return true;
	}

	private static void gatewayAddedOrUpdated(GatewayHttpConfig gateway) {
		for (ConfigurationListerner listener : listeners)
			listener.gatewayAddedOrUpdatedNotif(gateway);
	}

	public static boolean removeGateway(String name) {
		IEclipsePreferences root = ConfigurationScope.INSTANCE.getNode(NODE);
		Preferences gatewaysNode = root.node(GATEWAYS_NODE);
		
		try {
			gatewaysNode.node(name).clear();
			root.flush();
		} catch (BackingStoreException e) {
			logger.error("Preferences remove failed", e);
			return false;
		}
		logger.trace("Preferences remove success");
		
		gatewayRemoved(name);
		
		return true;
	}
	
	private static void gatewayRemoved(String name) {
		for (ConfigurationListerner listener : listeners)
			listener.gatewayRemovedNotif(name);
	}
	
	public static boolean setStudioPort(int port) {
		IEclipsePreferences root = ConfigurationScope.INSTANCE.getNode(NODE);
		Preferences studioNode = root.node(STUDIO_NODE);
		
		studioNode.putInt(PORT_KEY, port);
		
		try {
			root.flush();
		} catch (BackingStoreException e) {
			logger.error("Preferences write failed", e);
			return false;
		}
		logger.info("Preferences write success");
		
		studioPortUpdated(port);
		
		return true;
	}

	private static void studioPortUpdated(int port) {
		for (ConfigurationListerner listener : listeners)
			listener.studioPortUpdatedNotif(port);
	}
}
