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

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Etienne Gandrille
 */
public abstract class RestMessage extends ResponseMessage {

	protected final List<String> internalList = new ArrayList<>(); 
	
	
	public RestMessage(JSONObject jsonObject, String key) throws JSONException {
		super(jsonObject);
		
		JSONArray array = jsonObject.getJSONArray(key);
		for (int i=0; i<array.length(); i++)
			internalList.add(array.getString(i));
	}
	
	@Override
	public String getPrettyPrintedValue() {
		return internalList.toString();
	}

	@Override
	public String getFullDescription() {
		return internalList.toString();
	}
}
