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
package org.eclipse.sensinact.studio.http.client.snamessage;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Etienne Gandrille
 */
public class RestResourcesList extends RestMessage {
	
	public static final Object KEY = "RESOURCES_LIST";

	public RestResourcesList(JSONObject jsonObject) throws JSONException {
		super(jsonObject, "resources");
	}
	
	public List<String> getResources() {
		return internalList;
	}
}
