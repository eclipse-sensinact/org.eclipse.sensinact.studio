package org.eclipse.sensinact.studio.model.manager.modelupdater;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.sensinact.studio.model.resource.utils.Descriptor;
import org.eclipse.sensinact.studio.model.resource.utils.ResourceDescriptor;

public abstract class ModelUpdate<D extends Descriptor> {

	protected abstract void doApply();
	protected abstract boolean doComplete();
	
	protected final D object;
	protected List<ModelUpdate<?>> next;

	public ModelUpdate(D object){
		this.object = object;
		next = new ArrayList<>();
	}

	public boolean complete(){		
		if(doComplete()){			
			for(ModelUpdate<?> mu:next){				
				if(!mu.complete())
					return false;
			}
			return true;
		}
		return false;
	}
	
	public void apply(){		
		if(!complete())
			return;
		this.doApply();
		for(ModelUpdate<?> mu:next){
			mu.apply();
		}
	}

	private Descriptor getDescriptor(){
		return this.object;
	}
	
	public boolean addNext(ModelUpdate<?> next){		
		int compare = this.object.compareTo(next.getDescriptor());		
		if(compare==0 || compare==1)
			return false;
		for(ModelUpdate<?> mu:this.next){			
			if(mu.addNext(next))
				return true;
		}
		return this.next.add(next);
	}
	
	public boolean branch(ModelUpdate<?> mu) {
		Descriptor d = mu.object;
		String branch = d.commonBranch(object);
		return branch!=null && branch.length()>1;
	}

	protected boolean existsGateway(final String gatewayId) {
		return ModelEditor.getInstance().getGatewaysId().contains(gatewayId);
	}

	protected boolean existsDevice(final String gatewayId, String deviceId) {
		return ModelEditor.getInstance().getDevicesId(gatewayId).contains(deviceId);
	}

	protected boolean existsService(final String gatewayId, String deviceId, String serviceId){
		return ModelEditor.getInstance().getServicesId(gatewayId, deviceId).contains(serviceId);
	}

	protected boolean existsResource(final String gatewayId, String deviceId, String serviceId, String resourceId) {
		return this.existsResource(new ResourceDescriptor(gatewayId, deviceId, serviceId, resourceId));
	}

	protected boolean existsResource(ResourceDescriptor descriptor) {
		return ModelEditor.getInstance().getResourcesId(descriptor.getGateway(), descriptor.getDevice(), descriptor.getService()).contains(descriptor.getResource());
	}
}
