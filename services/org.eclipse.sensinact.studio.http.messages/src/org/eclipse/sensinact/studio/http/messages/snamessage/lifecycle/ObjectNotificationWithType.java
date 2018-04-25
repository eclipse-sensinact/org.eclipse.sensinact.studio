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
package org.eclipse.sensinact.studio.http.messages.snamessage.lifecycle;

/**
 * @author Etienne Gandrille
 */
public class ObjectNotificationWithType {
	
	private String lifecycle;
	private String type;
	
	public String getLifecycle() {
		return lifecycle;
	}
	
	public void setLifecycle(String lifecycle) {
		this.lifecycle = lifecycle;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lifecycle == null) ? 0 : lifecycle.hashCode());
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
		ObjectNotificationWithType other = (ObjectNotificationWithType) obj;
		if (lifecycle == null) {
			if (other.lifecycle != null)
				return false;
		} else if (!lifecycle.equals(other.lifecycle))
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
		return "ObjectNotificationWithType [lifecycle=" + lifecycle + ", type=" + type + "]";
	}
}
