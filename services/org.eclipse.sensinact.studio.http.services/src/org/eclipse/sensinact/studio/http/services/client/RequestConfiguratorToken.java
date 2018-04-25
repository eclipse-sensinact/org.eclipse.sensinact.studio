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

import org.eclipse.sensinact.studio.preferences.GatewayHttpConfig;
import org.restlet.engine.header.Header;
import org.restlet.resource.ClientResource;
import org.restlet.util.Series;

/**
 * @author Etienne Gandrille
 */
public class RequestConfiguratorToken implements RequestConfigurator {


	private final String HEADER = "X-AUTH-TOKEN"; 
	private final AccessToken token;
	
	public RequestConfiguratorToken(AccessToken token) {
		this.token = token;
	}

	@Override
	public void configure(GatewayHttpConfig gwInfo, ClientResource clientResource) {
		Series<Header> headers = getHeaders(clientResource);			
		headers.set(HEADER, token.getToken());
		// think twice before removing...
		headers.set("Connection", "close");
	}
}
