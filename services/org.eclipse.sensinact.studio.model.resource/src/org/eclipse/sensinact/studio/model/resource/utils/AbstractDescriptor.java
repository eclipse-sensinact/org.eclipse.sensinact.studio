package org.eclipse.sensinact.studio.model.resource.utils;

/**
 *
 */
public abstract class AbstractDescriptor implements Descriptor{

	public static String pathFormat(String path) {
		if(path == null || path.trim().equals("/"))
			return "/";

		String formatedPath = path.trim();
		if(!path.startsWith("/"))
			formatedPath="/"+formatedPath;

		if(path.endsWith("/"))
			formatedPath=formatedPath.substring(0,formatedPath.length()-1);	

		return formatedPath;
	}
	
	protected String gateway;

	protected AbstractDescriptor(String gateway) {
		this.gateway = gateway;
	}
	
	public String getParentPath() {
		String path =  getPath();
		int index = path.lastIndexOf('/');
		return path.substring(0, index);
	}

	@Override
	public String toString() {
		return this.gateway + getPath();
	}

	@Override
	public String commonBranch(Descriptor descriptor) {
		if(descriptor == null || !this.gateway.equals(descriptor.getGateway()))
			return null;

		String path = pathFormat(descriptor.getPath());
		String localPath = pathFormat(getPath());
		
		int localLength = localPath.length();
		int pathLength = path.length();
		
		int lastSep = -1;
		int index = 0;
		
		while(index < pathLength && index < localLength) {
			if(localPath.charAt(index)!=path.charAt(index)) {
				index = lastSep;
				break;
			}
			if(localPath.charAt(index)=='/')
				lastSep = index;

			index++;
		}
		if(index==0)
			return null;

		return localPath.substring(0,index);	
	}

	@Override
	public String getGateway(){
		return this.gateway;
	}
	
	/** 
	 * @inheritDoc
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 * 
	 * TODO Documentation:
	 * Compares this object with the specified object for order. Returns a 
	 * negative integer, zero, or a positive integer as this object is less 
	 * than, equal to, or greater than the specified object. The implementor 
	 * must ensure sgn(x.compareTo(y)) == -sgn(y.compareTo(x)) for all x and y. 
	 * (This implies that x.compareTo(y) must throw an exception 
	 * iff y.compareTo(x) throws an exception.)
	 * The implementor must also ensure that the relation is transitive: 
	 * (x.compareTo(y)>0 && y.compareTo(z)>0) implies x.compareTo(z)>0.
	 * Finally, the implementor must ensure that x.compareTo(y)==0 implies that 
	 * sgn(x.compareTo(z)) == sgn(y.compareTo(z)), for all z. It is strongly 
	 * recommended, but not strictly required that (x.compareTo(y)==0) == (x.equals(y)). 
	 * Generally speaking, any class that implements the Comparable interface and 
	 * violates this condition should clearly indicate this fact. The recommended 
	 * language is "Note: this class has a natural ordering that is inconsistent 
	 * with equals." In the foregoing description, the notation sgn(expression) 
	 * designates the mathematical signum function, which is defined to return 
	 * one of -1, 0, or 1 according to whether the value of expression is negative, 
	 * zero or positive.
	 */
	@Override
	public int compareTo(Descriptor descriptor) {
		if(this.gateway.equals(descriptor.getGateway())){
			
			String path = pathFormat(descriptor.getPath());
			String localPath = pathFormat(getPath());

			if(path.startsWith(localPath))
				return -1;

			if(localPath.startsWith(path))
				return 1;
		}
		return 0;	
	}
}
