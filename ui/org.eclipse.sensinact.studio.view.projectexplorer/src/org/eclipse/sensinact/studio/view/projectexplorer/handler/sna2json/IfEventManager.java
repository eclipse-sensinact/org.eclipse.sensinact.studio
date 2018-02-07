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

import org.json.JSONException;
import org.json.JSONObject;

import org.eclipse.sensinact.studio.language.sensinact.DSL_REF;

/**
 * @author Etienne Gandrille
 */
public class IfEventManager implements EventManager {

	private final List<DSL_REF> triggers;
	private final ResourcesDeclarationManager resMgr;
	
	public IfEventManager(ResourcesDeclarationManager resMgr, List<DSL_REF> triggers) {
		this.triggers = triggers;
		this.resMgr = resMgr;
	}

	@Override
	public List<JSONObject> getDefaultEvents() throws JSONException {
		List<JSONObject> list = new ArrayList<>();
		
		for (DSL_REF ref : triggers) {
			list.add(ComponentBuilder.resourceVariableInternal(resMgr, ref));
		}
		
		return list;
	}
	
}