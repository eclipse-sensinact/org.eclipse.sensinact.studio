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
package org.eclipse.sensinact.studio.navigator.device;

import org.apache.log4j.Logger;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;

/**
 * @author Etienne Gandrille
 */
public class DeviceNavigatorDecorator implements ILightweightLabelDecorator {

	private static final Logger logger = Logger.getLogger(DeviceNavigatorDecorator.class);

	public void decorate(Object element, IDecoration decoration) {

		/* TODO Santander Decorator
		
		if (element instanceof Service) {
			Service service = (Service) element;

			String deviceName = ((NamedElement) service.eContainer()).getName();
			String serviceName = service.getName();
			String resourceName = "accuracy";
			ResourceDescriptor descriptor = new ResourceDescriptor(deviceName, serviceName, resourceName);

			try {
				if (ModelEditor.existsResource(descriptor)) {
					StudioRequest request = new StudioRequest(descriptor, AccessMethodType.GET);
					try {
						HttpMessage response = request.sendRequest();
						if (response.isValid()) {
							ObjectMessage object = (ObjectMessage) response;
							String value = object.getJsonObject("value").getString("value");
							decoration.addPrefix("[" + value + "] ");
							double doubleVal = Double.parseDouble(value.replace(",", "."));

							if (doubleVal == 1) {
								decoration.setForegroundColor(green);
							} else if (doubleVal >= 0.50) {
								decoration.setForegroundColor(orange);
							} else {
								decoration.setForegroundColor(red);
							}
						}
					} catch (IOException | JSONException e) {
						logger.error("decorator error", e);
					}
				}
			} catch (InterruptedException e) {
				logger.error("decorator error", e);
			}
		}
		*/

		// ImageDescriptor descriptor = icons.get(readOnlyIconPath);
		// decoration.addOverlay(descriptor, IDecoration.BOTTOM_RIGHT);
	}

	public void addListener(ILabelProviderListener listener) {
	}

	public void dispose() {
	}

	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	public void removeListener(ILabelProviderListener listener) {
	}
}