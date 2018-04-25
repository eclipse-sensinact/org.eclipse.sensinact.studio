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

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sensinact.studio.http.messages.snamessage.MsgSensinact;
import org.eclipse.sensinact.studio.http.messages.snamessage.describeresource.MsgDescribeRessource;
import org.eclipse.sensinact.studio.http.messages.snamessage.describeresource.ObjectAccessMethods;
import org.eclipse.sensinact.studio.http.messages.snamessage.describeresource.ObjectParameter;
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
import org.eclipse.sensinact.studio.resource.Device;
import org.eclipse.sensinact.studio.resource.Gateway;
import org.eclipse.sensinact.studio.resource.Parameter;
import org.eclipse.sensinact.studio.resource.Resource;
import org.eclipse.sensinact.studio.resource.ResourceFactory;
import org.eclipse.sensinact.studio.resource.ResourcePackage;
import org.eclipse.sensinact.studio.resource.Service;
import org.eclipse.sensinact.studio.resource.Studio;

/**
 * @author Nicolas Hili, Etienne Gandrille
 */
public class ModelEditor implements ConfigurationListerner {

	/* ===================== */
	/* Model data structures */
	/* ===================== */

	private static org.eclipse.emf.ecore.resource.Resource resource;

	private final static String EDITING_DOMAIN_ID = "org.eclipse.sensinact.studio.model.resource.editingDomain";

	private static TransactionalEditingDomain editingDomain;

	private static final Logger logger = Logger.getLogger(ModelEditor.class);

	private static ModelEditor INSTANCE = null;

	private ModelEditor() {
		ConfigurationManager.addListener(this);
	}

	public synchronized static ModelEditor getInstance() {
		if (INSTANCE == null)
			INSTANCE = new ModelEditor();
		return INSTANCE;
	}

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

	private synchronized static TransactionalEditingDomain getEditingDomain() {
		if (editingDomain == null) {
			editingDomain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain(EDITING_DOMAIN_ID);
		}
		return editingDomain;
	}

	private static org.eclipse.emf.ecore.resource.Resource getResource() {
		if (resource == null) {
			String path = "/org.eclipse.sensinact.studio.model.resource/cache/resource.cache";
			URI uri = URI.createPlatformPluginURI(path, true);
			resource = getEditingDomain().getResourceSet().createResource(uri);
		}
		return resource;
	}

	/**
	 * IMPORTANT. This method MUST NOT BE USED TO UPDATE THE MODEL !!!!
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public Studio getViewerInput() throws InterruptedException {

		setupStudio();

		// Init available gateways names
		for (GatewayHttpConfig gateway : ConfigurationManager.getGateways()) {
			addGatewayIfNotExist_UNSAFE(gateway.getName());
		}

		return (Studio) getEditingDomain().runExclusive(new RunnableWithResult.Impl<Studio>() {
			@Override
			public void run() {
				setResult(USE_IN_RUNEXLUSIVE_getStudio());
				return;
			}
		});
	}

	private void setupStudio() {
		
		final String label=getResource() instanceof Resource?((Resource)getResource()).getName():"Unknown resource";
		
		RecordingCommand command = new RecordingCommand(getEditingDomain(),label) {
			@Override
			protected void doExecute() {
				EList<EObject> contents = getResource().getContents();
				if (contents.size() == 0)
					getResource().getContents().add(ResourceFactory.eINSTANCE.createStudio());
			}
		};
		getEditingDomain().getCommandStack().execute(command);
	}

	/* ====================== */
	/* Internal NON EXCLUSIVE */
	/* ====================== */

	private static Studio USE_IN_RUNEXLUSIVE_getStudio() {
		EList<EObject> contents = getResource().getContents();
		return (Studio) contents.get(0);
	}

	private static Gateway USE_IN_RUNEXLUSIVE_getGateway(String gatewayName) {
		EList<Gateway> gateways = USE_IN_RUNEXLUSIVE_getStudio().getGateways();
		for (Gateway gateway : gateways) {
			if (gateway.getName().equals(gatewayName)) {
				return gateway;
			}
		}
		return null;
	}

