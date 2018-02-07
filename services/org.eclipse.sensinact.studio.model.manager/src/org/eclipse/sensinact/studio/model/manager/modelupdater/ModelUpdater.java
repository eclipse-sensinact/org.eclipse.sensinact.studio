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
import java.util.HashMap;
import java.util.List;

import javax.naming.directory.InvalidAttributesException;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.sensinact.studio.http.client.GatewayHttpClient;
import org.eclipse.sensinact.studio.http.client.GatewayHttpClient.RequestParameter;
import org.eclipse.sensinact.studio.http.client.snamessage.ErrorMessage;
import org.eclipse.sensinact.studio.http.client.snamessage.ResponseGetOK;
import org.eclipse.sensinact.studio.http.client.snamessage.RestProvidersList;
import org.eclipse.sensinact.studio.http.client.snamessage.RestResourcesList;
import org.eclipse.sensinact.studio.http.client.snamessage.RestServicesList;
import org.eclipse.sensinact.studio.http.client.snamessage.SnaMessage;
import org.eclipse.sensinact.studio.http.client.snamessage.UpdateAttribute;
import org.eclipse.sensinact.studio.http.client.snamessage.gateway.LifecycleProviderAppearing;
import org.eclipse.sensinact.studio.http.client.snamessage.gateway.LifecycleProviderDisappearing;
import org.eclipse.sensinact.studio.http.client.snamessage.gateway.LifecycleResourceAppearing;
import org.eclipse.sensinact.studio.http.client.snamessage.gateway.LifecycleResourceDisappearing;
import org.eclipse.sensinact.studio.http.client.snamessage.gateway.LifecycleServiceAppearing;
import org.eclipse.sensinact.studio.http.client.snamessage.gateway.LifecycleServiceDisappearing;
import org.eclipse.sensinact.studio.http.client.snamessage.gateway.ResponseCustom;
import org.eclipse.sensinact.studio.model.manager.listener.devicelocation.DeviceLocationManager;
import org.eclipse.sensinact.studio.model.manager.listener.subscription.SubscriptionListener;
import org.eclipse.sensinact.studio.model.manager.listener.subscription.SubscriptionManager;
import org.eclipse.sensinact.studio.model.resource.utils.Constants;
import org.eclipse.sensinact.studio.model.resource.utils.DeviceDescriptor;
import org.eclipse.sensinact.studio.model.resource.utils.GPScoordinates;
import org.eclipse.sensinact.studio.model.resource.utils.ResourceDescriptor;
import org.eclipse.sensinact.studio.model.resource.utils.Segments;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import org.eclipse.sensinact.studio.resource.AccessMethodType;

/**
 * Central point for managing the connection with the SensiNact Gateway.
 * @author Nicolas Hili, Etienne Gandrille
 */
public class ModelUpdater implements SubscriptionListener {

	private static final Logger logger = Logger.getLogger(ModelUpdater.class);

	private static Object lock = new Object();
	
	private static ModelUpdater INSTANCE;

	// TODO update the ugly monitor... EVERYWHERE !!!

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

			Segments segments = new Segments.Builder().gateway(gatewayName).devices().build();

			SnaMessage response = GatewayHttpClient.sendGetRequest(segments);
			if (response instanceof ErrorMessage) {
				throwExceptionOnError((ErrorMessage) response, "devices");
			}

			final List<String> providers = ((RestProvidersList) response).getProviders();
			
