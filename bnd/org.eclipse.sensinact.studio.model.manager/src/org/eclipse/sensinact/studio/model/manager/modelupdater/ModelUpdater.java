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

import org.apache.log4j.Logger;
import org.eclipse.sensinact.studio.http.messages.snamessage.MsgSensinact;
import org.eclipse.sensinact.studio.http.messages.snamessage.ObjectNameTypeValue;
import org.eclipse.sensinact.studio.http.messages.snamessage.attributevalueupdated.MsgAttributeValueUpdated;
import org.eclipse.sensinact.studio.http.messages.snamessage.basic.MsgHttpError;
import org.eclipse.sensinact.studio.http.messages.snamessage.completelist.MsgCompleteList;
import org.eclipse.sensinact.studio.http.messages.snamessage.completelist.ObjectProvider;
import org.eclipse.sensinact.studio.http.messages.snamessage.getresponse.MsgGetResponse;
import org.eclipse.sensinact.studio.http.messages.snamessage.lifecycle.MsgProviderAppearing;
import org.eclipse.sensinact.studio.http.messages.snamessage.lifecycle.MsgProviderDisappearing;
import org.eclipse.sensinact.studio.http.messages.snamessage.lifecycle.MsgResourceAppearing;
import org.eclipse.sensinact.studio.http.messages.snamessage.lifecycle.MsgResourceDisappearing;
import org.eclipse.sensinact.studio.http.messages.snamessage.lifecycle.MsgServiceAppearing;
import org.eclipse.sensinact.studio.http.messages.snamessage.lifecycle.MsgServiceDisappearing;
import org.eclipse.sensinact.studio.http.messages.snamessage.resourceslist.MsgResourcesList;
import org.eclipse.sensinact.studio.http.messages.snamessage.serviceslist.MsgServicesList;
import org.eclipse.sensinact.studio.http.services.client.GatewayHttpClient;
import org.eclipse.sensinact.studio.http.services.client.GatewayHttpClient.RequestParameter;
import org.eclipse.sensinact.studio.http.services.client.connectionmanager.NotifDispatcher;
import org.eclipse.sensinact.studio.http.services.client.listener.NotifSubscriptionListener;
import org.eclipse.sensinact.studio.model.resource.utils.DeviceDescriptor;
import org.eclipse.sensinact.studio.model.resource.utils.GPScoordinates;
import org.eclipse.sensinact.studio.model.resource.utils.GPSparsingException;
import org.eclipse.sensinact.studio.model.resource.utils.ResourceDescriptor;
import org.eclipse.sensinact.studio.model.resource.utils.Segments;
import org.eclipse.sensinact.studio.model.resource.utils.ServiceDescriptor;
import org.eclipse.sensinact.studio.resource.AccessMethodType;

/**
 * @author Nicolas Hili, Etienne Gandrille, Jander and others
 */
public class ModelUpdater implements NotifSubscriptionListener {

	private static final Logger logger = Logger.getLogger(ModelUpdater.class);
	
	private static ModelUpdater INSTANCE;
	
	public static ModelUpdater getInstance() {
		if (INSTANCE == null)
			INSTANCE = new ModelUpdater();
		return INSTANCE;
	}


	private final ModelUpdateStack stack = new ModelUpdateStack();
	
	private ModelUpdater() {
		NotifDispatcher.getInstance().subscribe(this);
	}

	/**
	 * Get all devices from the gateway and updates the model.
	 * 
	 * @throws IOException
	 */
	public void updateDevices(final String gatewayName) throws IOException {
		
			logger.info("Full model update triggered");

			Segments segments = new Segments.Builder().gateway(gatewayName).root().build();
			MsgSensinact snaMsg = GatewayHttpClient.sendGetRequest(segments);
			
			if (!(snaMsg instanceof MsgCompleteList)) {
				displayLogOnError(snaMsg, "devices");
				return;
			}

			MsgCompleteList list = (MsgCompleteList) snaMsg;
			
			// update devices list
			new Thread() {
				public void run() {
					// remove device
					for (String localDeviceId : ModelEditor.getInstance().getDevicesId(gatewayName)) {	
						try {
							if(!list.getProvidersId().contains(localDeviceId))
								stack.add(new DeviceDisappearing(new DeviceDescriptor(gatewayName, localDeviceId)));							
						}catch(Exception e) {
							logger.error(e.getMessage(),e);							
						}
					}
					// add devices						
					for (ObjectProvider provider : list.getProviders()){
						if(provider.getLocation() == null){
							continue;
						}
						DeviceDescriptor desc = new DeviceDescriptor(gatewayName, provider.getName());
						desc.setLocation(provider.getLocation());
						stack.add(new DeviceAppearing(desc));
					}
				}
			}.start();
	}

