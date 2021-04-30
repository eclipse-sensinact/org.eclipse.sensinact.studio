/**
 * 
 */
package org.eclipse.sensinact.studio.model.manager.modelupdater;

import org.eclipse.sensinact.studio.model.resource.utils.ServiceDescriptor;

/**
 *
 */
public class ServiceDisappearing extends ModelUpdate<ServiceDescriptor> {

	/**
	 * @param object
	 */
	public ServiceDisappearing(ServiceDescriptor object) {
		super(object);
	}

	@Override
	protected void doApply(){
		
		ModelUpdater.executeInThread(
				() -> ModelEditor.getInstance().removeService(
					super.object.getGateway(),
					super.object.getDevice(),
					super.object.getService())
			);
	}

	@Override
	protected boolean doComplete() {
		return super.object.getGateway()!=null &&
			   super.object.getDevice()!=null &&
			   super.object.getService()!=null;
	}

}
