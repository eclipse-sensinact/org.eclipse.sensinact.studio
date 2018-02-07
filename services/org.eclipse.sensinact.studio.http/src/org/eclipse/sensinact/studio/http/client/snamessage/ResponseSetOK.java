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

import org.eclipse.sensinact.studio.http.client.snamessage.gateway.ResponseSet;
import org.json.JSONObject;

/**
 * @author Etienne Gandrille
 */
public class ResponseSetOK extends ResponseSet {

	private final ResponseOK ok;
	
	public ResponseSetOK(JSONObject jsonObject, ResponseOK responseOK) {
		super(jsonObject);
		this.ok = responseOK;
	}

	@Override
	public String getPrettyPrintedValue() {
		return ok.getPrettyPrintedValue();
	}
	
	@Override
	public String getFullDescription() {	
		return super.getFullDescription() + ok.getFullDescription();
	}
	
	public String getName() {
		return ok.getName();
	}
	
	public String getType() {
		return ok.getType();
	}
	
	public String getValue() {
		return ok.getValue();
	}
}
