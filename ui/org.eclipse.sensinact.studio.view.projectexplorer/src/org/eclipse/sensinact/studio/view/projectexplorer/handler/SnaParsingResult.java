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
package org.eclipse.sensinact.studio.view.projectexplorer.handler;

import org.json.JSONObject;

/**
 * @author Etienne Gandrille
 */
public class SnaParsingResult {

	private final JSONObject jsonApplication;
	
	public SnaParsingResult(JSONObject jsonApplication) {
		this.jsonApplication = jsonApplication;
	}

	public JSONObject getApplication() {
		return jsonApplication;
	}
}
