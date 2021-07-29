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

import org.eclipse.sensinact.studio.model.resource.utils.DeviceDescriptor;
import org.eclipse.sensinact.studio.model.resource.utils.GPScoordinates;

/**
 * @author Etienne Gandrille
 */
public interface DeviceLocationListener {

	public void deviceLocationUpdated(GPScoordinates coordinate, DeviceDescriptor descriptor);
	
	public void deviceRemoved(DeviceDescriptor descriptor);
}
