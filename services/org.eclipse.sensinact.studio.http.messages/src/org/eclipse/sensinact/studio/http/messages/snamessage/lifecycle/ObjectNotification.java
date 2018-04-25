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
public class ObjectNotification {

	private String lifecycle;

	public String getLifecycle() {
		return lifecycle;
	}

	public void setLifecycle(String lifecycle) {
		this.lifecycle = lifecycle;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lifecycle == null) ? 0 : lifecycle.hashCode());
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
		ObjectNotification other = (ObjectNotification) obj;
		if (lifecycle == null) {
			if (other.lifecycle != null)
				return false;
		} else if (!lifecycle.equals(other.lifecycle))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ObjectNotification [lifecycle=" + lifecycle + "]";
	}
}
