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

import org.eclipse.sensinact.studio.model.resource.utils.Segments;
import org.json.JSONObject;

/**
 * @author Etienne Gandrille
 */
public class ErrorMessage extends SnaMessage {

	private final Exception e;
	private final Segments segments;
	
	
	ErrorMessage(JSONObject json,Exception e, Segments segments) {
		super(json);
		this.e = e;
		this.segments = segments;
	}
	
	
	@Override
	public String getPrettyPrintedValue() {
		return "ERROR on " + segments.toString();
	}

	@Override
	public String getFullDescription() {
		return getPrettyPrintedValue() + "\n" + e.getMessage();
	}

	@Override
	public boolean isValid() {
		return false;
	}
}
