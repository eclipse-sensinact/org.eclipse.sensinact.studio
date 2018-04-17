package org.eclipse.sensinact.studio.view.projectexplorer.handler.sna2json;

public class Variable {

	private final String appName;
	private final String prefix;
	private final int cpt;
	
	public Variable(String appName, String prefix, int cpt) {
		this.appName = appName;
		this.prefix = prefix;
		this.cpt = cpt;
	}

	public String getShortName() {
		return prefix + cpt;
	}
	
	public String getFullName() {
		return "/" + appName + "/" + prefix + cpt + "/result";
	}
	
	@Override
	public String toString() {
		return "Variable [appName=" + appName + ", prefix=" + prefix + ", cpt=" + cpt + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appName == null) ? 0 : appName.hashCode());
		result = prime * result + cpt;
		result = prime * result + ((prefix == null) ? 0 : prefix.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Variable other = (Variable) obj;
		if (appName == null) {
			if (other.appName != null)
				return false;
		} else if (!appName.equals(other.appName))
			return false;
		if (cpt != other.cpt)
			return false;
		if (prefix == null) {
			if (other.prefix != null)
				return false;
		} else if (!prefix.equals(other.prefix))
			return false;
		return true;
	}	
}
