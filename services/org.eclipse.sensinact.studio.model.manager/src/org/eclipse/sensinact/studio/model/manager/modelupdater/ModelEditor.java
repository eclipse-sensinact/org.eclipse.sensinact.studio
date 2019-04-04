/**
 * Copyright (c) 2019 CEA.
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
import java.util.function.Supplier;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.sensinact.studio.http.messages.snamessage.MsgSensinact;
import org.eclipse.sensinact.studio.http.messages.snamessage.describeresource.MsgDescribeRessource;
import org.eclipse.sensinact.studio.http.services.client.GatewayHttpClient;
import org.eclipse.sensinact.studio.model.manager.listener.devicelocation.DeviceLocationManager;
import org.eclipse.sensinact.studio.model.resource.utils.DeviceDescriptor;
import org.eclipse.sensinact.studio.model.resource.utils.ResourceDescriptor;
import org.eclipse.sensinact.studio.model.resource.utils.Segments;
import org.eclipse.sensinact.studio.model.resource.utils.ServiceDescriptor;
import org.eclipse.sensinact.studio.preferences.ConfigurationListerner;
import org.eclipse.sensinact.studio.preferences.ConfigurationManager;
import org.eclipse.sensinact.studio.preferences.GatewayHttpConfig;
import org.eclipse.sensinact.studio.resource.AccessMethod;
import org.eclipse.sensinact.studio.resource.AccessMethodType;
import org.eclipse.sensinact.studio.resource.Studio;

/**
 * @author Nicolas Hili, Etienne Gandrille
 */
public class ModelEditor extends ModelEditorHelpers implements ConfigurationListerner {

	/* ===================== */
	/* Model data structures */
	/* ===================== */

	private static ModelEditor INSTANCE = null;

	private ModelEditor() {
		ConfigurationManager.addListener(this);
	}

	public synchronized static ModelEditor getInstance() {
		if (INSTANCE == null)
			INSTANCE = new ModelEditor();
		return INSTANCE;
	}

	/* ====================== */
	/* ConfigurationListerner */
	/* ====================== */
	
	@Override
	public void gatewayAddedOrUpdatedNotif(GatewayHttpConfig gateway) {
		addGatewayIfNotExist_UNSAFE(gateway.getName());
	}

	@Override
	public void gatewayRemovedNotif(String name) {
		removeGateway_UNSAFE(name);
	}

	@Override
	public void studioPortUpdatedNotif(int port) {
		// do nothing
	}
	
	/* ============= */
	/* Run exclusive */
	/* ============= */
		
	private void runExclusive(Runnable runnable) {
		RecordingCommand command = new RecordingCommand(getEditingDomain()) {
			@Override
			protected void doExecute() {
				USE_IN_RUNEXLUSIVE_setupStudio();
				runnable.run();
			}
		};
		getEditingDomain().getCommandStack().execute(command);
	}
	
	@SuppressWarnings("unchecked")
	private <T> T runExclusive(Supplier<T> supplier) throws InterruptedException {
		return (T) getEditingDomain().runExclusive(new RunnableWithResult.Impl<T>() {
			@Override
			public void run() {
				USE_IN_RUNEXLUSIVE_setupStudio();
				T value = supplier.get();
				setResult(value);
				return;
			}
		});
	}

	/* ========== */
	/* Root level */
	/* ========== */
	
	/**
	 * IMPORTANT. This method MUST NOT BE USED TO UPDATE THE MODEL !!!!
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public Studio getViewerInput() throws InterruptedException {

		runExclusive(() -> USE_IN_RUNEXLUSIVE_setupStudio());

		// Init available gateways names
		for (GatewayHttpConfig gateway : ConfigurationManager.getGateways()) {
			addGatewayIfNotExist_UNSAFE(gateway.getName());
		}

		return runExclusive(() -> USE_IN_RUNEXLUSIVE_getStudio());
	}
	
	/* ======= */
	/* Get IDs */
	/* ======= */

	public List<String> getGatewaysId() throws InterruptedException {
		return runExclusive(() -> USE_IN_RUNEXCLUSIVE_getGatewaysId());
	}
	
	public List<String> getConnectedGatewaysId() throws InterruptedException {
		return runExclusive(() -> USE_IN_RUNEXCLUSIVE_getConnectedGatewaysId());
	}
	
	public List<String> getDevicesId(String gatewayName) throws InterruptedException {
		return runExclusive(() -> USE_IN_RUNEXCLUSIVE_getDevicesId(gatewayName));
	}

	public List<String> getServicesId(String gatewayName, String devicename) throws InterruptedException {
		return runExclusive(() -> USE_IN_RUNEXCLUSIVE_getServicesId(gatewayName, devicename));
	}

	public List<String> getResourcesId(String gatewayName, String devicename, String servicename) throws InterruptedException {
		return runExclusive(() -> USE_IN_RUNEXCLUSIVE_getResourcesId(gatewayName, devicename, servicename));
	}

	public EClass getResourceClass(final ResourceDescriptor descriptor) throws InterruptedException {
		return runExclusive(() -> USE_IN_RUNEXLUSIVE_getResource(descriptor).eClass());
	}
	
	/* ================= */
	/* Find Applications */
	/* ================= */
	
	public List<ServiceDescriptor> findApplications() throws InterruptedException {
		return runExclusive(() -> USE_IN_RUNEXCLUSIVE_findApplications());
	}
		
	/* ============= */
	/* Checks exists */
	/* ============= */

