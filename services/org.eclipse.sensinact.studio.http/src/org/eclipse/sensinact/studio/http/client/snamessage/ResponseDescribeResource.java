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

import org.eclipse.sensinact.studio.http.client.snamessage.gateway.ResponseDescribe;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Etienne Gandrille
 */
public class ResponseDescribeResource extends ResponseDescribe {

	private final String name;
	private final String type;
	private final List<RestAM> accessMethods = new ArrayList<>();
	
	public ResponseDescribeResource(JSONObject jsonObject, JSONObject info) throws JSONException {
		super(jsonObject, info);
		
		name = info.getString("name");
		
		JSONArray jsonAms = info.getJSONArray("accessMethods");
		for (int i=0; i< jsonAms.length(); i++) {
			accessMethods.add(new RestAM(jsonAms.getJSONObject(i)));
		}

		type = info.getString("type");
	}
	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
	
	public List<RestAM> getAccessMethods() {
		return accessMethods;
	}
	
	public class RestAM {

		public final String name;
		public final List<RestParam> parameters = new ArrayList<>();
		
		public RestAM(JSONObject jsonObject) throws JSONException {
			this.name = jsonObject.getString("name");
			JSONArray params = jsonObject.getJSONArray("parameters");
			for (int i=0; i< params.length(); i++) {
				parameters.add(new RestParam(params.getJSONObject(i)));
			}
		}
		
	}
	
	public class RestParam {

		public final String name;
		public final boolean fixed;
		public final String type;
		
		public RestParam(JSONObject jsonObject) throws JSONException {
			this.name = jsonObject.getString("name");
			this.fixed = jsonObject.getBoolean("fixed");
			this.type = jsonObject.getString("type");
		}
	}
}
