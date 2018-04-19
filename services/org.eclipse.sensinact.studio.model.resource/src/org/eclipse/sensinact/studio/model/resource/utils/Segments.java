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

import java.util.Arrays;
import java.util.List;

import org.restlet.resource.ClientResource;

import org.eclipse.sensinact.studio.resource.AccessMethodType;

/**
 * This class is used to represents a REST path in the sensinact API.
 * For any refactoring in the rest API, just update this (and only this)
 * class.
 * 
 * There is a nested class, called Builder, which goal is to build
 * Segment instance, checking if constraints are satisfied.
 * @author Etienne Gandrille
 */
public class Segments {
	
	private final List<String> segments;
	private final String gateway;

	private static final String ROOT_SEGMENT = "sensinact";
	private static final String JSON_ROOT_SEGMENT = "jsonpath:sensinact";
	private static final String PROVIDERS  = "providers";
	private static final String SERVICES = "services";
	private static final String RESOURCES = "resources";
	private static final String LOGIN = "login";
	private static final String AGENT_SUBSCRIBE = "SUBSCRIBE";
	private static final String AGENT_UNSUBSCRIBE = "UNSUBSCRIBE";
	
	private Segments(String gateway, List<String> segments) {
		this.gateway = gateway;
		this.segments = segments;
	}
	
	public void addToClientResource(ClientResource clientResource) {
		for (String segment : segments) {
			clientResource.addSegment(segment);
		}
	}

	public String getGateway() {
		return gateway;
	}
	
	public List<String> getSegments() {
		return segments;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (String seg : segments) {
			sb.append("/");
			sb.append(seg);
		}
		return sb.toString();
	}

	public static class Builder {
		
		public Builder() {
		}

		public BuilderGateway gateway(String gatewayName) {
			return new BuilderGateway(gatewayName);
		}

		public BuilderResouce resource(ResourceDescriptor resource) {
			String gateway = resource.getGateway();
			String device = resource.getDevice();
			String service = resource.getService();
			String res = resource.getResource();
			
			return new BuilderResouce(gateway, device, service, res);
		}

		public BuilderDevice device(DeviceDescriptor descriptor) {
			return new BuilderDevice(descriptor.getGateway(), descriptor.getDevice());
		}
	}
	
	public static class BuilderGateway {
		private final String gateway; 		
		public BuilderGateway(String gateway) {
			this.gateway = gateway;
		}
		
		public BuilderDevice device(String deviceId) {
			return new BuilderDevice(gateway, deviceId);
		}
		
		public BuilderLocation locations() {
			return new BuilderLocation(gateway);
		}
		
		public BuilderReady devices() {
			return new BuilderReady(gateway, ROOT_SEGMENT, PROVIDERS);
		}
		
		public BuilderReady jsonPath() {
			return new BuilderReady(gateway, JSON_ROOT_SEGMENT);
		}
		
		public BuilderReady jsonPath(String expr) {
			return new BuilderReady(gateway, JSON_ROOT_SEGMENT + "?" + expr);
		}

		public BuilderReady login() {
			return new BuilderReady(gateway, LOGIN);
		}

		public BuilderReady subscribeAgent() {
			return new BuilderReady(gateway, ROOT_SEGMENT, AGENT_SUBSCRIBE);
		}
		
		public BuilderReady unsubscribeAgent() {
			return new BuilderReady(gateway, ROOT_SEGMENT, AGENT_UNSUBSCRIBE);
		}
	}
	
	public static class BuilderDevice {
		private final String gateway;
		private final String device;
		public BuilderDevice(String gateway, String device) {
			this.gateway = gateway;
			this.device = device;
		}
		
		public BuilderReady services() {
			return new BuilderReady(gateway, ROOT_SEGMENT, PROVIDERS, device, SERVICES);
		}

		public BuilderService service(String serviceId) {
			return new BuilderService(gateway, device, serviceId);
		}
	}
		
	public static class BuilderLocation {
		private final String gateway;
		public BuilderLocation(String gateway) {
			this.gateway = gateway;
		}
		
		public BuilderReady getLocations() {
			return new BuilderReady(gateway, "jsonpath", "location","GET");
		}
	}
	
	public static class BuilderService {
		private final String gateway;
		private final String device;
		private final String service;
		public BuilderService(String gateway, String device, String service) {
			this.gateway = gateway;
			this.device = device;
			this.service = service;
		}
		
		public BuilderReady resources() {
			return new BuilderReady(gateway, ROOT_SEGMENT, PROVIDERS, device, SERVICES, service, RESOURCES);
		}

		public BuilderResouce resource(String resource) {
			return new BuilderResouce(gateway, device, service, resource);
		}
	}
	
	public static class BuilderResouce {
		private final String gateway;
		private final String device;
		private final String service;
		private final String resource;
		
		public BuilderResouce(String gateway, String device, String service, String resource) {
			this.gateway = gateway;
			this.device = device;
			this.service = service;
			this.resource = resource;
		}
		
		public Segments build() {
			return new BuilderReady(gateway, ROOT_SEGMENT, PROVIDERS, device, SERVICES, service, RESOURCES, resource).build();
		}
		
		public BuilderReady method(AccessMethodType access) {
			return new BuilderReady(gateway, ROOT_SEGMENT, PROVIDERS, device, SERVICES, service, RESOURCES, resource, access.getName());
		}
	}
	
	public static class BuilderReady {
		private final List<String> segments;
		private final String gateway;
		
		private BuilderReady(String gateway, String... segments) {
			this.gateway = gateway;
			this.segments = Arrays.asList(segments);
			if (this.segments.size() == 0)
				throw new IllegalArgumentException("no segments available");
			for (String segment : segments) {
				if (segment == null || segment.isEmpty())
					throw new IllegalArgumentException("a segment is null or empty");
			}
		}
				
		public Segments build() {
			return new Segments(gateway, segments);
		}
	}
}
