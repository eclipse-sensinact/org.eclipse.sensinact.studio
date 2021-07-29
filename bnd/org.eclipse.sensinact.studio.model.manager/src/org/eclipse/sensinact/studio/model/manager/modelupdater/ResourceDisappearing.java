/**
 * 
 */
package org.eclipse.sensinact.studio.model.manager.modelupdater;

import org.eclipse.sensinact.studio.model.resource.utils.ResourceDescriptor;

/**
 *
 */
public class ResourceDisappearing extends ModelUpdate<ResourceDescriptor> {

	/**
	 * @param object
	 */
	public ResourceDisappearing(ResourceDescriptor object) {
		super(object);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.sensinact.studio.model.manager.modelupdater.ModelUpdate#doApply()
	 */
	@Override
	protected void doApply(){
		
		ModelUpdater.executeInThread(
				() -> ModelEditor.getInstance().removeResource(
						super.object)
			);
	}

	@Override
	protected boolean doComplete() {
		return super.object.getGateway()!=null &&
			   super.object.getDevice()!=null &&
			   super.object.getService()!=null &&
			   super.object.getResource()!=null;
	}

}
