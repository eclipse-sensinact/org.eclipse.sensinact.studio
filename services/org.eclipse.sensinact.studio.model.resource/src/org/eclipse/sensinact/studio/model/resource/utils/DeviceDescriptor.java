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
public class DeviceDescriptor {

	private final String gateway;
	private final String device;
	
	public DeviceDescriptor(String gateway, String device) {
		this.gateway = gateway; 
		this.device = device;
	}

	public String getGateway() {
		return gateway;
	}

	public String getDevice() {
		return device;
	}
	
	@Override
	public String toString() {
		return getGateway() + "/" + getDevice();
	}
	
	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (!(other instanceof ResourceDescriptor))
			return false;
		final ResourceDescriptor that = (ResourceDescriptor) other;
		return eqStr(this.getGateway(), that.getGateway()) && eqStr(this.getDevice(), that.getDevice());
	}

	public int hashCode() {
		return hash(gateway) * hash(device);
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
