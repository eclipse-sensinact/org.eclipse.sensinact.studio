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
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.naming.directory.InvalidAttributesException;

import org.apache.log4j.Logger;
import org.eclipse.sensinact.studio.http.messages.snamessage.MsgSensinact;
import org.eclipse.sensinact.studio.http.messages.snamessage.completelist.MsgCompleteList;
import org.eclipse.sensinact.studio.http.messages.snamessage.completelist.ObjectProvider;
import org.eclipse.sensinact.studio.http.messages.snamessage.completelist.ObjectResource;
import org.eclipse.sensinact.studio.http.messages.snamessage.completelist.ObjectService;
import org.eclipse.sensinact.studio.http.messages.snamessage.lifecycle.MsgProviderAppearing;
import org.eclipse.sensinact.studio.http.messages.snamessage.lifecycle.MsgProviderDisappearing;
import org.eclipse.sensinact.studio.http.messages.snamessage.lifecycle.MsgResourceAppearing;
import org.eclipse.sensinact.studio.http.messages.snamessage.lifecycle.MsgResourceDisappearing;
import org.eclipse.sensinact.studio.http.messages.snamessage.lifecycle.MsgServiceAppearing;
import org.eclipse.sensinact.studio.http.messages.snamessage.lifecycle.MsgServiceDisappearing;
import org.eclipse.sensinact.studio.http.messages.snamessage.resourceslist.MsgResourcesList;
import org.eclipse.sensinact.studio.http.services.client.GatewayHttpClient;
import org.eclipse.sensinact.studio.http.services.client.GatewayHttpClient.RequestParameter;
import org.eclipse.sensinact.studio.http.services.client.subscribe.agent.Agent;
import org.eclipse.sensinact.studio.http.services.client.subscribe.agent.AgentSubscriptionListener;
import org.eclipse.sensinact.studio.model.manager.listener.devicelocation.DeviceLocationManager;
import org.eclipse.sensinact.studio.model.resource.utils.DeviceDescriptor;
import org.eclipse.sensinact.studio.model.resource.utils.GPScoordinates;
import org.eclipse.sensinact.studio.model.resource.utils.ResourceDescriptor;
import org.eclipse.sensinact.studio.model.resource.utils.Segments;
import org.eclipse.sensinact.studio.resource.AccessMethodType;

/**
 * @author Nicolas Hili, Etienne Gandrille, Jander and others
 */
public class ModelUpdater implements AgentSubscriptionListener {

	private static final Logger logger = Logger.getLogger(ModelUpdater.class);
	
	private static ModelUpdater INSTANCE;

	public static ModelUpdater getInstance() {
		if (INSTANCE == null)
			INSTANCE = new ModelUpdater();
		return INSTANCE;
	}

	private ModelUpdater() {
		Agent.getInstance().subscribe(this);
	}

