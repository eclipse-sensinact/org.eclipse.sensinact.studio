package org.eclipse.sensinact.studio.model.resource.utils;

/**
 *
 */
public class GatewayDescriptor extends AbstractDescriptor {


	protected GatewayDescriptor(String gateway) {
		super(gateway);
	}

	@Override
	public String getPath() {
		return "/";
	}
	
}
