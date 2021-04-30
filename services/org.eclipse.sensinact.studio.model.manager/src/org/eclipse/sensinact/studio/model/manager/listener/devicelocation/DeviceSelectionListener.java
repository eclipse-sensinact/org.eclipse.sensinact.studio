package org.eclipse.sensinact.studio.model.manager.listener.devicelocation;

import org.eclipse.sensinact.studio.model.resource.utils.GPScoordinates;

/**
 *
 */
public interface DeviceSelectionListener {
	
	void deviceSelected(final GPScoordinates coordinate);
}
