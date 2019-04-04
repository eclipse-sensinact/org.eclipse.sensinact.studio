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

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sensinact.studio.http.messages.snamessage.describeresource.MsgDescribeRessource;
import org.eclipse.sensinact.studio.http.messages.snamessage.describeresource.ObjectAccessMethods;
import org.eclipse.sensinact.studio.http.messages.snamessage.describeresource.ObjectParameter;
import org.eclipse.sensinact.studio.model.resource.utils.ResourceDescriptor;
import org.eclipse.sensinact.studio.model.resource.utils.ServiceDescriptor;
import org.eclipse.sensinact.studio.resource.AccessMethod;
import org.eclipse.sensinact.studio.resource.AccessMethodType;
import org.eclipse.sensinact.studio.resource.Device;
import org.eclipse.sensinact.studio.resource.Gateway;
import org.eclipse.sensinact.studio.resource.Parameter;
import org.eclipse.sensinact.studio.resource.Resource;
import org.eclipse.sensinact.studio.resource.ResourceFactory;
import org.eclipse.sensinact.studio.resource.ResourcePackage;
import org.eclipse.sensinact.studio.resource.Service;
import org.eclipse.sensinact.studio.resource.Studio;

public abstract class ModelEditorHelpers {

	private static final Logger logger = Logger.getLogger(ModelEditorHelpers.class);
	
	private static org.eclipse.emf.ecore.resource.Resource resource;

	private static TransactionalEditingDomain editingDomain;

	private final static String EDITING_DOMAIN_ID = "org.eclipse.sensinact.studio.model.resource.editingDomain";

	protected synchronized static org.eclipse.emf.ecore.resource.Resource getResource() {
		if (resource == null) {
			String path = "/org.eclipse.sensinact.studio.model.resource/cache/resource.cache";
			URI uri = URI.createPlatformPluginURI(path, true);
			resource = getEditingDomain().getResourceSet().createResource(uri);
		}
		return resource;
	}

	protected synchronized static TransactionalEditingDomain getEditingDomain() {
		if (editingDomain == null) {
			editingDomain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(EDITING_DOMAIN_ID);
		}
		return editingDomain;
	}

	protected static void USE_IN_RUNEXLUSIVE_setupStudio() {
		EList<EObject> contents = getResource().getContents();
		if (contents.size() == 0)
			getResource().getContents().add(ResourceFactory.eINSTANCE.createStudio());
	}

	protected static Studio USE_IN_RUNEXLUSIVE_getStudio() {
		EList<EObject> contents = getResource().getContents();
		return (Studio) contents.get(0);
	}

	protected static Gateway USE_IN_RUNEXLUSIVE_getGateway(String gatewayName) {
		EList<Gateway> gateways = USE_IN_RUNEXLUSIVE_getStudio().getGateways();
		for (Gateway gateway : gateways) {
			if (gateway.getName().equals(gatewayName)) {
				return gateway;
			}
		}
		return null;
	}

	protected static Device USE_IN_RUNEXLUSIVE_getDevice(String gatewayName, String devicename) {

		Gateway gateway = USE_IN_RUNEXLUSIVE_getGateway(gatewayName);
		if (gateway == null)
			return null;

		EList<Device> devices = gateway.getDevice();
		for (Device device : devices) {
			if (device.getName().equals(devicename)) {
				return device;
			}
		}
		return null;
	}

	protected static Service USE_IN_RUNEXLUSIVE_getService(String gatewayName, String devicename, String servicename) {
		Device device = USE_IN_RUNEXLUSIVE_getDevice(gatewayName, devicename);
		if (device == null)
			return null;

		for (Service service : device.getService()) {
			if (service.getName().equals(servicename)) {
				return service;
			}
		}

		return null;
	}

