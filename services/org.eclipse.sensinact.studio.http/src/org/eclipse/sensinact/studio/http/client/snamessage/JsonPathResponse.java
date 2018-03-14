package org.eclipse.sensinact.studio.http.client.snamessage;

import org.json.JSONObject;

public class JsonPathResponse extends ResponseMessage {

	private final String filterDefinition;
	private final String filterType;

	
	public JsonPathResponse(JSONObject json) {
		super(json, "jsonpath", "");
		
		try {
			JSONObject filter = json.getJSONObject("filter");
			filterDefinition = filter.getString("definition");
			filterType = filter.getString("type");
		} catch (Exception e) {
			throw new IllegalArgumentException("Json path response malformed " + json, e);
		}
	}

	public String getFilterDefinition() {
		return filterDefinition;
	}
	
	public String getFilterType() {
		return filterType;
	}
}

