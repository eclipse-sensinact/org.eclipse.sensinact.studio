/**
 * Copyright (c) 2018 CEA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     CEA - initial API and implementation and/or initial documentation
 */
package org.eclipse.sensinact.studio.http.messages.snamessage.describeresource;

import java.util.List;

/**
 * @author Etienne Gandrille
 */
public class ObjectResponse {
	
	private String name;
	private String type;
	private List<ObjectAttribute> attributes;
	private List<ObjectAccessMethods> accessMethods;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public List<ObjectAttribute> getAttributes() {
		return attributes;
	}
	
	public void setAttributes(List<ObjectAttribute> attributes) {
		this.attributes = attributes;
	}
	
	public List<ObjectAccessMethods> getAccessMethods() {
		return accessMethods;
	}
	
	public void setAccessMethods(List<ObjectAccessMethods> accessMethods) {
		this.accessMethods = accessMethods;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accessMethods == null) ? 0 : accessMethods.hashCode());
		result = prime * result + ((attributes == null) ? 0 : attributes.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		ObjectResponse other = (ObjectResponse) obj;
		if (accessMethods == null) {
			if (other.accessMethods != null)
				return false;
		} else if (!accessMethods.equals(other.accessMethods))
			return false;
		if (attributes == null) {
			if (other.attributes != null)
				return false;
		} else if (!attributes.equals(other.attributes))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "ObjectResponse [name=" + name + ", type=" + type + ", attributes=" + attributes + ", accessMethods="
				+ accessMethods + "]";
	}
}