	protected static Resource USE_IN_RUNEXLUSIVE_getResource(ResourceDescriptor descriptor) {
		Service service = USE_IN_RUNEXLUSIVE_getService(descriptor.getGateway(), descriptor.getDevice(),
				descriptor.getService());
		if (service == null)
			return null;

		for (Resource resource : service.getResource()) {
			if (resource.getName().equals(descriptor.getResource())) {
				return resource;
			}
		}

		return null;
	}

	protected void USE_IN_RUNEXLUSIVE_addGatewayIfNotExist(final String gatewayName) {
		if (USE_IN_RUNEXLUSIVE_getGateway(gatewayName) != null)
			return;

		final Gateway addedGateway = ResourceFactory.eINSTANCE.createGateway();
		addedGateway.setName(gatewayName);
		USE_IN_RUNEXLUSIVE_getStudio().getGateways().add(addedGateway);
		return;
	}

	protected void USE_IN_RUNEXLUSIVE_addDeviceIfNotExist(String gatewayName, String deviceId) {
		if (USE_IN_RUNEXLUSIVE_getDevice(gatewayName, deviceId) != null)
			return;

		final Device addedDevice = ResourceFactory.eINSTANCE.createDevice();
		addedDevice.setName(deviceId);
		USE_IN_RUNEXLUSIVE_getGateway(gatewayName).getDevice().add(addedDevice);
	}

