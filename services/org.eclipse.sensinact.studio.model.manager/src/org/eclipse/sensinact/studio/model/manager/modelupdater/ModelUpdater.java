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
package org.eclipse.sensinact.studio.model.manager.modelupdater;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.naming.directory.InvalidAttributesException;

import org.apache.log4j.Logger;
import org.eclipse.sensinact.studio.http.client.GatewayHttpClient;
import org.eclipse.sensinact.studio.http.client.GatewayHttpClient.RequestParameter;
import org.eclipse.sensinact.studio.http.client.snamessage.ErrorMessage;
import org.eclipse.sensinact.studio.http.client.snamessage.JsonPathResponse;
import org.eclipse.sensinact.studio.http.client.snamessage.ResponseSetError;
import org.eclipse.sensinact.studio.http.client.snamessage.ResponseSetOK;
import org.eclipse.sensinact.studio.http.client.snamessage.RestResourcesList;
import org.eclipse.sensinact.studio.http.client.snamessage.SnaMessage;
import org.eclipse.sensinact.studio.http.client.snamessage.UpdateAttribute;
import org.eclipse.sensinact.studio.http.client.snamessage.gateway.LifecycleProviderAppearing;
import org.eclipse.sensinact.studio.http.client.snamessage.gateway.LifecycleProviderDisappearing;
import org.eclipse.sensinact.studio.http.client.snamessage.gateway.LifecycleResourceAppearing;
import org.eclipse.sensinact.studio.http.client.snamessage.gateway.LifecycleResourceDisappearing;
import org.eclipse.sensinact.studio.http.client.snamessage.gateway.LifecycleServiceAppearing;
import org.eclipse.sensinact.studio.http.client.snamessage.gateway.LifecycleServiceDisappearing;
import org.eclipse.sensinact.studio.model.manager.listener.devicelocation.DeviceLocationManager;
import org.eclipse.sensinact.studio.model.manager.listener.subscription.SubscriptionListener;
import org.eclipse.sensinact.studio.model.manager.listener.subscription.SubscriptionManager;
import org.eclipse.sensinact.studio.model.resource.utils.Constants;
import org.eclipse.sensinact.studio.model.resource.utils.DeviceDescriptor;
import org.eclipse.sensinact.studio.model.resource.utils.GPScoordinates;
import org.eclipse.sensinact.studio.model.resource.utils.ResourceDescriptor;
import org.eclipse.sensinact.studio.model.resource.utils.Segments;
import org.eclipse.sensinact.studio.resource.AccessMethodType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Central point for managing the connection with the SensiNact Gateway.
 * @author Nicolas Hili, Etienne Gandrille, Jander and others
 */
public class ModelUpdater implements SubscriptionListener {

	private static final Logger logger = Logger.getLogger(ModelUpdater.class);
	
	private static ModelUpdater INSTANCE;

	public static ModelUpdater getInstance() {
		if (INSTANCE == null)
			INSTANCE = new ModelUpdater();
		return INSTANCE;
	}

	private ModelUpdater() {
	}