			// add device
			new Thread(){
				public void run(){
					try {
						for (int i = 0; i < providers.size(); i++) {
							final String deviceName = providers.get(i);
							ModelEditor.getInstance().addDeviceIfNotExist(gatewayName, deviceName);
						}	
						
						// remove device
						for (String localDevicesId : ModelEditor.getInstance().getDevicesId(gatewayName)) {
							if(!providers.contains(localDevicesId)){
								ModelEditor.getInstance().removeDevice(gatewayName, localDevicesId);
							}	
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}.start();
			
			// add location
			
			Thread loadLocationThread = new Thread(){
				public void run(){
					Segments segments = new Segments.Builder().gateway(gatewayName).locations().getLocations().build();
					try {
						SnaMessage response = GatewayHttpClient.sendGetRequest(segments);
						if (response instanceof ErrorMessage) {
							throwExceptionOnError((ErrorMessage) response, "devices");
						}
						
						if(response instanceof ResponseGetOK){
							ResponseGetOK responseGet=(ResponseGetOK)response;
							//System.out.println(responseGet.getValue());
							ModelUpdater.getInstance().updateLocation(gatewayName, new JSONArray(responseGet.getValue()));
						}
						
					} catch (IOException | JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			};
			//loadLocationThread.setDaemon(true);
			loadLocationThread.start();

	}

	public void updateServicesOnly(final String gatewayName, final String deviceId) throws IOException {
		//Segments segments = new Segments.Builder().gateway(gatewayName).device(deviceId).services().build();
		
		final DeviceDescriptor dd=new DeviceDescriptor(gatewayName, deviceId);
		
		//Segments segments = new Segments.Builder().gateway(gatewayName).device(deviceId).services().build();
		Segments segments = new Segments.Builder().gateway(gatewayName).jsonpath(dd).getResult().build(); 
		//GatewayHttpClient.sendPostRequest(segments, parameters)
		SnaMessage response = GatewayHttpClient.sendGetRequest(segments, new HashMap<String, String>(){{put("jsonpath", String.format("$..providers[?(@.name=='%s')]", dd.getDevice()));}}); 
		if (response instanceof ErrorMessage) {
			throwExceptionOnError((ErrorMessage) response, "services");
		}

		if(response instanceof ResponseCustom){
		
			ResponseCustom custom=(ResponseCustom) response;
			
			try {
				JSONObject providers=new JSONArray(custom.getSource()).getJSONObject(0);
				JSONArray services = providers.getJSONArray("services");
				
				for (int i = 0; i < services.length(); i++) {
					JSONObject ob=(JSONObject)services.get(i);
					String serviceId=ob.getString("name");
					//ModelEditor.getInstance().addServiceIfNotExist(gatewayName, deviceId, serviceId);
					JSONArray resources = ob.getJSONArray("resources");
					for (int x = 0; x < resources.length(); x++) {
						JSONObject resource=(JSONObject)resources.get(x);
						ResourceDescriptor rd=new ResourceDescriptor(gatewayName,deviceId,serviceId,resource.getString("name"));
						ModelEditor.getInstance().addResourceIfNotExist(rd);
					}
					
					
					//synchronized (lock) {
						//updateResources(gatewayName, deviceId, serviceId);
					//}
				}
				
			} catch (Exception json){
				json.printStackTrace();
			}
		}
	}
	
	public void updateServices(final String gatewayName, final String deviceId) throws IOException {
		updateServices(gatewayName, deviceId,false);
		
	}
	
	public void updateServicesRecursive(final String gatewayName, final String deviceId) throws IOException {
		updateServices(gatewayName, deviceId,true);
	}
	
	/**
	 * Get all services on a device, from the gateway, and updates the model.
	 * 
	 * @param device
	 *            the device from which services need to be retrieved
	 * @throws IOException
	 */
	public void updateServices(final String gatewayName, final String deviceId,Boolean recursive) throws IOException {

		try {
			Segments segments = new Segments.Builder().gateway(gatewayName).device(deviceId).services().build();

			SnaMessage response = GatewayHttpClient.sendGetRequest(segments);
			if (response instanceof ErrorMessage) {
				throwExceptionOnError((ErrorMessage) response, "services");
			}

			List<String> services = ((RestServicesList) response).getServices();
			
			// add service
			
			for (int i = 0; i < services.size(); i++) {
				final String serviceId = services.get(i);
				ModelEditor.getInstance().addServiceIfNotExist(gatewayName, deviceId, serviceId);
				if(recursive){
					updateResources(gatewayName, deviceId, serviceId,false);
				}
			}

			// remove service
			for (String localServicesId : ModelEditor.getInstance().getServicesId(gatewayName, deviceId)) {
				if(!services.contains(localServicesId)){
					ModelEditor.getInstance().removeService(gatewayName, deviceId, localServicesId);
				}
			}
		} catch (InterruptedException e) {
			throw new IOException("Error while parsing JSON", e);
		}
	}

	/**
	 * Retrieve all resources from one service
	 * 
	 * @param service
	 *            the service from which resources need to be retrieved
	 * @throws IOException
	 */
	public void updateResources(final String gatewayName, final String deviceId, final String serviceId) throws IOException {
		updateResources(gatewayName,deviceId,serviceId,false);
	}
	
	public void updateResources(final String gatewayName, final String deviceId, final String serviceId,Boolean useJob) throws IOException {

		System.out.println("updateResources(final String gatewayName, final String deviceId, final String serviceId,Boolean useJob)"+useJob);
		
		Segments segment = new Segments.Builder().gateway(gatewayName).device(deviceId).service(serviceId).resources().build();

		SnaMessage response = GatewayHttpClient.sendGetRequest(segment);
		if (response instanceof ErrorMessage) {
			throwExceptionOnError((ErrorMessage) response, "resources");
		}

		List<String> resources = ((RestResourcesList) response).getResources();

		for (int i = 0; i < resources.size(); i++) {
			final String resourceId = resources.get(i);
			
			if(useJob){
				Job job = new Job("add resource") {
					@Override
					protected IStatus run(IProgressMonitor monitor) { 
						try {
							updateResource(new ResourceDescriptor(gatewayName, deviceId, serviceId, resourceId));
						} catch (IOException e) {
							logger.error("update resource failed", e);
						} 
						return Status.OK_STATUS;
					}
				};
				job.setPriority(Job.LONG);
				job.setUser(true);
				job.schedule(); 
			}else {
				updateResource(new ResourceDescriptor(gatewayName, deviceId, serviceId, resourceId));
			}
			
			

		}
	}

	public void updateLocation(String gateway,JSONArray objects) throws IOException {
		JSONArray arrayJSON=objects;
		try {
			for (int i = 0; i < arrayJSON.length(); i++) {
				  JSONObject jsonPair=arrayJSON.getJSONObject(i);
				  DeviceDescriptor dd=new DeviceDescriptor(gateway, jsonPair.getString("provider"));
				  //System.out.println("Loading location:"+dd.getDevice());
				  String location=jsonPair.getString("location");
				  updateLocation(dd, location);
				  
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	private void updateResource(ResourceDescriptor descriptor) throws IOException {

		ModelEditor.getInstance().addResourceIfNotExist(descriptor);

		if (descriptor.getResource().equals("location")) {

			Segments segment = new Segments.Builder().resource(descriptor).method(AccessMethodType.GET).build();
			SnaMessage response = GatewayHttpClient.sendGetRequest(segment);

			if (!response.isValid()) {
				logger.error("Invalid HTTP response while getting gps coordinates for " + descriptor);
				return;
			}

			String coordinates = ((ResponseGetOK) response).getValue();

			updateLocation(descriptor.toDeviceDescriptor(), coordinates);
		}
	}

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

	private void throwExceptionOnError(SnaMessage response, String elementName) {
		String msg = response.getFullDescription();
		String fullMsg = "Error sent by gateway while getting " + elementName + "\n" + msg;
		throw new RuntimeException(fullMsg);
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
		}else if (response instanceof LifecycleProviderAppearing) {
			logger.error("Lifecycle appearing");
			LifecycleProviderAppearing providerAppearing = (LifecycleProviderAppearing) response;
			String providerName = providerAppearing.getProvider();
			ModelEditor.getInstance().addDeviceIfNotExist(gatewayName, providerName);
		}else if (response instanceof LifecycleProviderDisappearing) {
			logger.error("LifecycleProviderDisappearing");
			LifecycleProviderDisappearing providerDisappearing = (LifecycleProviderDisappearing) response;
			String providerName = providerDisappearing.getProvider();
			ModelEditor.getInstance().removeDevice(gatewayName, providerName);
		}else if (response instanceof LifecycleServiceAppearing) {
			logger.error("LifecycleServiceAppearing");
			LifecycleServiceAppearing serviceAppearing = (LifecycleServiceAppearing) response;
			String providerName = serviceAppearing.getProvider();
			String serviceName = serviceAppearing.getService();
			ModelEditor.getInstance().addServiceIfNotExist(gatewayName, providerName, serviceName);
		}else if (response instanceof LifecycleServiceDisappearing) {
			logger.error("LifecycleServiceDisappearing");
			LifecycleServiceDisappearing serviceDisappearing = (LifecycleServiceDisappearing) response;
			String providerName = serviceDisappearing.getProvider();
			String serviceName = serviceDisappearing.getService();
			ModelEditor.getInstance().removeService(gatewayName, providerName, serviceName);
		}else if (response instanceof LifecycleResourceAppearing) {
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
		}else if (response instanceof LifecycleResourceDisappearing) {
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

	/* =================== */
	/* Location management */
	/* =================== */

	public void updateLocationOnServer(DeviceDescriptor deviceDescriptor, GPScoordinates coordinates) {
		Segments segments = new Segments.Builder().device(deviceDescriptor).service("admin").resource("location").method(AccessMethodType.SET).build();
		try {
			RequestParameter param = new RequestParameter("location", "java.lang.String", coordinates.getLat() + "," + coordinates.getLng());
			GatewayHttpClient.sendPostRequest(segments, null,param);
		} catch (IOException e) {
			logger.error("update location failed", e);
		}
		// Note: resources values are not stored in the model
	}
}