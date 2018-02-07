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
public class ResponseKO extends ResponseMessage{

	private final List<String> messages = new ArrayList<>();
	private final List<String> traces = new ArrayList<>();
	
	public ResponseKO(JSONObject jsonObject) {
		super(jsonObject);
		System.out.println("Creating response KO from:"+jsonObject.toString());
		try {
			JSONArray errors = jsonObject.getJSONArray("errors");
			
			for (int i=0; i<errors.length(); i++) {
				JSONObject error = errors.getJSONObject(i);
				messages.add(error.getString("message"));
				traces.add(error.getString("trace"));
			}			
		} catch (JSONException e) {
			e.printStackTrace();
			//throw new IllegalArgumentException(this.getClass().getName() + " json malformed");
		}
	}

	public String getPrettyPrintedValue() {
		return messages.size() + " error(s)";
	}

	public String getFullDescription() {
		String msg = messages.size() + " error(s)";
		
		for (int i=0; i< messages.size(); i++) {
			msg +="\n---\n";
			msg += "message: " + messages.get(i) + "\n";
			msg += "trace: " + traces.get(i);
		}
		
		return msg;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((messages == null) ? 0 : messages.hashCode());
		result = prime * result + ((traces == null) ? 0 : traces.hashCode());
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
		ResponseKO other = (ResponseKO) obj;
		if (messages == null) {
			if (other.messages != null)
				return false;
		} else if (!messages.equals(other.messages))
			return false;
		if (traces == null) {
			if (other.traces != null)
				return false;
		} else if (!traces.equals(other.traces))
			return false;
		return true;
	}
}
