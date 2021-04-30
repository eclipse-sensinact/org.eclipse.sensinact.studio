package org.eclipse.sensinact.studio.model.resource.utils;

public interface Descriptor extends Comparable<Descriptor> {

	String getGateway();
	
	String getPath();
	
	String commonBranch(Descriptor descriptor);
}
