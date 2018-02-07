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
public class ResourceDescriptor {

	private final String gateway;
	private final String device;
	private final String service;
	private final String resource;

	public ResourceDescriptor(String gateway, String device, String service, String resource) {
		this.gateway = gateway;
		this.device = device;
		this.service = service;
		this.resource = resource;
	}

	public ResourceDescriptor(String text) {
		// The substring removes the prefix and suffix used to refer to a resource in the SNA DSL, respectively remove the '[' and ']'.
		text = text.trim();
		if (text.startsWith("/") || text.startsWith("["))
			text = text.substring(1);
		if (text.endsWith("/") || text.endsWith("]"))
			text = text.substring(0, text.length()-1);
		
		String[] tokens = text.split("/");
		if (tokens.length != 4 && tokens.length != 5)
			throw new RuntimeException("Parsing fail while building ResourceDescriptor");
		 
		this.gateway  = tokens[0];
		this.device   = tokens[1];
		this.service  = tokens[2];
		this.resource = tokens[3];
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

	public String getResource() {
		return resource;
	}

	public String getGateway() {
		return gateway;
	}
	
	@Override
	public String toString() {
		return getGateway() + "/" + getDevice() + "/" + getService() + "/" + getResource();
	}
	
	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (!(other instanceof ResourceDescriptor))
			return false;
		final ResourceDescriptor that = (ResourceDescriptor) other;
		return eqStr(this.getGateway(), that.getGateway()) && eqStr(this.getDevice(), that.getDevice()) && eqStr(this.getService(), that.getService())
				&& eqStr(this.getResource(), that.getResource());
	}

	public int hashCode() {
		return hash(gateway) * hash(device) * hash(service) * hash(resource);
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
