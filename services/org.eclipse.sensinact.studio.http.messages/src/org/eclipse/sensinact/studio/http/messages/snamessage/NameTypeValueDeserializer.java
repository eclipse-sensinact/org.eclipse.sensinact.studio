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

import java.io.IOException;
import java.util.Optional;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

/**
 * @author Etienne Gandrille
 */
public class NameTypeValueDeserializer extends StdDeserializer<ObjectNameTypeValue> {

	private static final long serialVersionUID = -2698830271936665275L;

	public NameTypeValueDeserializer() { 
        this(null); 
    } 
 
    public NameTypeValueDeserializer(Class<?> vc) { 
        super(vc); 
    }
	
	@Override
	public ObjectNameTypeValue deserialize(JsonParser parser, DeserializationContext ctx) throws IOException, JsonProcessingException {
		
		JsonNode node = parser.getCodec().readTree(parser);
        
		String name = node.get("name").textValue();
		
		String typeName = node.get("type").textValue();
		ValueType type = ValueType.fromName(typeName);
		if (type == null)
			throw new RuntimeException("Type value with typeName " + typeName + " NOT FOUND");		
		
		Object value = type.getObject(node.get("value"));
		
		Optional<Long> timestamp;
		if (node.has("timestamp"))
			timestamp = Optional.of(node.get("timestamp").asLong());
		else
			timestamp = Optional.empty();

		return new  ObjectNameTypeValue(name, type, value, timestamp);
	}
}
