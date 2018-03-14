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

import org.eclipse.sensinact.studio.model.resource.utils.Segments;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Etienne Gandrille
 */
public class SnaMessage {

	private final String type;
	private final String uri;
	private final JSONObject json;
	
	public SnaMessage(JSONObject json, String type, String uri) {
		this.json=json;
		this.type=type;
		this.uri=uri;
	}
	
	public SnaMessage(JSONObject json){
		System.out.println("MESSAGE IN RESPONSE:"+json.toString());
		try {
			this.json=json;
			this.type = json.getString("type");
			this.uri = json.getString("uri");
		} catch (JSONException e) {
			e.printStackTrace();
			throw new IllegalArgumentException(this.getClass().getName() + " json malformed");
		}
	}
	
	public String getPrettyPrintedValue(){
		return json.toString();
	}

	public String getFullDescription(){
		return json.toString();
	}

	public boolean isValid(){
		return true;
	}
	
	public static SnaMessage build(JSONObject json,Exception e, Segments segments) {
		return new ErrorMessage(json,e, segments);
	}
		
	@Override
	public String toString() {
		return getFullDescription();
	}
		
	protected static String[] toTab(String path) {
		path = cleanPath(path);
		if (path == null) {
			return new String[0];
		}
		return path.split("/");
	}
	
	private static String cleanPath(String path) {
		if (path == null) {
			return null;
		}
		path = path.trim();
		if (path.startsWith("/")) {
			path = path.substring(1);
		}
		if (path.endsWith("/")) {
			path = path.substring(0, path.length() - 1);
		}
		return path;
	}
	
	public String getUri() {
		return uri;
	}
	public String getType() {
		return type;
	}

	public JSONObject getJson() {
		return json;
	}
	
	
	
}
