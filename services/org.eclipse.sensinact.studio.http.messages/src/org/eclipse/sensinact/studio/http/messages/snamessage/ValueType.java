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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * @author Etienne Gandrille
 */
public enum ValueType {

	// Should be temporary, since the gateway does not implements the enums yet.
	// Remove this when gateway will be updated
	TMP_MODIFIABLE("org.eclipse.sensinact.gateway.common.primitive.Modifiable", n -> n.asText()), 
	TMP_CONSTRAINT("Array of org.eclipse.sensinact.gateway.common.constraint.Constraint", n -> n.asText()),
	
	STRING("string", n -> n.asText()),
	LONG("long", n -> n.asLong()),
	DOUBLE("double", n -> n.asDouble()),
	INT("int", n -> n.asInt()),
	BOOLEAN("boolean", n -> n.asBoolean()),
	ARRAY("array", n -> computeArray(n));
	
	private String name;
	private Function<JsonNode, Object> nodeToObject;

	private static final Logger logger = Logger.getLogger(ValueType.class);

	private ValueType(String name, Function<JsonNode, Object> nodeToObject) {
		this.name = name;
		this.nodeToObject = nodeToObject;
	}
	
	public static ValueType fromName(String name) {
		for (ValueType value : values()) {
			if (value.getName().equals(name))
				return value;
		}
		logger.error("ValueName with type " + name + " NOT found");
		return null;
	}

	public String getName() {
		return name;
	}

	public Object getObject(JsonNode jsonNode) {
		return nodeToObject.apply(jsonNode);
	}
	
	private static List<String> computeArray(JsonNode n) {
		List<String> list = new ArrayList<>();
		
		for (Iterator<JsonNode> it = n.iterator(); it.hasNext();) {
			JsonNode elem = it.next();
			list.add(elem.asText());
		}
			
		return list;
	}
}
