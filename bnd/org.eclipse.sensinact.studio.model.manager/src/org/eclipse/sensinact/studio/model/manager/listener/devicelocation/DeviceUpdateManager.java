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

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.sensinact.studio.model.manager.modelupdater.ModelEditor;
import org.eclipse.sensinact.studio.model.manager.modelupdater.ModelUpdater;
import org.eclipse.sensinact.studio.model.resource.utils.DeviceDescriptor;
import org.eclipse.sensinact.studio.model.resource.utils.GPScoordinates;
import org.eclipse.sensinact.studio.model.resource.utils.GPSparsingException;
import org.eclipse.sensinact.studio.resource.Device;
import org.eclipse.sensinact.studio.resource.Gateway;
import org.eclipse.sensinact.studio.resource.Service;

/**
 * @author Etienne Gandrille
 * @contributor Christophe Munilla
 */
public class DeviceUpdateManager implements INotifyChangedListener {

	private static DeviceUpdateManager INSTANCE = null;
	private static final Logger logger = Logger.getLogger(DeviceUpdateManager.class);

	private final Set<DeviceLocationListener> locationListeners = new HashSet<DeviceLocationListener>();
	private final Set<DeviceIconListener> iconListeners = new HashSet<DeviceIconListener>();
	private final Set<DeviceSelectionListener> selectionListeners = new HashSet<DeviceSelectionListener>();

	public synchronized static DeviceUpdateManager getInstance() {
		if (INSTANCE == null)
			INSTANCE = new DeviceUpdateManager();
		return INSTANCE;
	}
	
	DeviceUpdateManager() {
		ModelEditor.getInstance().addNotifyChangedListener(this);
	}