	/**
	 * Get all devices from the gateway and updates the model.
	 * 
	 * @throws IOException
	 */
	public void updateDevices(final String gatewayName) throws IOException {
		
			logger.info("Full model update triggered");

			Segments segments = new Segments.Builder().gateway(gatewayName).jsonPath("jsonpath=$.*['name','location']").build();
			MsgSensinact snaMsg = GatewayHttpClient.sendGetRequest(segments);
			
			if (!(snaMsg instanceof MsgCompleteList))
				throwExceptionOnError(snaMsg, "devices");

			MsgCompleteList list = (MsgCompleteList) snaMsg;
			
			// update devices list
			new Thread() {
				public void run() {
					try {
		
						// add devices						
						for (ObjectProvider provider : list.getProviders())
							ModelEditor.getInstance().addDeviceIfNotExist(gatewayName, provider.getName());
						
						// remove device
						for (String localDevicesId : ModelEditor.getInstance().getDevicesId(gatewayName)) {			
							Optional<String> elem = list.getProviders().stream().map(p -> p.getName()).filter(name -> name.equals(localDevicesId)).findFirst();
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
			for (ObjectProvider provider : list.getProviders())
				updateLocation(new DeviceDescriptor(gatewayName, provider.getName()), provider.getLocation());
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

		MsgSensinact snaMsg = GatewayHttpClient.sendGetRequest(segments);
		
		if (!(snaMsg instanceof MsgCompleteList))
			throwExceptionOnError(snaMsg, "services");

		MsgCompleteList list = (MsgCompleteList) snaMsg;

		try {
			ObjectProvider provider = list.getProvider(deviceId);
			
			// location update
			updateLocation(new DeviceDescriptor(gatewayName, deviceId), provider.getLocation());
			
			// add service
			for (ObjectService service : provider.getServices()) {
				ModelEditor.getInstance().addServiceIfNotExist(gatewayName, deviceId, service.getName());
				if(recursive) {
					List<ObjectResource> resources = service.getResources();
					for (ObjectResource resource : resources) {
						ModelEditor.getInstance().addResourceIfNotExist(new ResourceDescriptor(gatewayName, deviceId, service.getName(), resource.getName()));
					}
				}
			}

			// remove service
			for (String localServicesId : ModelEditor.getInstance().getServicesId(gatewayName, deviceId)) {
				List<String> servicesIds = list.getProvider(deviceId).getServices().stream().map(s->s.getName()).collect(Collectors.toList());
				if(!servicesIds.contains(localServicesId)){
					ModelEditor.getInstance().removeService(gatewayName, deviceId, localServicesId);
				}
			}
			
		} catch (Exception e) {
			throw new IOException("Error while parsing infos for " + gatewayName + "/" + deviceId, e); 
		}
	}
	
	/* ================ */
	/* Update resources */
	/* ================ */
	
	/**
	 * Retrieve all resources from one service
	 * 
	 * @param service
	 *            the service from which resources need to be retrieved
	 * @throws IOException
	 */
	public void updateResources(final String gatewayName, final String deviceId, final String serviceId) throws IOException {
		Segments segment = new Segments.Builder().gateway(gatewayName).device(deviceId).service(serviceId).resources().build();

		MsgSensinact msg = GatewayHttpClient.sendGetRequest(segment);
		
		if (msg instanceof MsgResourcesList) {
			List<String> resources = ((MsgResourcesList) msg).getResources();
			for (int i = 0; i < resources.size(); i++) {
				final String resourceId = resources.get(i);
				ModelEditor.getInstance().addResourceIfNotExist(new ResourceDescriptor(gatewayName, deviceId, serviceId, resourceId));
			}
		} else {
			throwExceptionOnError(msg, "resources");
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
		RequestParameter param = new RequestParameter("location", "java.lang.String", coordinates.getLat() + "," + coordinates.getLng());
		
		
		try {
			MsgSensinact msg = GatewayHttpClient.sendPostRequest(segments, null,param);
			return msg.isValid();
		} catch (IOException e) {
			logger.error("Update location on server failed", e);
			return false;
		}		
	}
	
	/* ========= */
	/* Listeners */
	/* ========= */
	
	@Override
	public void onLifecycleEvent(String gateway, List<MsgSensinact> messages) {
		for (MsgSensinact message : messages)
			onLifecycleEvent(gateway, message);
	}

	public void onLifecycleEvent(String gateway, MsgSensinact message) {
		
		if (message instanceof MsgProviderAppearing) {
			MsgProviderAppearing msg = (MsgProviderAppearing) message;
			String providerName = getProviderName(msg.getUri());
			// updateLocation(new DeviceDescriptor(gateway, providerName), provider.getLocation());
			executeInThread( () -> ModelEditor.getInstance().addDeviceIfNotExist(gateway, providerName));
		
		} else if (message instanceof MsgProviderDisappearing) {
			MsgProviderDisappearing msg = (MsgProviderDisappearing) message;
			String providerName = getProviderName(msg.getUri());
			DeviceLocationManager.getInstance().deleteDeviceInStudio(new DeviceDescriptor(gateway, providerName));
			executeInThread( () -> ModelEditor.getInstance().removeDevice(gateway, providerName));		
			
		} else if (message instanceof MsgServiceAppearing) {
			MsgServiceAppearing msg = (MsgServiceAppearing) message;
			String providerName = getProviderName(msg.getUri());
			String serviceName = getServiceName(msg.getUri());
			executeInThread( () -> ModelEditor.getInstance().addServiceIfNotExist(gateway, providerName, serviceName));
		
		} else if (message instanceof MsgServiceDisappearing) {
			MsgServiceDisappearing msg = (MsgServiceDisappearing) message;
			String providerName = getProviderName(msg.getUri());
			String serviceName = getServiceName(msg.getUri());
			executeInThread( () -> ModelEditor.getInstance().removeService(gateway, providerName, serviceName));
			
		} else if (message instanceof MsgResourceAppearing) {
			MsgResourceAppearing msg = (MsgResourceAppearing) message;
			String providerName = getProviderName(msg.getUri());
			String serviceName = getServiceName(msg.getUri());
			String resourceName = getResourceName(msg.getUri());
			executeInThread( () -> ModelEditor.getInstance().addResourceIfNotExist(new ResourceDescriptor(gateway, providerName, serviceName, resourceName)));
			if ("location".equals(resourceName)) {
				String coordinates = msg.getInitial().getValueAsString();
				updateLocation(new DeviceDescriptor(gateway, providerName), coordinates);
			}
			
		} else if (message instanceof MsgResourceDisappearing) {
			MsgResourceDisappearing msg = (MsgResourceDisappearing) message;
			String providerName = getProviderName(msg.getUri());
			String serviceName = getServiceName(msg.getUri());
			String resourceName = getResourceName(msg.getUri());
			executeInThread( () -> ModelEditor.getInstance().removeResource(new ResourceDescriptor(gateway, providerName, serviceName, resourceName)));
			
		} else {
			throw new RuntimeException("Unhandled lifecycle event of class " + message.getClass() + " " + message.toString());
		}
	}
	
	@Override
	public void onLocationEvent(String gateway, List<MsgSensinact> messages) {
		for (MsgSensinact message : messages)
			onLocationEvent(gateway, message);
	}
	
	public void onLocationEvent(String gateway, MsgSensinact message) {
	}
	
	private static void executeInThread(Runnable r){
		Runnable runnableWithTry = () -> {
			try {
				r.run();
			} catch (Exception e) {
				logger.error(e);
			}
		}; 		
		new Thread(runnableWithTry).start();
    }
	
	
	private String getProviderName(String uri) {
		String[] tokens = uri.split("/");
		return tokens[1];
	}

	private String getServiceName(String uri) {
		String[] tokens = uri.split("/");
		return tokens[2];
	}
	
	private String getResourceName(String uri) {
		String[] tokens = uri.split("/");
		return tokens[3];
	}
	
	/* ========= */
	/* Exception */
	/* ========= */
	
	private void throwExceptionOnError(MsgSensinact response, String elementName) {
		String fullMsg = String.format("Error sent by gateway while getting %s (%s)", elementName, response.getType());
		throw new RuntimeException(fullMsg);
	}
}
