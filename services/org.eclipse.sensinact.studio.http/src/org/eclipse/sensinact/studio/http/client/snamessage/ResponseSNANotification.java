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

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Etienne Gandrille
 */
public class ResponseSNANotification extends SnaMessage {
	
	public ResponseSNANotification(JSONObject jsonObject) {
		super(jsonObject);
		//timestamp = triggered.getInt("timestamp");
		try {
			JSONObject jsonNotification=super.getJson().getJSONObject("notification");
			//name = jsonNotification.getString("name");
			//type = jsonNotification.getString("type");
			//value = jsonNotification.getString("value");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/*
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	*/
	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
