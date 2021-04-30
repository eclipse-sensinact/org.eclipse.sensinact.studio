/**
 * 
 */
package org.eclipse.sensinact.studio.model.manager.modelupdater;

import org.eclipse.sensinact.studio.model.resource.utils.ServiceDescriptor;

/**
 *
 */
public class ServiceAppearing extends ModelUpdate<ServiceDescriptor> {

	/**
	 * @param object
	 */
	public ServiceAppearing(ServiceDescriptor object) {
		super(object);
	}

	@Override
	protected void doApply(){
		ModelUpdater.executeInThread(
			() -> ModelEditor.getInstance().addServiceIfNotExist(
					super.object.getGateway(),
					super.object.getDevice(),
					super.object.getService())
			);
	}
	
	@Override
	protected boolean doComplete() {
		return super.object.getGateway()!=null &&
			   super.object.getDevice()!=null &&
			   super.object.getService()!=null &&
			   super.existsDevice(super.object.getGateway(),super.object.getDevice());
	}

}
