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
public class ServiceDescriptor {
	
	private final String gateway;
	private final String device;
	private final String service;
	
	public ServiceDescriptor(String gateway, String device, String service) {
		super();
		this.gateway = gateway;
		this.device = device;
		this.service = service;
	}

	public String getGateway() {
		return gateway;
	}

	public String getDevice() {
		return device;
	}

	public String getService() {
		return service;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((device == null) ? 0 : device.hashCode());
		result = prime * result + ((gateway == null) ? 0 : gateway.hashCode());
		result = prime * result + ((service == null) ? 0 : service.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServiceDescriptor other = (ServiceDescriptor) obj;
		if (device == null) {
			if (other.device != null)
				return false;
		} else if (!device.equals(other.device))
			return false;
		if (gateway == null) {
			if (other.gateway != null)
				return false;
		} else if (!gateway.equals(other.gateway))
			return false;
		if (service == null) {
			if (other.service != null)
				return false;
		} else if (!service.equals(other.service))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ServiceDescriptor [gateway=" + gateway + ", device=" + device + ", service=" + service + "]";
	}
}
