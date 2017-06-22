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

import org.eclipse.sensinact.studio.http.client.snamessage.SnaMessage;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Etienne Gandrille
 */
public class AttributeValueUpdate extends SnaMessage {

	private String name;
	private String value;
	private String type;
	
	public AttributeValueUpdate(JSONObject json) {
		super(json);
		JSONObject notification;
		try {
			notification = super.getJson().getJSONObject("notification");
			name=notification.getString("name");
			type=notification.getString("type");
			value=notification.getString("value");
		} catch (JSONException e) {
			e.printStackTrace();
			throw new IllegalArgumentException(this.getClass().getName() + " json malformed");
		}
		
		
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

	public String getType() {
		return type;
	}

	
	
}
