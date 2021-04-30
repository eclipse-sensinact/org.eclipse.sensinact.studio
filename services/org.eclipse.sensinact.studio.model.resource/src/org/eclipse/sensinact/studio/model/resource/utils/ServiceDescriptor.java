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
package org.eclipse.sensinact.studio.model.resource.utils;


/**
 * @author Etienne Gandrille
 */
public class ServiceDescriptor extends AbstractDescriptor {

	private final String device;
	private final String service;

	public ServiceDescriptor(String gateway, String device, String service) {
		super(gateway);
		this.device = device;
		this.service = service;
	}

	public DeviceDescriptor toDeviceDescriptor() {
		return new DeviceDescriptor(gateway, device);
	}
	
	public String getDevice() {
		return device;
	}

	public String getService() {
		return service;
	}

	@Override
	public String getPath() {
		return  "/" + getDevice()+ "/" + getService();
	}
	
	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (!(other instanceof ServiceDescriptor))
			return false;
		final ServiceDescriptor that = (ServiceDescriptor) other;
		return eqStr(this.getGateway(), that.getGateway()) 
				&& eqStr(this.getDevice(), that.getDevice()) 
				&& eqStr(this.getService(), that.getService());
	}

	public int hashCode() {
		return hash(gateway) * hash(device) * hash(service);
	}

	private boolean eqStr(String str1, String str2) {
		if (str1 == null)
			if (str2 == null)
				return true;
			else
				return false;
		else
			return str1.equals(str2);
	}
	
	private int hash(String str) {
		if (str == null)
			return 2;
		else
			return str.hashCode();
	}
}
