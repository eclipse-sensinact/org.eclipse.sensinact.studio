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

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Etienne Gandrille
 */
public class BooleanVariableEventManager implements EventManager {
	
	private final boolean trueFalse;
	private final Variable variable;
	
	public BooleanVariableEventManager(Variable variable, boolean trueFalse) {
		this.trueFalse = trueFalse;
		this.variable = variable;
	}
	
	@Override
	public List<JSONObject> getDefaultEvents() throws JSONException {
		List<JSONObject> list = new ArrayList<>();
		
		JSONObject vt = ComponentBuilder.valueType(variable.getFullName(), "variable");
		JSONObject cond = new JSONObject();
		cond.put("operator", "=");
		cond.put("value", trueFalse);
		cond.put("type", "boolean");
		cond.put("complement", false);
		
		JSONArray array = new JSONArray();
		array.put(cond);
		
		vt.put("conditions", array);
		list.add(vt);		

		return list;
	}
}