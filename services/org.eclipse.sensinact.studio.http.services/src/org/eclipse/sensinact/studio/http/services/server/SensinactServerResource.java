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
package org.eclipse.sensinact.studio.http.services.server;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.restlet.resource.ServerResource;

/**
 * @author Etienne Gandrille
 */
public abstract class SensinactServerResource extends ServerResource {

	protected String getRequestAttribute(String name) throws UnsupportedEncodingException {		
		return URLDecoder.decode(getRequestAttributes().get(name).toString(), RouteUtil.ENCODING);
	}
}
