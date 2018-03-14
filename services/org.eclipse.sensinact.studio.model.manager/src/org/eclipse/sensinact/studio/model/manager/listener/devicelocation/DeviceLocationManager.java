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
package org.eclipse.sensinact.studio.model.manager.listener.devicelocation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.sensinact.studio.model.manager.modelupdater.ModelUpdater;
import org.eclipse.sensinact.studio.model.resource.utils.DeviceDescriptor;
import org.eclipse.sensinact.studio.model.resource.utils.GPScoordinates;

/**
 * @author Etienne Gandrille
 */
public class DeviceLocationManager {

	private static final Logger logger = Logger.getLogger(DeviceLocationManager.class);
	
	private static DeviceLocationManager INSTANCE = null;
	private final Set<DeviceLocationListener> locationListeners = new HashSet<DeviceLocationListener>();

	private final Map<DeviceDescriptor, GPScoordinates> locations = new HashMap<DeviceDescriptor, GPScoordinates>();  
	
	private DeviceLocationManager() {
	}

	public static DeviceLocationManager getInstance() {
		if (INSTANCE == null)
			INSTANCE = new DeviceLocationManager();
		return INSTANCE;
	}

	public void removeDeviceLocationListener(DeviceLocationListener listener) {
		locationListeners.remove(listener);
	}

	public void addDeviceLocationListener(DeviceLocationListener listener) {
		locationListeners.add(listener);
	}

	public void updateLocationInStudio(DeviceDescriptor deviceDescriptor, GPScoordinates newCoordinates) {
		if (needUpdate(deviceDescriptor, newCoordinates)) {
			locations.put(deviceDescriptor, newCoordinates);
			logger.debug("Device location updated for " + deviceDescriptor + ". Notification fired (" + locationListeners.size() + " listeners");
			for (DeviceLocationListener listener : locationListeners) {
				listener.deviceLocationUpdated(newCoordinates, deviceDescriptor);
			}
		}
	}

	public void deleteGatewayInStudio(String gatewayName) {
		// for iterating safely over the keyset while deleting elements in the map
		DeviceDescriptor[] tab = locations.keySet().toArray(new DeviceDescriptor[0]);
		
		for (int i=0; i<tab.length; i++) {
			DeviceDescriptor descriptor = tab [i];
			if (descriptor.getGateway() != null && descriptor.getGateway().equals(gatewayName)) {
				deleteDeviceInStudio(descriptor);
			}
		}
	}
	
	public void deleteDeviceInStudio(DeviceDescriptor deviceDescriptor) {
		locations.remove(deviceDescriptor);
		logger.debug("Device location removed for " + deviceDescriptor + ". Notification fired (" + locationListeners.size() + " listeners");
		for (DeviceLocationListener listener : locationListeners) {
			listener.deviceRemoved(deviceDescriptor);
		}
	}
	
	public GPScoordinates getKnownLocation(DeviceDescriptor deviceDescriptor) {
		return locations.get(deviceDescriptor);
	}
	
	/**
	 * 
	 * @param deviceDescriptor
	 * @param newCoordinates
	 * @return true if success, false if update location failed. It happens when the location is not updatable. 
	 */
	public boolean updateLocationInServer(DeviceDescriptor deviceDescriptor, GPScoordinates newCoordinates) {
		if (needUpdate(deviceDescriptor, newCoordinates)) {
			if (ModelUpdater.getInstance().updateLocationOnServer(deviceDescriptor, newCoordinates)) {
				locations.put(deviceDescriptor, newCoordinates);
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	private boolean needUpdate(DeviceDescriptor deviceDescriptor, GPScoordinates newCoordinates) {
		GPScoordinates oldCoordinates = locations.get(deviceDescriptor);
		return (! newCoordinates.equals(oldCoordinates));
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		boolean start = true;
		for (DeviceDescriptor deviceDescriptor : locations.keySet()) {
			if (start)
				start = false;
			else
				sb.append("\n");
			sb.append(deviceDescriptor);
			sb.append(" ");
			sb.append(locations.get(deviceDescriptor));
		}
		return sb.toString();
	}
}