	/**
	 * Get all services on a device, from the gateway, and updates the model.
	 * 
	 * @param device
	 *            the device from which services need to be retrieved
	 * @throws IOException
	 */
	public void updateServices(final String gatewayName, final String deviceId) throws IOException {
		
		Segments segments = new Segments.Builder().gateway(gatewayName).device(deviceId).services().build();		
		MsgSensinact snaMsg = GatewayHttpClient.sendGetRequest(segments);
		
		if (!(snaMsg instanceof MsgServicesList)) {
			System.out.println(snaMsg);
			displayLogOnError(snaMsg, "services");
			return;
		}
		if(((MsgServicesList) snaMsg).getServices() == null)
			return;

		// remove service
		for (String localServiceId : ModelEditor.getInstance().getServicesId(gatewayName, deviceId)) {		
			try {		
				if(!((MsgServicesList) snaMsg).getServices().contains(localServiceId)) 
					stack.add(new ServiceDisappearing(new ServiceDescriptor(gatewayName, deviceId, localServiceId)));
			} catch(Exception ex) {
				logger.error(ex.getMessage(),ex);
			}
		}
		
		for (String service : ((MsgServicesList) snaMsg).getServices()){
			stack.add(new ServiceAppearing(new ServiceDescriptor(gatewayName, deviceId, service)));
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
		
		if (!(msg instanceof MsgResourcesList)) {
			displayLogOnError(msg, "resources");
			return;
		}			
		if(((MsgResourcesList) msg).getResources() == null)
			return;

		// remove resources
		for (String localResourceId : ModelEditor.getInstance().getResourcesId(gatewayName, deviceId, serviceId)) {		
			try {		
				if(!((MsgResourcesList) msg).getResources().contains(localResourceId)) 
					stack.add(new ResourceDisappearing(new ResourceDescriptor(gatewayName, deviceId, serviceId,localResourceId)));
			} catch(Exception ex) {
				logger.error(ex.getMessage(),ex);
			}
		}
		//add resources
		for (String resource : ((MsgResourcesList) msg).getResources()) {
			if(serviceId.equals("admin") && resource.equals("icon")) {
				try {
					ResourceDescriptor rd = updateResource(gatewayName, deviceId, serviceId, resource);
					if(rd != null) {
						stack.add(new ResourceAppearing(rd));
						String icon = null;
						ObjectNameTypeValue ontv = rd.getInitial();
						if(ontv != null) {
							String ic = ontv.getValueAsString();
							icon = "null".equals(ic)?null:ic;							
						}
						ModelEditor.getInstance().setIcon(new DeviceDescriptor(rd.getGateway(), rd.getDevice()), icon);
					}
				} catch(Exception ex) {
					logger.error(ex.getMessage(),ex);
				}
			} else
				stack.add(new ResourceAppearing(new ResourceDescriptor(gatewayName, deviceId, serviceId, resource)));
		}		
	}

	/**
	 * Retrieve all resources from one service
	 * 
	 * @param service
	 *            the service from which resources need to be retrieved
	 * @throws IOException
	 */
	public ResourceDescriptor updateResource(final String gatewayName, final String deviceId, final String serviceId, final String resourceId) throws IOException {
		Segments segment = new Segments.Builder().gateway(gatewayName).device(deviceId).service(serviceId).resource(resourceId).method(AccessMethodType.GET).build();
		MsgSensinact msg = GatewayHttpClient.sendGetRequest(segment);
		if (!(msg instanceof MsgGetResponse)) {
			displayLogOnError(msg, "GET");
			return null;
		}
		MsgGetResponse response  = (MsgGetResponse)msg;
		ResourceDescriptor desc = new ResourceDescriptor(gatewayName, deviceId, serviceId, resourceId);
		desc.setInitial(response.getResponse());
		return desc;	
	}
	
	/* =============== */
	/* Update location */
	/* =============== */

	public boolean updateLocationOnServer(DeviceDescriptor deviceDescriptor, GPScoordinates coordinates) {
		Segments segments = new Segments.Builder().device(deviceDescriptor).service("admin").resource("location").method(AccessMethodType.SET).build();
		RequestParameter param = new RequestParameter("location", "string", coordinates.getLat() + ":" + coordinates.getLng());
		try {
			MsgSensinact msg = GatewayHttpClient.sendPostRequest(segments, null,param);
			if (msg instanceof MsgHttpError) {
				return false;
			} else {
				return true;
			}
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
		
		String uri = message.getUri();
		ModelUpdate<?> mu = null;
		
		if (message instanceof MsgProviderAppearing) {
			mu = new DeviceAppearing(new DeviceDescriptor(gateway, getProviderName(uri)));
			
		} else if (message instanceof MsgProviderDisappearing) {
			mu = new DeviceDisappearing(new DeviceDescriptor(gateway, getProviderName(uri)));			
			
		} else if (message instanceof MsgServiceAppearing) {
			mu = new ServiceAppearing(new ServiceDescriptor(gateway, getProviderName(uri),getServiceName(uri)));
		
		} else if (message instanceof MsgServiceDisappearing) {
			mu = new ServiceDisappearing(new ServiceDescriptor(gateway, getProviderName(uri),getServiceName(uri)));
			
		} else if (message instanceof MsgResourceAppearing) {
			ResourceDescriptor d = new ResourceDescriptor(gateway,getProviderName(uri),getServiceName(uri),getResourceName(uri));
			d.setInitial(((MsgResourceAppearing)message).getInitial());
			mu = new ResourceAppearing(d);
			
		} else if (message instanceof MsgResourceDisappearing) {
			mu = new ResourceDisappearing(new ResourceDescriptor(gateway, 
					getProviderName(uri),getServiceName(uri),
					getResourceName(uri)));
		} else {
			displayLogOnError(message, "lifecycle");
			return;
		}
		stack.add(mu);
	}

	@Override
	public void onLocationEvent(String gateway, List<MsgSensinact> messages) {
		for (MsgSensinact message : messages)
			onLocationEvent(gateway, message);
	}
	
	public void onLocationEvent(String gateway, MsgSensinact message) {
	
		if(!(message instanceof MsgAttributeValueUpdated) || !((MsgAttributeValueUpdated)message).isLocationValue()){
			return;
		}
		MsgAttributeValueUpdated lu = (MsgAttributeValueUpdated)message;
		String uri = lu.getUri();
		String device = getProviderName(uri);
		try {
			lu.getUri();
			ModelEditor.getInstance().setLocation(new DeviceDescriptor(gateway, device), 
			new GPScoordinates(lu.getNotification().getValueAsString()));
			
		} catch (GPSparsingException e) {			
			logger.error(e.getMessage(),e);
		}
	}
	
	static void executeInThread(Runnable r){
		Runnable runnableWithTry = () -> {
			try {
				r.run();
			} catch (Exception e) {
				logger.error(e);
			}
		}; 		
		new Thread(runnableWithTry).start();
    }


	@Override
	public void onIconEvent(String gateway, List<MsgSensinact> messages) {
		for (MsgSensinact message : messages)
			onIconEvent(gateway, message);
	}
	
	public void onIconEvent(String gateway, MsgSensinact message) {
		if(!(message instanceof MsgAttributeValueUpdated) || !((MsgAttributeValueUpdated)message).isIconValue()){
			return;
		}
		MsgAttributeValueUpdated lu = (MsgAttributeValueUpdated)message;
		String uri = lu.getUri();
		String device = getProviderName(uri);
		ModelEditor.getInstance().setIcon(new DeviceDescriptor(gateway, device),  lu.getNotification().getValueAsString());
	}

	@Override
	public void onValueEvent(String gateway, List<MsgSensinact> messages) {
		// do nothing for now
		
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
	
	private void displayLogOnError(MsgSensinact response, String elementName) {
		String fullMsg = String.format("Error sent by gateway while getting %s (%s)", elementName, response.getType());
		logger.error(fullMsg);
	}
}
