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
package org.eclipse.sensinact.studio.view.projectexplorer.handler.sna2json;

import java.util.UUID;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import org.eclipse.sensinact.studio.language.sensinact.DSL_REF;
import org.eclipse.sensinact.studio.language.sensinact.DSL_Resource;

/**
 * Helper class to build components which are JSON objects.
 * @author Etienne Gandrille
 */
class ComponentBuilder {

	private final String functionName;
	private final String identifier;
	private final boolean register;
	
	private final JSONArray events = new JSONArray();
	private final JSONArray runparameters = new JSONArray();
	
	private final EventManager eventManager;
	private final ResourcesDeclarationManager resMgr;
	
	// To prevent the object from being built twice
	private boolean isBuilt = false;
	
	public ComponentBuilder(String functionName, String identifier, boolean register, EventManager eventManager, ResourcesDeclarationManager resMgr) {
		this.functionName = functionName;
		if (identifier == null || identifier.isEmpty())
			this.identifier = UUID.randomUUID().toString();
		else
			this.identifier = identifier;
		this.register = register;
		this.eventManager = eventManager;
		this.resMgr = resMgr;
	}
		
	public JSONObject build() throws JSONException {
		
		if (isBuilt)
			throw new RuntimeException("Object has already been built");
		isBuilt = true;
		
		JSONObject component = new JSONObject();
		component.put("events", events);	
		component.put("function", buildFunction(functionName, runparameters));
		component.put("identifier", identifier);
		
		// register
		JSONObject reg = new JSONObject();
		reg.put("register", register);
		component.put("properties", reg);
		
		// default events
		if (events.length() == 0) {
			for (JSONObject object : eventManager.getDefaultEvents())
				events.put(object);
		}
		
		return component;
	}
		
	private JSONObject buildFunction(String name, JSONArray runparameters) throws JSONException {
		JSONObject function = new JSONObject();
		function.put("name", name);
		function.put("runparameters", runparameters);
		return function;
	}

	public ComponentBuilder parameter(String value) throws JSONException {
		runparameters.put(valueType(value, "string"));
		return this;
	}
	
	public ComponentBuilder parameter(long value) throws JSONException {
		runparameters.put(valueType(value));
		return this;
	}	
	
	public ComponentBuilder parameter(double value) throws JSONException {
		runparameters.put(valueType(value));
		return this;
	}	
	
	public ComponentBuilder parameter(boolean value) throws JSONException {
		runparameters.put(valueType(value));
		return this;
	}	
	
	public ComponentBuilder parameter(DSL_REF value) throws JSONException {
		return resourceVariable(value, runparameters);
	}
	
	public ComponentBuilder parameterEvents(DSL_REF[] values) throws JSONException {
		runparameters.put(valueType(values));
		return this;
	}

	public ComponentBuilder parameterEvent(DSL_REF value) throws JSONException {
		runparameters.put(valueType(value));
		return this;
	}

	public ComponentBuilder parameterEvent(String name) throws JSONException {
		runparameters.put(valueType(name, "event"));
		return this;
	}
	
	public ComponentBuilder event(DSL_REF value) throws JSONException {
		return resourceVariable(value, events);
	}
			
	public ComponentBuilder eventVariable(String value) throws JSONException {
		events.put(valueType(value, "variable"));
		return this;
	}
	
	private ComponentBuilder resourceVariable(DSL_REF value, JSONArray array) throws JSONException {
		array.put(resourceVariableInternal(resMgr, value));
		return this;
	}
	
	static JSONObject resourceVariableInternal(ResourcesDeclarationManager resMgr, DSL_REF value) throws JSONException {
		String v = resMgr.getPathFromName(value.getName());
		String t = getTypeName(value);
		return valueType(v, t);
	}
	
	private JSONObject valueType(double value) throws JSONException {
		JSONObject vt = new JSONObject();
		vt.put("value", value);
		vt.put("type", "double");
		return vt;
	}
	
	private JSONObject valueType(long value) throws JSONException {
		JSONObject vt = new JSONObject();
		vt.put("value", value);
		vt.put("type", "long");
		return vt;
	}
	
	private JSONObject valueType(Boolean value) throws JSONException {
		JSONObject vt = new JSONObject();
		vt.put("value", value);
		vt.put("type", "boolean");
		return vt;
	}	

	
	private JSONObject valueType(DSL_REF value) throws JSONException {
		String v = resMgr.getPathFromName(value.getName());
		String t = getTypeName(value); 
		return valueType(v, t);
	}
	
	private static String getTypeName(DSL_REF value) {
		if (value instanceof DSL_Resource)
			return"resource";
		else
			return "variable";
	}	
	
	static JSONObject valueType(String value, String type) throws JSONException {
		JSONObject vt = new JSONObject();
		vt.put("value", value);
		vt.put("type", type);
		return vt;
	}	
	
	private JSONObject valueType(DSL_REF[] values) throws JSONException {
		JSONObject vt = new JSONObject();	
		JSONArray val = new JSONArray();
		for (DSL_REF v : values)
			val.put(resMgr.getPathFromName(v.getName()));
		vt.put("value", val);
		vt.put("type", "todo"); // syntax error : we can't assume all values have the same type
		return vt;
	}

	public ComponentBuilder parameterVariable(String name) throws JSONException {
		runparameters.put(valueType(name, "variable"));
		return this;
	}
}
