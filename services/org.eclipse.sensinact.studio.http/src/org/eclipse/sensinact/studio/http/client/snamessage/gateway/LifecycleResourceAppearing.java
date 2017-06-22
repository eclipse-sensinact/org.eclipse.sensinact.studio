/**
 * Copyright (c) 2017 CEA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     CEA - initial API and implementation and/or initial documentation
 */
package org.eclipse.sensinact.studio.http.client.snamessage.gateway;

import org.eclipse.sensinact.studio.http.client.snamessage.LifecycleMessage;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Etienne Gandrille
 */
public class LifecycleResourceAppearing extends LifecycleMessage {

	public static final String KEY = "RESOURCE_APPEARING";
	private final String resourceType;
	private String name;
	private String type;
	private String initValue;
	
	public LifecycleResourceAppearing(JSONObject message) throws JSONException {
		super(message,KEY, toTab(message.getString("uri")), 3);
		resourceType = message.getJSONObject("notification").getString("type");
		
		if (message.has("initial")){ 
			initValue=message.getJSONObject("initial").getString("value");
			name=message.getJSONObject("initial").getString("name");
			type=message.getJSONObject("initial").getString("type");
		}else
			initValue = null;
	}

	@Override
	public String getFullDescription() {
		return super.getFullDescription() + "\ntype: " + resourceType + ((initValue==null)?"":("\ninfo: " + initValue.toString()));
	}
	
	@Override
	public String getProvider() {
		return super.getProvider();
	}
	
	@Override
	public String getService() {
		return super.getService();
	}
	
	@Override
	public String getResource() {
		return super.getResource();
	}
	
	public String getResourceType() {
		return resourceType;
	}
	
	public String getInitValue() {
		return initValue;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}
	
	
}