	private static Device USE_IN_RUNEXLUSIVE_getDevice(String gatewayName, String devicename) {

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

	private static Service USE_IN_RUNEXLUSIVE_getService(String gatewayName, String devicename, String servicename) {
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

	private static Resource USE_IN_RUNEXLUSIVE_getResource(ResourceDescriptor descriptor) {
		Service service = USE_IN_RUNEXLUSIVE_getService(descriptor.getGateway(), descriptor.getDevice(), descriptor.getService());
		if (service == null)
			return null;

		for (Resource resource : service.getResource()) {
			if (resource.getName().equals(descriptor.getResource())) {
				return resource;
			}
		}

		return null;
	}

	private void USE_IN_RUNEXLUSIVE_addDeviceIfNotExist(final String gatewayName, final String deviceId) {
		if (USE_IN_RUNEXLUSIVE_getDevice(gatewayName, deviceId) != null)
			return;

		final Device addedDevice = ResourceFactory.eINSTANCE.createDevice();
		addedDevice.setName(deviceId);
		USE_IN_RUNEXLUSIVE_getGateway(gatewayName).getDevice().add(addedDevice);
	}

	private void USE_IN_RUNEXLUSIVE_addServiceIfNotExist(final String gatewayName, final String deviceId, final String serviceId) {
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

	/* ======= */
	/* Get IDs */
	/* ======= */

	@SuppressWarnings("unchecked")
	public List<String> getGatewaysId() throws InterruptedException {
		setupStudio();

		return (List<String>) getEditingDomain().runExclusive(new RunnableWithResult.Impl<List<String>>() {
			@Override
			public void run() {
				List<String> retval = new ArrayList<String>();
				EList<Gateway> gateways = USE_IN_RUNEXLUSIVE_getStudio().getGateways();
				for (Gateway gateway : gateways) {
					retval.add(gateway.getName());
				}
				setResult(retval);
				return;
			}
		});
	}

	@SuppressWarnings("unchecked")
	public List<String> getConnectedGatewaysId() throws InterruptedException {
		setupStudio();

		return (List<String>) getEditingDomain().runExclusive(new RunnableWithResult.Impl<List<String>>() {
			@Override
			public void run() {
				List<String> retval = new ArrayList<String>();
				EList<Gateway> gateways = USE_IN_RUNEXLUSIVE_getStudio().getGateways();
				for (Gateway gateway : gateways) {
					if (gateway.getDevice().size() != 0)
						retval.add(gateway.getName());
				}
				setResult(retval);
				return;
			}
		});
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getDevicesId(final String gatewayName) throws InterruptedException {

		//setupStudio();

		return (List<String>) getEditingDomain().runExclusive(new RunnableWithResult.Impl<List<String>>() {
			@Override
			public void run() {
				List<String> retval = new ArrayList<String>();
				EList<Device> devices = USE_IN_RUNEXLUSIVE_getGateway(gatewayName).getDevice();
				for (Device device : devices) {
					retval.add(device.getName());
				}
				setResult(retval);
				return;
			}
		});
	}

	@SuppressWarnings("unchecked")
	public List<String> getServicesId(final String gatewayName, final String devicename) throws InterruptedException {

		//setupStudio();

		return (List<String>) getEditingDomain().runExclusive(new RunnableWithResult.Impl<List<String>>() {
			@Override
			public void run() {
				List<String> retval = new ArrayList<String>();
				Device device = USE_IN_RUNEXLUSIVE_getDevice(gatewayName, devicename);

				if (device != null) {
					for (Service service : device.getService()) {
						retval.add(service.getName());
					}
				}

				setResult(retval);
				return;
			}
		});
	}

	@SuppressWarnings("unchecked")
	public List<String> getResourcesId(final String gatewayName, final String devicename, final String servicename) throws InterruptedException {

		setupStudio();

		return (List<String>) getEditingDomain().runExclusive(new RunnableWithResult.Impl<List<String>>() {
			@Override
			public void run() {
				List<String> retval = new ArrayList<String>();

				Service service = USE_IN_RUNEXLUSIVE_getService(gatewayName, devicename, servicename);

				if (service != null) {
					for (Resource resource : service.getResource()) {
						retval.add(resource.getName());
					}
				}

				setResult(retval);
				return;
			}
		});
	}

	/* ================= */
	/* Find Applications */
	/* ================= */
	
	@SuppressWarnings("unchecked")
	public List<ServiceDescriptor> findApplications() throws InterruptedException {

		setupStudio();

		return (List<ServiceDescriptor>) getEditingDomain().runExclusive(new RunnableWithResult.Impl<List<ServiceDescriptor>>() {
			@Override
			public void run() {
				List<ServiceDescriptor> retval = new ArrayList<>();
				EList<Gateway> gateways = USE_IN_RUNEXLUSIVE_getStudio().getGateways();
				for (Gateway gateway : gateways) {
					Device appManager = findAppManager(gateway.getDevice());
					if (appManager != null) {
						retval.addAll(findApplications(appManager));
					}
				}
				setResult(retval);
				return;
			}
			
			private Device findAppManager(EList<Device> devices) {
				for (Device device : devices) {
					if (device.getName().equals("AppManager"))
						return device;
				}
				return null;
			}
			
			private List<ServiceDescriptor> findApplications(Device appManager) {
				List<ServiceDescriptor> retval = new ArrayList<>();
				
				String gateway = ((Gateway) appManager.eContainer()).getName();
				String device = appManager.getName();
				
				for (Service service : appManager.getService()) {
					String srvName = service.getName();
					if (srvName != null && (! srvName.equalsIgnoreCase("admin"))) {
						retval.add(new ServiceDescriptor(gateway, device, srvName));
					}
				}
				return retval;
			} 
		});
	}
		
	/* ============= */
	/* Checks exists */
	/* ============= */

	public boolean existsGateway(final String gatewayId) throws InterruptedException {
		return getGatewaysId().contains(gatewayId);
	}

	public boolean existsDevice(final String gatewayId, String deviceId) throws InterruptedException {
		return getDevicesId(gatewayId).contains(deviceId);
	}

	public boolean existsService(final String gatewayId, String deviceId, String serviceId) throws InterruptedException {
		return getServicesId(gatewayId, deviceId).contains(serviceId);
	}

	public boolean existsResource(final String gatewayId, String deviceId, String serviceId, String resourceId) throws InterruptedException {
		return existsResource(new ResourceDescriptor(gatewayId, deviceId, serviceId, resourceId));
	}

	public boolean existsResource(ResourceDescriptor descriptor) throws InterruptedException {
		return getResourcesId(descriptor.getGateway(), descriptor.getDevice(), descriptor.getService()).contains(descriptor.getResource());
	}

	/* ============== */
	/* Access Methods */
	/* ============== */

	@SuppressWarnings("unchecked")
	public EList<AccessMethod> getAccessMethods(final ResourceDescriptor descriptor) throws InterruptedException {

		setupStudio();

		EList<AccessMethod> accessMethods = null;
		accessMethods = (EList<AccessMethod>) getEditingDomain().runExclusive(new RunnableWithResult.Impl<EList<AccessMethod>>() {
			@Override
			public void run() {
				EList<AccessMethod> accessMethods = new BasicEList<AccessMethod>();
				Resource resource = USE_IN_RUNEXLUSIVE_getResource(descriptor);
				for (AccessMethod accessMethod : resource.getAccessMethod()) {
					accessMethods.add(accessMethod);
				}
				setResult(accessMethods);
				return;
			}
		});
		return accessMethods;
	}

	@SuppressWarnings("unchecked")
	public EList<AccessMethod> getAccessMethodsWithType(final ResourceDescriptor descriptor, final AccessMethodType type) throws InterruptedException {

		setupStudio();

		EList<AccessMethod> accessMethods = null;
		accessMethods = (EList<AccessMethod>) getEditingDomain().runExclusive(new RunnableWithResult.Impl<EList<AccessMethod>>() {
			@Override
			public void run() {
				EList<AccessMethod> accessMethods = new BasicEList<AccessMethod>();
				Resource resource = USE_IN_RUNEXLUSIVE_getResource(descriptor);
				for (AccessMethod accessMethod : resource.getAccessMethod()) {
					if (accessMethod.getType().equals(type)) {
						accessMethods.add(accessMethod);
					}
				}
				setResult(accessMethods);
				return;
			}
		});
		return accessMethods;
	}

	public AccessMethod getAccessMethodWithTypeNbParams(final ResourceDescriptor descriptor, final AccessMethodType type, final int nbOfParameters)
			throws InterruptedException {

		setupStudio();

		return (AccessMethod) getEditingDomain().runExclusive(new RunnableWithResult.Impl<AccessMethod>() {
			@Override
			public void run() {
				Resource resource = USE_IN_RUNEXLUSIVE_getResource(descriptor);
				for (AccessMethod accessMethod : resource.getAccessMethod()) {
					if (accessMethod.getType().equals(type)) {
						if (accessMethod.getParameter().size() == nbOfParameters) {
							setResult(accessMethod);
							return;
						}
					}
				}
				setResult(null);
				return;
			}
		});
	}

	/* ================= */
	/* ADD Objects by ID */
	/* ================= */

	// USE CAREFULLY
	// usually, if you want to add a gateway, use
	// ConfigurationManager.addGateway
	private void addGatewayIfNotExist_UNSAFE(final String gatewayName) {

		//setupStudio();

		RecordingCommand command = new RecordingCommand(getEditingDomain()) {

			@Override
			protected void doExecute() {
				if (USE_IN_RUNEXLUSIVE_getGateway(gatewayName) != null)
					return;

				final Gateway addedGateway = ResourceFactory.eINSTANCE.createGateway();
				addedGateway.setName(gatewayName);
				USE_IN_RUNEXLUSIVE_getStudio().getGateways().add(addedGateway);
				return;
			}
		};
		getEditingDomain().getCommandStack().execute(command);
	}

	public void addDeviceIfNotExist(final String gatewayName, final String deviceId) {

		//setupStudio();

		RecordingCommand command = new RecordingCommand(getEditingDomain()) {
			@Override
			protected void doExecute() {
				USE_IN_RUNEXLUSIVE_addDeviceIfNotExist(gatewayName, deviceId);
			}
		};
		getEditingDomain().getCommandStack().execute(command);
	}

	public void addServiceIfNotExist(final String gatewayName, final String deviceId, final String serviceId) {

		//setupStudio();

		RecordingCommand command = new RecordingCommand(getEditingDomain()) {
			@Override
			protected void doExecute() {
				USE_IN_RUNEXLUSIVE_addDeviceIfNotExist(gatewayName, deviceId);
				USE_IN_RUNEXLUSIVE_addServiceIfNotExist(gatewayName, deviceId, serviceId);
			}
		};
		getEditingDomain().getCommandStack().execute(command);
	}

	public void addResourceIfNotExist(final ResourceDescriptor descriptor) {

		//setupStudio();
		
		addServiceIfNotExist(descriptor.getGateway(), descriptor.getDevice(), descriptor.getService());

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

				RecordingCommand command = new RecordingCommand(getEditingDomain()) {
					@Override
					protected void doExecute() {

						if (USE_IN_RUNEXLUSIVE_getResource(descriptor) != null)
							return;

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

						USE_IN_RUNEXLUSIVE_getService(descriptor.getGateway(), descriptor.getDevice(), descriptor.getService()).getResource().add(
								createdResource);

						return;
					}
				};
				try {
					getEditingDomain().getCommandStack().execute(command);
				}catch (WrappedException we){
					getEditingDomain().getCommandStack().flush();
					//Caused by multiple events received.
				}
			}
		} catch (NullPointerException | InterruptedException e) {
			getEditingDomain().getCommandStack().flush();
			throw new RuntimeException("Unexpected exception... " + descriptor);
		}
	}

	static EClass literalToType(final String type) {

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

	/* ==================== */
	/* REMOVE Objects by ID */
	/* ==================== */

	// USE CAREFULLY
	// usually, if you want to remove a gateway, use
	// ConfigurationManager.removeGateway
	private void removeGateway_UNSAFE(final String gatewayName) {

		setupStudio();

		RecordingCommand command = new RecordingCommand(getEditingDomain()) {
			@Override
			protected void doExecute() {
				EList<Gateway> gateways = USE_IN_RUNEXLUSIVE_getStudio().getGateways();

				for (int i = 0; i < gateways.size(); i++) {
					Gateway gateway = gateways.get(i);
					if (gateway.getName().equals(gatewayName)) {
						gateways.remove(i);
						return;
					}
				}
			}
		};
		getEditingDomain().getCommandStack().execute(command);

		DeviceLocationManager.getInstance().deleteGatewayInStudio(gatewayName);
	}

	public void clearGatewayContent(String name) {
		try {
			for (String device : getDevicesId(name)) {
				removeDevice(name, device);
			}
		} catch (InterruptedException e) {
			logger.error("Clear gateway content failed", e);
		}
	}

	public void removeDevice(final String gatewayName, final String deviceId) {

		setupStudio();

		RecordingCommand command = new RecordingCommand(getEditingDomain()) {
			@Override
			protected void doExecute() {
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
		};
		getEditingDomain().getCommandStack().execute(command);

		DeviceLocationManager.getInstance().deleteDeviceInStudio(new DeviceDescriptor(gatewayName, deviceId));
	}

	public void removeService(final String gatewayName, final String deviceId, final String serviceId) {

		//setupStudio();

		RecordingCommand command = new RecordingCommand(getEditingDomain()) {
			@Override
			protected void doExecute() {
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
		};
		getEditingDomain().getCommandStack().execute(command);
	}

	public void removeResource(final ResourceDescriptor descriptor) {

		setupStudio();

		RecordingCommand command = new RecordingCommand(getEditingDomain()) {
			@Override
			protected void doExecute() {
				Service service = USE_IN_RUNEXLUSIVE_getService(descriptor.getGateway(), descriptor.getDevice(), descriptor.getService());
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
		};
		getEditingDomain().getCommandStack().execute(command);
	}

	/* ==== */
	/* MISC */
	/* ==== */

	public EClass getResourceClass(final ResourceDescriptor descriptor) throws InterruptedException {

		//setupStudio();

		return (EClass) getEditingDomain().runExclusive(new RunnableWithResult.Impl<EClass>() {
			@Override
			public void run() {
				Resource resource = USE_IN_RUNEXLUSIVE_getResource(descriptor);
				setResult(resource.eClass());
				return;
			}
		});
	}

	public int getAccessMethodNb(final ResourceDescriptor descriptor) throws InterruptedException {

		//setupStudio();

		return (Integer) getEditingDomain().runExclusive(new RunnableWithResult.Impl<Integer>() {
			@Override
			public void run() {
				Resource resource = USE_IN_RUNEXLUSIVE_getResource(descriptor);
				setResult(new Integer(resource.getAccessMethod().size()));
				return;
			}
		});
	}
}