	protected void USE_IN_RUNEXLUSIVE_addServiceIfNotExist(String gatewayName, String deviceId, String serviceId) {
		if (USE_IN_RUNEXLUSIVE_getService(gatewayName, deviceId, serviceId) != null)
			return;

		final Service addedService = ResourceFactory.eINSTANCE.createService();
		addedService.setName(serviceId);
		try {
			USE_IN_RUNEXLUSIVE_getDevice(gatewayName, deviceId).getService().add(addedService);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

	protected void USE_IN_RUNEXLUSIVE_addResourceIfNotExist(ResourceDescriptor descriptor,
			MsgDescribeRessource responseMessage) {
		if (USE_IN_RUNEXLUSIVE_getResource(descriptor) != null)
			return;

		// preparation
		USE_IN_RUNEXLUSIVE_addDeviceIfNotExist(descriptor.getGateway(), descriptor.getDevice());
		USE_IN_RUNEXLUSIVE_addServiceIfNotExist(descriptor.getGateway(), descriptor.getDevice(),
				descriptor.getService());

		// create resource
		String resourceType = responseMessage.getResponse().getType();
		EClass type = literalToType(resourceType);
		Resource createdResource = (Resource) ResourceFactory.eINSTANCE.create(type);
		createdResource.setName(descriptor.getResource());

		// create access methods
		for (ObjectAccessMethods am : responseMessage.getResponse().getAccessMethods()) {
			if (am != null) { // test to be removed after gateway bug fix
				AccessMethod accessMethod = ResourceFactory.eINSTANCE.createAccessMethod();
				accessMethod.setType(AccessMethodType.get(am.getName()));

				Parameter[] parameters = new Parameter[am.getParameters().size()];
				for (int i = 0; i < am.getParameters().size(); i++) {
					ObjectParameter param = am.getParameters().get(i);
					Parameter parameter = ResourceFactory.eINSTANCE.createParameter();
					parameter.setName(param.getName());
					parameter.setType(param.getType());
					parameters[i] = parameter;
				}

				for (Parameter parameter : parameters) {
					accessMethod.getParameter().add(parameter);
				}
				createdResource.getAccessMethod().add(accessMethod);
			}
		}

		USE_IN_RUNEXLUSIVE_getService(descriptor.getGateway(), descriptor.getDevice(), descriptor.getService())
				.getResource().add(createdResource);
	}

	protected void USE_IN_RUNEXLUSIVE_removeGateway(String gatewayName) {
		EList<Gateway> gateways = USE_IN_RUNEXLUSIVE_getStudio().getGateways();

		for (int i = 0; i < gateways.size(); i++) {
			Gateway gateway = gateways.get(i);
			if (gateway.getName().equals(gatewayName)) {
				gateways.remove(i);
				return;
			}
		}
	}

	protected void USE_IN_RUNEXCLUSIVE_removeDevice(String gatewayName, String deviceId) {
		Gateway gateway = USE_IN_RUNEXLUSIVE_getGateway(gatewayName);
		if (gateway != null) {
			EList<Device> devices = gateway.getDevice();
			for (int i = 0; i < devices.size(); i++) {
				Device device = devices.get(i);
				if (deviceId.equals(device.getName())) {
					devices.remove(i);
					return;
				}
			}
		}
	}

	protected void USE_IN_RUNEXCLUSIVE_removeAllDevices(String gatewayName) {
		Gateway gateway = USE_IN_RUNEXLUSIVE_getGateway(gatewayName);
		if (gateway != null) {
			gateway.getDevice().clear();
		}
	}

	protected List<String> USE_IN_RUNEXCLUSIVE_getGatewaysId() {
		List<String> retval = new ArrayList<String>();
		EList<Gateway> gateways = USE_IN_RUNEXLUSIVE_getStudio().getGateways();
		for (Gateway gateway : gateways) {
			retval.add(gateway.getName());
		}
		return retval;
	}

	protected List<String> USE_IN_RUNEXCLUSIVE_getConnectedGatewaysId() {
		List<String> retval = new ArrayList<String>();
		EList<Gateway> gateways = USE_IN_RUNEXLUSIVE_getStudio().getGateways();
		for (Gateway gateway : gateways) {
			if (gateway.getDevice().size() != 0)
				retval.add(gateway.getName());
		}
		return retval;
	}

	protected List<String> USE_IN_RUNEXCLUSIVE_getDevicesId(String gatewayName) {
		List<String> retval = new ArrayList<String>();
		EList<Device> devices = USE_IN_RUNEXLUSIVE_getGateway(gatewayName).getDevice();
		for (Device device : devices) {
			retval.add(device.getName());
		}
		return retval;
	}

	protected List<String> USE_IN_RUNEXCLUSIVE_getServicesId(String gatewayName, String devicename) {
		List<String> retval = new ArrayList<String>();
		Device device = USE_IN_RUNEXLUSIVE_getDevice(gatewayName, devicename);

		if (device != null) {
			for (Service service : device.getService()) {
				retval.add(service.getName());
			}
		}
		return retval;
	}

	protected List<String> USE_IN_RUNEXCLUSIVE_getResourcesId(String gatewayName, String devicename,
			String servicename) {
		List<String> retval = new ArrayList<String>();
		Service service = USE_IN_RUNEXLUSIVE_getService(gatewayName, devicename, servicename);
		if (service != null) {
			for (Resource resource : service.getResource()) {
				retval.add(resource.getName());
			}
		}
		return retval;
	}

	protected List<ServiceDescriptor> USE_IN_RUNEXCLUSIVE_findApplications() {
		List<ServiceDescriptor> retval = new ArrayList<>();
		EList<Gateway> gateways = USE_IN_RUNEXLUSIVE_getStudio().getGateways();
		for (Gateway gateway : gateways) {
			Device appManager = findAppManager(gateway.getDevice());
			if (appManager != null) {
				retval.addAll(findApplications(appManager));
			}
		}
		return retval;
	}

	protected EList<AccessMethod> USE_IN_RUNEXCLUSIVE_getAccessMethods(ResourceDescriptor descriptor) {
		EList<AccessMethod> accessMethods = new BasicEList<AccessMethod>();
		Resource resource = USE_IN_RUNEXLUSIVE_getResource(descriptor);
		for (AccessMethod accessMethod : resource.getAccessMethod()) {
			accessMethods.add(accessMethod);
		}
		return accessMethods;
	}

	protected EList<AccessMethod> USE_IN_RUNEXCLUSIVE_getAccessMethodsWithType(ResourceDescriptor descriptor,
			AccessMethodType type) {
		EList<AccessMethod> accessMethods = new BasicEList<AccessMethod>();
		Resource resource = USE_IN_RUNEXLUSIVE_getResource(descriptor);
		for (AccessMethod accessMethod : resource.getAccessMethod()) {
			if (accessMethod.getType().equals(type)) {
				accessMethods.add(accessMethod);
			}
		}
		return accessMethods;
	}

	protected AccessMethod USE_IN_RUNEXCLUSIVE_getAccessMethodWithTypeNbParams(ResourceDescriptor descriptor,
			AccessMethodType type, int nbOfParameters) {
		Resource resource = USE_IN_RUNEXLUSIVE_getResource(descriptor);
		for (AccessMethod accessMethod : resource.getAccessMethod()) {
			if (accessMethod.getType().equals(type)) {
				if (accessMethod.getParameter().size() == nbOfParameters) {
					return accessMethod;
				}
			}
		}
		return null;
	}

	protected void USE_IN_RUNEXCLUSIVE_removeResource(final ResourceDescriptor descriptor) {
		Service service = USE_IN_RUNEXLUSIVE_getService(descriptor.getGateway(), descriptor.getDevice(),
				descriptor.getService());
		if (service != null) {
			EList<Resource> resources = service.getResource();
			for (int i = 0; i < resources.size(); i++) {
				Resource resource = resources.get(i);
				if (descriptor.getResource().equals(resource.getName())) {
					resources.remove(i);
					return;
				}
			}
		}
	}

	protected void USE_IN_RUNEXCLUSIVE_removeService(final String gatewayName, final String deviceId,
			final String serviceId) {
		Device device = USE_IN_RUNEXLUSIVE_getDevice(gatewayName, deviceId);
		if (device != null) {
			EList<Service> services = device.getService();
			for (int i = 0; i < services.size(); i++) {
				Service service = services.get(i);
				if (serviceId.equals(service.getName())) {
					services.remove(i);
					return;
				}
			}
		}
	}

	/* ============ */
	/* RunExclusive */
	/* ============ */

	protected static EClass literalToType(final String type) {

		final EClass resourceType;
		// Literals
		EClass stateVariableLiteral = ResourcePackage.Literals.STATE_VARIABLE;
		EClass actionLiteral = ResourcePackage.Literals.ACTION;
		EClass propertyLiteral = ResourcePackage.Literals.PROPERTY;
		EClass sensorDataLiteral = ResourcePackage.Literals.SENSOR_DATA;

		if ("STATE_VARIABLE".equals(type)) {
			resourceType = stateVariableLiteral;
		} else if ("ACTION".equals(type)) {
			resourceType = actionLiteral;
		} else if ("PROPERTY".equals(type)) {
			resourceType = propertyLiteral;
		} else if ("SENSOR".equals(type)) {
			resourceType = sensorDataLiteral;
		} else {
			logger.error(ModelEditor.class.getCanonicalName() + "::updateResource with type=" + type + " - Is it a bug or a feature ?");
			resourceType = actionLiteral;
		}
		return resourceType;
	}

	/* ============= */
	/* MODEL HELPERS */
	/* ============= */

	protected Device findAppManager(EList<Device> devices) {
		for (Device device : devices) {
			if (device.getName().equals("AppManager"))
				return device;
		}
		return null;
	}

	protected List<ServiceDescriptor> findApplications(Device appManager) {
		List<ServiceDescriptor> retval = new ArrayList<>();

		String gateway = ((Gateway) appManager.eContainer()).getName();
		String device = appManager.getName();

		for (Service service : appManager.getService()) {
			String srvName = service.getName();
			if (srvName != null && (!srvName.equalsIgnoreCase("admin"))) {
				retval.add(new ServiceDescriptor(gateway, device, srvName));
			}
		}
		return retval;
	}

}
