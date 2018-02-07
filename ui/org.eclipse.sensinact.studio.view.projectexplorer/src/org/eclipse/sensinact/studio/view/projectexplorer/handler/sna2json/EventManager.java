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

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * The goal of an event manager is to provide the default events which should trigger a component if the component doesn't have any events. 
 * The EventManager is designed to be used by a component builder, just before a component is built.  
 * @author Etienne Gandrille
 */
public interface EventManager {
	
	public abstract List<JSONObject> getDefaultEvents() throws JSONException;		
}