	/**
	 * Get all devices from the gateway and updates the model.
	 * 
	 * @throws IOException
	 */
	public void updateDevices(final String gatewayName) throws IOException {
		
			logger.info("Full model update triggered");

			Segments segments = new Segments.Builder().gateway(gatewayName).jsonPath("?jsonpath=$.*['name','location']").build();

			// error handling
			SnaMessage snaMsg = GatewayHttpClient.sendGetRequest(segments);
			if (snaMsg instanceof ErrorMessage)
				throwExceptionOnError(snaMsg, "devices");
			
			List<NameValue> nameLocs = extractDevices((JsonPathResponse) snaMsg);
		
			// update devices list
			new Thread() {
				public void run() {
					try {
		
						// add devices						
						for (NameValue nl : nameLocs)
							ModelEditor.getInstance().addDeviceIfNotExist(gatewayName, nl.name);
						
						// remove device
						for (String localDevicesId : ModelEditor.getInstance().getDevicesId(gatewayName)) {
							Optional<NameValue> elem = nameLocs.stream().filter(nl -> nl.name.equals(localDevicesId)).findFirst();
							if( ! elem.isPresent()) {
								ModelEditor.getInstance().removeDevice(gatewayName, localDevicesId);
							}	
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}.start();
			
			// update locations
			for (NameValue nl : nameLocs)
				updateLocation(new DeviceDescriptor(gatewayName, nl.name), nl.value);
	}
		
	private List<NameValue> extractDevices(JsonPathResponse response) throws IOException {
		List<NameValue> nameLoc = new ArrayList<>();
		
		if (! response.isValid())
			throwExceptionOnError(response, "devices");

		try {
			JSONArray providersArray = response.getJson().getJSONArray("providers");
			for (int i=0; i<providersArray.length(); i++) {
				JSONObject elem = providersArray.getJSONObject(i);
				String name = elem.getString("name");
				String location = elem.getString("location");
				nameLoc.add(new NameValue(name, location));
			}
		} catch (Exception e) {
			throw new IOException("Can't parse provider array", e);
		}
		
		return nameLoc;
	}

	private static class NameValue {
		public final String name;
		public final String value;
		
		public NameValue(String name, String value) {
			this.name = name;
			this.value = value;
		}
	}	
	
	/**
	 * Get all services on a device, from the gateway, and updates the model.
	 * 
	 * @param device
	 *            the device from which services need to be retrieved
	 * @throws IOException
	 */
	public void updateServices(final String gatewayName, final String deviceId, boolean recursive) throws IOException {
		
		String expr = "jsonpath=$..*[?(@.name=='" + deviceId + "')]";
		Segments segments = new Segments.Builder().gateway(gatewayName).jsonPath(expr).build();

		// error handling
		SnaMessage snaMsg = GatewayHttpClient.sendGetRequest(segments);
		if (snaMsg instanceof ErrorMessage)
			throwExceptionOnError(snaMsg, "services");
		
		JsonPathResponse response = (JsonPathResponse) snaMsg;
		if (! response.isValid())
			throwExceptionOnError(snaMsg, "services");

		
		JSONObject json = response.getJson();
		try {
			JSONArray providerArray = json.getJSONArray("providers");
			JSONObject provider = providerArray.getJSONObject(0);
			
			// location update
			updateLocation(new DeviceDescriptor(gatewayName, deviceId), provider.getString("location"));
			
			// get services IDs
			JSONArray services = provider.getJSONArray("services");
			List<String> servicesIds = getServicesIds(services);
						
			// add service
			for (String serviceId : servicesIds) {
				ModelEditor.getInstance().addServiceIfNotExist(gatewayName, deviceId, serviceId);
				if(recursive) {
					List<NameValue> resources = getResourcesList(services, serviceId);
					updateResourcesList(gatewayName, deviceId, serviceId, resources);
				}
			}

			// remove service
			for (String localServicesId : ModelEditor.getInstance().getServicesId(gatewayName, deviceId)) {
				if(!servicesIds.contains(localServicesId)){
					ModelEditor.getInstance().removeService(gatewayName, deviceId, localServicesId);
				}
			}
			
		} catch (Exception e) {
			throw new IOException("Error while parsing json " + json, e);
		}
	}	

	private List<NameValue> getResourcesList(JSONArray services, String serviceId) throws JSONException {
		
		List<NameValue> list = new ArrayList<>();
		
		for (int i=0; i < services.length(); i++) {
			JSONObject service = services.getJSONObject(i);
			String name = service.getString("name");
			if (name.equals(serviceId)) {
				JSONArray array = service.getJSONArray("resources");
				for (int j=0; j<array.length(); j++) {
					JSONObject element = array.getJSONObject(j);
					list.add(new NameValue(element.getString("name"), element.getString("type")));
				}
				return list;
			}
		}
		return list;
	}

	private List<String> getServicesIds(JSONArray json) {
		List<String> list = new ArrayList<>();
		for (int i=0; i<json.length(); i++)
			try {
				list.add(json.getJSONObject(i).getString("name"));
			} catch (JSONException e) {
				logger.error("can't find service name in " + json);
			}
		return list;
	}
		
	/* ================ */
	/* Update resources */
	/* ================ */

	
	private void updateResourcesList(String gatewayName, String deviceId, String serviceId, List<NameValue> resources) throws IOException {
		for (NameValue resource : resources)
			ModelEditor.getInstance().addResourceIfNotExist(new ResourceDescriptor(gatewayName, deviceId, serviceId, resource.name));
	}
	
	/**
	 * Retrieve all resources from one service
	 * 
	 * @param service
	 *            the service from which resources need to be retrieved
	 * @throws IOException
	 */
	public void updateResources(final String gatewayName, final String deviceId, final String serviceId) throws IOException {
		Segments segment = new Segments.Builder().gateway(gatewayName).device(deviceId).service(serviceId).resources().build();

		SnaMessage response = GatewayHttpClient.sendGetRequest(segment);
		if (response instanceof ErrorMessage) {
			throwExceptionOnError((ErrorMessage) response, "resources");
		}

		List<String> resources = ((RestResourcesList) response).getResources();

		for (int i = 0; i < resources.size(); i++) {
			final String resourceId = resources.get(i);
			ModelEditor.getInstance().addResourceIfNotExist(new ResourceDescriptor(gatewayName, deviceId, serviceId, resourceId));
		}
	}
	
	/* =============== */
	/* Update location */
	/* =============== */

	private void updateLocation(DeviceDescriptor descriptor, String coordinates) {
		if (validCoordinates(coordinates)) {
			try {
				GPScoordinates gps = new GPScoordinates(coordinates);
				DeviceLocationManager.getInstance().updateLocationInStudio(descriptor, gps);
			} catch (InvalidAttributesException e) {
				logger.error("coordinates parsing error for " + descriptor + " (" + coordinates + ")");
			}
		}
	}

	private static boolean validCoordinates(String coordinate) {
		if (coordinate == null)
			return false;
		if (coordinate.isEmpty())
			return false;
		if (coordinate.equals("null"))
			return false;
		if (coordinate.equals("null:null"))
			return false;
		return true;
	}

	public boolean updateLocationOnServer(DeviceDescriptor deviceDescriptor, GPScoordinates coordinates) {
		Segments segments = new Segments.Builder().device(deviceDescriptor).service("admin").resource("location").method(AccessMethodType.SET).build();
		try {
			RequestParameter param = new RequestParameter("location", "java.lang.String", coordinates.getLat() + "," + coordinates.getLng());
			SnaMessage msg = GatewayHttpClient.sendPostRequest(segments, null,param);

			if (msg instanceof ResponseSetOK) {
				return true;
			} 
			if (msg instanceof ResponseSetError) {
				return false;
			} 
			logger.error("unknown response type " + msg.getClass().getCanonicalName());
			return false;
		} catch (IOException e) {
			logger.error("update location failed", e);
			return false;
		}
		// Note: resources values are not stored in the model
	}
	
	/* ==================== */
	/* Subscribe last event */
	/* ==================== */

	public boolean subscribeLastEvent(String gatewayID) {
		try {
			SubscriptionManager.getInstance().subscribeResource(Constants.createLastEventRD(gatewayID), this);
			return true;
		} catch (Exception e) {
			logger.error(e);
			return false;
		}
	}

	public boolean unsubscribeLastEvent(String gatewayID) {
		try {
			SubscriptionManager.getInstance().unsubscribeResource(Constants.createLastEventRD(gatewayID), this);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public void onEvent(SnaMessage response, ResourceDescriptor resource) {

		if (response == null) {
			logger.error("No identified content");
			return;
		}

		// Gateway name
		String gatewayName = resource.getGateway();

		if (response instanceof UpdateAttribute) {
			logger.error("UpdateAttribute");
			UpdateAttribute notificationResponse = (UpdateAttribute) response;

			ResourceDescriptor descriptor = notificationResponse.getTarget();

			if ("location".equals(descriptor.getResource())) {
				String coordinates = notificationResponse.getValue();
				updateLocation(descriptor.toDeviceDescriptor(), coordinates);
			}
		} else if (response instanceof LifecycleProviderAppearing) {
			logger.error("Lifecycle appearing");
			LifecycleProviderAppearing providerAppearing = (LifecycleProviderAppearing) response;
			String providerName = providerAppearing.getProvider();
			ModelEditor.getInstance().addDeviceIfNotExist(gatewayName, providerName);
		} else if (response instanceof LifecycleProviderDisappearing) {
			logger.error("LifecycleProviderDisappearing");
			LifecycleProviderDisappearing providerDisappearing = (LifecycleProviderDisappearing) response;
			String providerName = providerDisappearing.getProvider();
			ModelEditor.getInstance().removeDevice(gatewayName, providerName);
		} else if (response instanceof LifecycleServiceAppearing) {
			logger.error("LifecycleServiceAppearing");
			LifecycleServiceAppearing serviceAppearing = (LifecycleServiceAppearing) response;
			String providerName = serviceAppearing.getProvider();
			String serviceName = serviceAppearing.getService();
			ModelEditor.getInstance().addServiceIfNotExist(gatewayName, providerName, serviceName);
		} else if (response instanceof LifecycleServiceDisappearing) {
			logger.error("LifecycleServiceDisappearing");
			LifecycleServiceDisappearing serviceDisappearing = (LifecycleServiceDisappearing) response;
			String providerName = serviceDisappearing.getProvider();
			String serviceName = serviceDisappearing.getService();
			ModelEditor.getInstance().removeService(gatewayName, providerName, serviceName);
		} else if (response instanceof LifecycleResourceAppearing) {
			logger.error("LifecycleResourceAppearing");
			LifecycleResourceAppearing resourceAppearing = (LifecycleResourceAppearing) response;

			String providerName = resourceAppearing.getProvider();
			String serviceName = resourceAppearing.getService();
			String resourceName = resourceAppearing.getResource();
			ResourceDescriptor descriptor = new ResourceDescriptor(gatewayName, providerName, serviceName, resourceName);
			ModelEditor.getInstance().addResourceIfNotExist(descriptor);
			if (resourceName.equals("location")) {
				String coordinates = resourceAppearing.getInitValue();
				updateLocation(descriptor.toDeviceDescriptor(), coordinates);
			}
		} else if (response instanceof LifecycleResourceDisappearing) {
			logger.error("LifecycleResourceDisappearing");
			LifecycleResourceDisappearing resourceDisappearing = (LifecycleResourceDisappearing) response;
			String providerName = resourceDisappearing.getProvider();
			String serviceName = resourceDisappearing.getService();
			String resourceName = resourceDisappearing.getResource();
			ResourceDescriptor descriptor = new ResourceDescriptor(gatewayName, providerName, serviceName, resourceName);
			ModelEditor.getInstance().removeResource(descriptor);
		}
	}

	public boolean isConnected(String gatewayID) {
		return SubscriptionManager.getInstance().hasSubscribeResource(Constants.createLastEventRD(gatewayID), this);
	}
	
	/* ========= */
	/* Exception */
	/* ========= */
	
	private void throwExceptionOnError(SnaMessage response, String elementName) {
		String msg = response.getFullDescription();
		String fullMsg = "Error sent by gateway while getting " + elementName + "\n" + msg;
		throw new RuntimeException(fullMsg);
	}
}
