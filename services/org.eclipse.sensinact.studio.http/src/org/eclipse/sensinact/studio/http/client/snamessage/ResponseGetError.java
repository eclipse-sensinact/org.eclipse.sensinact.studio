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

import org.eclipse.sensinact.studio.http.client.snamessage.gateway.ResponseGet;
import org.json.JSONObject;

/**
 * @author Etienne Gandrille
 */
public class ResponseGetError extends ResponseGet {

	private final ResponseKO ko;

	//{"statusCode":520,"errors":[{"message":"A JSONObject text must begin with '{' at 1 [character 2 line 1]","trace":"org.json.JSONTokener.syntaxError(JSONTokener.java:433)"}],"type":"GET_RESPONSE","uri":"/light/admin/lifecycleStatus"}
	public ResponseGetError(JSONObject jsonObject, ResponseKO responseKO) {
		super(jsonObject);
		this.ko = responseKO;
	}

	@Override
	public String getPrettyPrintedValue() {
		return ko.getPrettyPrintedValue();
	}
	
	@Override
	public String getFullDescription() {	
		return super.getFullDescription() + ko.getFullDescription();
	}
}
