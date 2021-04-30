/**
 * 
 */
package org.eclipse.sensinact.studio.model.manager.modelupdater;

import org.eclipse.sensinact.studio.http.messages.snamessage.ObjectNameTypeValue;
import org.eclipse.sensinact.studio.model.resource.utils.DeviceDescriptor;
import org.eclipse.sensinact.studio.model.resource.utils.GPScoordinates;
import org.eclipse.sensinact.studio.model.resource.utils.GPSparsingException;
import org.eclipse.sensinact.studio.model.resource.utils.ResourceDescriptor;

/**
 *
 */
public class ResourceAppearing extends ModelUpdate<ResourceDescriptor> {

	/**
	 * @param object
	 */
	public ResourceAppearing(ResourceDescriptor object) {
		super(object);
	}

	@Override
	protected void doApply(){		
		ResourceDescriptor d = super.object;
		ModelUpdater.executeInThread(
			() -> ModelEditor.getInstance().addResourceIfNotExist(super.object)
		);
		ObjectNameTypeValue ontv = d.getInitial();
		if(ontv==null) 
			return;
		String value = ontv.getValueAsString();
		if(value==null || "null".equals(value))
			return;
		final DeviceDescriptor descriptor = new DeviceDescriptor(d.getGateway(),d.getDevice());
		if("location".equals(d.getResource()) && "admin".equals(d.getService())){				
			GPScoordinates gps;
			try {
				gps = new GPScoordinates(value);
			} catch (GPSparsingException e) {
				e.printStackTrace();
				return;
			}
			ModelUpdater.executeInThread(() -> ModelEditor.getInstance().setLocation(descriptor, gps));
		}		
		if("icon".equals(d.getResource()) && "admin".equals(d.getService())){
			ModelUpdater.executeInThread(() -> ModelEditor.getInstance().setIcon(descriptor, value));
		}
	}

	@Override
	protected boolean doComplete() {
		return super.object.getGateway()!=null &&
			   super.object.getDevice()!=null  &&
			   super.object.getService()!=null &&
			   super.object.getResource()!=null &&
			   super.existsService(super.object.getGateway(),super.object.getDevice(),super.object.getService());
	}

}