	@Override
	public void notifyChanged(Notification arg0) {		
		if(arg0.getEventType() == Notification.SET && arg0.getFeature() instanceof EAttribute) {
			if("location".equals(((EAttribute)arg0.getFeature()).getName())) {
				try {
					DeviceDescriptor descriptor = new DeviceDescriptor(((Gateway)((EObject)
						arg0.getNotifier()).eContainer()).getName(), ((Device)arg0.getNotifier()
								).getName());
					
					descriptor.setIcon(((Device)arg0.getNotifier()).getIcon());
					descriptor.setLocation((String) arg0.getNewValue());
					
					GPScoordinates gps = new GPScoordinates((String) arg0.getNewValue());

					for (DeviceLocationListener listener : locationListeners) {
						listener.deviceLocationUpdated(gps,descriptor);
					}
				} catch (GPSparsingException e) {				
					logger.error(e.getMessage(),e); 
				}
			}
			if("icon".equals(((EAttribute)arg0.getFeature()).getName())) {
				DeviceDescriptor descriptor = new DeviceDescriptor(((Gateway)((EObject)
					arg0.getNotifier()).eContainer()).getName(), ((Device)arg0.getNotifier()
							).getName());
				
				descriptor.setLocation(((Device)arg0.getNotifier()).getLocation());
				descriptor.setIcon((String) arg0.getNewValue());
				
				for (DeviceIconListener listener : iconListeners) {
					listener.deviceIconUpdated(descriptor);
				}
			}
		} else if(arg0.getEventType() == Notification.REMOVE 
				&& arg0.getNotifier() instanceof Gateway
				&& arg0.getOldValue() instanceof Device){			
			
			DeviceDescriptor descriptor = new DeviceDescriptor(((Gateway)
				arg0.getNotifier()).getName(), ((Device)arg0.getOldValue()
						).getName());
			
			for (DeviceLocationListener listener : locationListeners) {
				listener.deviceRemoved(descriptor);
			}
		} else if(arg0.getEventType() == Notification.ADD) {
		
			if(arg0.getNotifier() instanceof Gateway && arg0.getNewValue() instanceof Device){			
			
				DeviceDescriptor descriptor = new DeviceDescriptor(((Gateway)
					arg0.getNotifier()).getName(), ((Device)arg0.getNewValue()
							).getName());	
				
				String location = ((Device)arg0.getNewValue()).getLocation();
				String icon = ((Device)arg0.getNewValue()).getIcon();
				
				descriptor.setIcon(icon);
				descriptor.setLocation(location);
				
				if(location != null && !"null".equals(location)) {			
					GPScoordinates gps = null;
					try {
						gps = new GPScoordinates(((Device)arg0.getNewValue()).getLocation());
					} catch (GPSparsingException e) {				
						e.printStackTrace();
					}
					for (DeviceLocationListener listener : locationListeners) {
						listener.deviceLocationUpdated(gps, descriptor);;
					}
				}
				if(icon != null && !"null".equals(icon)) {
					for (DeviceIconListener listener : iconListeners) {
						listener.deviceIconUpdated(descriptor);
					}
				}
				try {
					ModelUpdater.getInstance().updateServices(((Gateway)
						arg0.getNotifier()).getName(), ((Device)arg0.getNewValue()
								).getName());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else if(arg0.getNotifier() instanceof Device && arg0.getNewValue() instanceof Service){			
				try {
					ModelUpdater.getInstance().updateResources(((Gateway)((Device)(arg0.getNotifier())).eContainer()).getName(), 
						((Device)arg0.getNotifier()).getName(), ((Service)arg0.getNewValue()
								).getName());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
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
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public void updateDeviceSelection(GPScoordinates coordinates) {		
		for (DeviceSelectionListener listener : selectionListeners) {
				listener.deviceSelected(coordinates);
		}
	}
	
	private boolean needUpdate(DeviceDescriptor deviceDescriptor, GPScoordinates newCoordinates) {
		GPScoordinates oldCoordinates = ModelEditor.getInstance().getLocation(deviceDescriptor);		
		return (! newCoordinates.equals(oldCoordinates));
	}

	public void removeDeviceIconListener(DeviceIconListener listener) {
		iconListeners.remove(listener);
	}

	public void addDeviceIconListener(DeviceIconListener listener) {
		iconListeners.add(listener);
	}

	
	public void removeDeviceLocationListener(DeviceLocationListener listener) {
		locationListeners.remove(listener);
	}

	public void addDeviceLocationListener(DeviceLocationListener listener) {
		locationListeners.add(listener);
	}

	public void removeDeviceSelectionListener(DeviceSelectionListener listener) {
		selectionListeners.remove(listener);
	}

	public void addDeviceSelectionListener(DeviceSelectionListener listener) {
		selectionListeners.add(listener);
	}

	public void deleteDeviceInStudio(DeviceDescriptor deviceDescriptor) {
		if(deviceDescriptor == null)
			return;
		logger.debug("Device location removed for " + deviceDescriptor + ". Notification fired (" + locationListeners.size() + " listeners");
		for (DeviceLocationListener listener : locationListeners) {
			listener.deviceRemoved(deviceDescriptor);
		}
	}
	
	public void deleteGatewayInStudio(String gatewayName) {
		// for iterating safely over the keyset while deleting elements in the map
		List<String> list  = ModelEditor.getInstance().getDevicesId(gatewayName);
		list.stream().forEach(d -> deleteDeviceInStudio(ModelEditor.getInstance().getDeviceDescriptor(gatewayName, d)));
	}
	
	public GPScoordinates getKnownLocation(DeviceDescriptor deviceDescriptor) {
		DeviceDescriptor desc =  ModelEditor.getInstance().getDeviceDescriptor(deviceDescriptor.getGateway(),deviceDescriptor.getDevice());
		if(desc == null )
			return null;
		String location = desc.getLocation();
		if(location == null)
			return null;
		String[] coordinates = location.split(":");
		if(coordinates.length != 2)
			return null;
		try {
			return new GPScoordinates(Double.parseDouble(coordinates[0]),Double.parseDouble(coordinates[1]));
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
