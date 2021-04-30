package org.eclipse.sensinact.studio.model.manager.modelupdater;


import org.eclipse.sensinact.studio.model.resource.utils.DeviceDescriptor;

public class DeviceDisappearing extends ModelUpdate<DeviceDescriptor> {

	/**
	 * @param object
	 */
	public DeviceDisappearing(DeviceDescriptor object) {
		super(object);
	}

	@Override
	protected void doApply(){		
		ModelUpdater.executeInThread( () -> {
			ModelEditor.getInstance().removeDevice(
				super.object.getGateway(),
				super.object.getDevice());
			}
		);
	}

	@Override
	protected boolean doComplete() {
		return super.object.getGateway()!=null &&
			   super.object.getDevice()!=null;
	}

}
