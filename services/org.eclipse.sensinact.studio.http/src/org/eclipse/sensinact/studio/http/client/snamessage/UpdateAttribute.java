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
package org.eclipse.sensinact.studio.http.client.snamessage;

import org.eclipse.sensinact.studio.http.client.snamessage.gateway.AttributeValueUpdate;
import org.eclipse.sensinact.studio.model.resource.utils.ResourceDescriptor;
import org.json.JSONObject;

/**
 * @author Etienne Gandrille
 */
public class UpdateAttribute extends UpdateMessage {

	public static final String KEY = "ATTRIBUTE_VALUE_UPDATED";
	
	private final ResourceDescriptor target;
	private final AttributeValueUpdate value;
	
	// {"notification":{"timestamp":1465892666461,"name":"event","value":"{\"notification\":{\"lifecycle\":\"PROVIDER_APPEARING\"},\"type\":\"PROVIDER_APPEARING\",\"uri\":\"/slider\"}","type":"string"},"type":"ATTRIBUTE_VALUE_UPDATED","uri":"/sensiNact/system/event/value"} 
	public UpdateAttribute(String gateway, JSONObject jsonObject) {
		super(jsonObject);

		System.out.println("NOTIFICATION:"+jsonObject);
		target = new ResourceDescriptor(gateway + super.getUri());			
		value = new AttributeValueUpdate(jsonObject);
	}
		
	public ResourceDescriptor getTarget() {
		return target;
	}
	/*
	public int getTimestamp() {
		return value.getTimestamp();
	} */
	
	public String getName() {
		return value.getName();
	}
	
	public String getType() {
		return value.getType();
	}
	
	public String getValue() {
		return value.getValue();
	}
	
	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public String getPrettyPrintedValue() {
		return value.getPrettyPrintedValue();
	}
	
	@Override
	public String getFullDescription() {
		return String.format("%s %s", getUri(),value.getValue()!=null?value.getValue():"WAITING");
	}
}
