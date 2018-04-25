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
package org.eclipse.sensinact.studio.http.services.client;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Etienne Gandrille
 */
public class UIResult {
	
	private final String title;
	private final String message;
	private final DialogStatus status;
	
	private static final Logger logger = Logger.getLogger(UIResult.class);
	
	public UIResult(String title, String message, DialogStatus status) {
		this.title = title;
		this.message = message;
		this.status = status;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getMessage() {
		return message;
	}
	
	public DialogStatus getStatus() {
		return status;
	}
	
	public enum DialogStatus {
		SUCCESS, ERROR;
	}

	public JSONObject asJson() {
		JSONObject result = new JSONObject();
		try {
			result.put("title", title);
			result.put("message", message);
			result.put("status", status.name());
		} catch (JSONException e) {
			logger.error(e);
		}
		return result;
	}
}