	public boolean existsGateway(String gatewayId) throws InterruptedException {
		return getGatewaysId().contains(gatewayId);
	}

	public boolean existsDevice(String gatewayId, String deviceId) throws InterruptedException {
		return getDevicesId(gatewayId).contains(deviceId);
	}

	public boolean existsService(String gatewayId, String deviceId, String serviceId) throws InterruptedException {
		return getServicesId(gatewayId, deviceId).contains(serviceId);
	}

	public boolean existsResource(String gatewayId, String deviceId, String serviceId, String resourceId) throws InterruptedException {
		return existsResource(new ResourceDescriptor(gatewayId, deviceId, serviceId, resourceId));
	}

	public boolean existsResource(ResourceDescriptor descriptor) throws InterruptedException {
		return getResourcesId(descriptor.getGateway(), descriptor.getDevice(), descriptor.getService()).contains(descriptor.getResource());
	}

	/* ============== */
	/* Access Methods */
	/* ============== */
	
	public EList<AccessMethod> getAccessMethods(ResourceDescriptor descriptor) throws InterruptedException {
		return runExclusive(() -> USE_IN_RUNEXCLUSIVE_getAccessMethods(descriptor));
	}

	public int getAccessMethodNb(final ResourceDescriptor descriptor) throws InterruptedException {
		return runExclusive(() -> USE_IN_RUNEXCLUSIVE_getAccessMethods(descriptor).size());
	}
	
	public EList<AccessMethod> getAccessMethodsWithType(ResourceDescriptor descriptor, AccessMethodType type) throws InterruptedException {
		return runExclusive(() -> USE_IN_RUNEXCLUSIVE_getAccessMethodsWithType(descriptor, type));
	}

	public AccessMethod getAccessMethodWithTypeNbParams(ResourceDescriptor descriptor, AccessMethodType type, int nbOfParameters) throws InterruptedException {
		return runExclusive(() -> USE_IN_RUNEXCLUSIVE_getAccessMethodWithTypeNbParams(descriptor, type, nbOfParameters));
	}

	/* ================= */
	/* ADD Objects by ID */
	/* ================= */

	// USE CAREFULLY
	// usually, if you want to add a gateway, use
	// ConfigurationManager.addGateway
	private void addGatewayIfNotExist_UNSAFE(final String gatewayName) {
		runExclusive(() -> USE_IN_RUNEXLUSIVE_addGatewayIfNotExist(gatewayName));
	}

	public void addDeviceIfNotExist(final String gatewayName, final String deviceId) {
		runExclusive(() -> USE_IN_RUNEXLUSIVE_addDeviceIfNotExist(gatewayName, deviceId));
	}

	public void addServiceIfNotExist(final String gatewayName, final String deviceId, final String serviceId) {
		runExclusive(() -> {
			USE_IN_RUNEXLUSIVE_addDeviceIfNotExist(gatewayName, deviceId);
			USE_IN_RUNEXLUSIVE_addServiceIfNotExist(gatewayName, deviceId, serviceId);
		});
	}

	public void addResourceIfNotExist(final ResourceDescriptor descriptor) {
		try {
			if (!existsResource(descriptor)) {
				Segments segment = new Segments.Builder().resource(descriptor).build();
				
				MsgSensinact response = null;
				try {
					response = GatewayHttpClient.sendGetRequest(segment);
				} catch (IOException e) {
					throw new RuntimeException("Get request on " + segment + " failed", e);
				}
				
				if (! (response instanceof MsgDescribeRessource))
					throw new RuntimeException("Can't get remote resources info for " + descriptor);
				
				final MsgDescribeRessource responseMessage = (MsgDescribeRessource) response;
				
				runExclusive(() -> USE_IN_RUNEXLUSIVE_addResourceIfNotExist(descriptor, responseMessage));
			}
		} catch (NullPointerException | InterruptedException e) {
			getEditingDomain().getCommandStack().flush();
			throw new RuntimeException("Unexpected exception... " + descriptor);
		}
	}

	/* ==================== */
	/* REMOVE Objects by ID */
	/* ==================== */

	// USE CAREFULLY
	// usually, if you want to remove a gateway, use
	// ConfigurationManager.removeGateway
	private void removeGateway_UNSAFE(String gatewayName) {
		runExclusive(() -> USE_IN_RUNEXLUSIVE_removeGateway(gatewayName));
		DeviceLocationManager.getInstance().deleteGatewayInStudio(gatewayName);
	}
		
	public void clearGatewayContent(String gatewayName) {
		runExclusive(() -> USE_IN_RUNEXCLUSIVE_removeAllDevices(gatewayName));
		DeviceLocationManager.getInstance().deleteGatewayInStudio(gatewayName);
	}

	public void removeDevice(String gatewayName, String deviceId) {
		runExclusive(() -> USE_IN_RUNEXCLUSIVE_removeDevice(gatewayName, deviceId));
		DeviceLocationManager.getInstance().deleteDeviceInStudio(new DeviceDescriptor(gatewayName, deviceId));
	}
		
	public void removeService(String gatewayName, String deviceId, String serviceId) {
		runExclusive(() -> USE_IN_RUNEXCLUSIVE_removeService(gatewayName, deviceId, serviceId)); 		
	}
	
	public void removeResource(final ResourceDescriptor descriptor) {
		runExclusive(() -> USE_IN_RUNEXCLUSIVE_removeResource(descriptor));
	}
}
