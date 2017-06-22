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

import java.util.Arrays;

import org.json.JSONObject;

/**
 * @author Etienne Gandrille
 */
public abstract class LifecycleMessage extends SnaMessage {

	private final String type;
	private final String[] uri;
	
	public LifecycleMessage(JSONObject json,String type, String[] uri, int expectedUriSegments) {
		super(json);
		this.type = type;
		this.uri = uri;
		if (expectedUriSegments != uri.length)
			throw new IllegalArgumentException("uri has " + uri.length + " segments but should have " + expectedUriSegments);
	}

	protected String getProvider() {
		return uri[0];
	}
	
	protected String getService() {
		return uri[1];
	}
	
	protected String getResource() {
		return uri[2];
	}
	
	@Override
	public boolean isValid() {
		return true;
	}
	
	@Override
	public String getPrettyPrintedValue() {
		return type + " " + Arrays.toString(uri);
	}

	@Override
	public String getFullDescription() {
		return getPrettyPrintedValue();
	}
}
