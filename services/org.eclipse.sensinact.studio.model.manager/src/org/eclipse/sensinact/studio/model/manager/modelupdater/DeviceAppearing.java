/**
 * 
 */
package org.eclipse.sensinact.studio.model.manager.modelupdater;

import org.eclipse.sensinact.studio.http.messages.snamessage.ObjectNameTypeValue;
import org.eclipse.sensinact.studio.model.resource.utils.DeviceDescriptor;

/**
 *
 */
public class DeviceAppearing extends ModelUpdate<DeviceDescriptor> {

	/**
	 * @param object
	 */
	public DeviceAppearing(DeviceDescriptor object) {
		super(object);
	}

	@Override
	public boolean addNext(ModelUpdate<?> next){
		if(super.addNext(next)){
			if(next instanceof ResourceAppearing
				&& "location".equals(((ResourceAppearing)next).object.getResource()) 
				&& "admin".equals(((ResourceAppearing)next).object.getService())){	
					ObjectNameTypeValue ontv = ((ResourceAppearing)next).object.getInitial();
					if(ontv!=null)
						super.object.setLocation(ontv.getValueAsString());
				}
			return true;
		}
		return false;
	}

	@Override
	protected void doApply(){
		ModelUpdater.executeInThread( () -> {
			ModelEditor.getInstance().addDeviceIfNotExist(
			super.object.getGateway(),
			super.object.getDevice(),
			super.object.getIcon(),
			super.object.getLocation());
		});
	}
	
	@Override
	public boolean complete(){		
		return doComplete();
	}
	
	@Override
	protected boolean doComplete() {
		return super.object.getGateway()!=null 
		   && super.object.getDevice()!=null 
		   && super.object.getLocation()!=null 
		   && super.existsGateway(super.object.getGateway());
	}
}
