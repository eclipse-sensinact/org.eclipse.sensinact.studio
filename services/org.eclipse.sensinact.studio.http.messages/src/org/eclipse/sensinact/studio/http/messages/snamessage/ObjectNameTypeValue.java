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
package org.eclipse.sensinact.studio.http.messages.snamessage;

import java.util.Optional;

/**
 * @author Etienne Gandrille
 */
public class ObjectNameTypeValue {
	
	private final String name;
	private final ValueType type;
	private final Object value;
	private final Optional<Long> timestamp;
	
	public ObjectNameTypeValue(String name, ValueType type, Object value, long timestamp) {
		this(name, type, value, Optional.of(timestamp));
	}

	public ObjectNameTypeValue(String name, ValueType type, Object value) {
		this(name, type, value, Optional.empty());
	}
	
	public ObjectNameTypeValue(String name, ValueType type, Object value, Optional<Long> timestamp) {
		this.name = name;
		this.type = type;
		this.value = value;
		this.timestamp = timestamp;
	}
	
	public String getName() {
		return name;
	}
		
	public ValueType getType() {
		return type;
	}
	
	public String getValueAsString() {
		if (value == null)
			return "null";
		else
			return value.toString();
	}
	
	public Optional<Long> getTimestamp() {
		return timestamp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((timestamp == null) ? 0 : timestamp.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		ObjectNameTypeValue other = (ObjectNameTypeValue) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		if (type != other.type)
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ObjectNameTypeValue [name=" + name + ", type=" + type + ", value=" + value + ", timestamp=" + timestamp
				+ "]";
	}	
}
