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

import java.util.Map;

import org.eclipse.sensinact.studio.preferences.GatewayHttpConfig;
import org.restlet.engine.header.Header;
import org.restlet.resource.ClientResource;
import org.restlet.util.Series;

/**
 * @author Etienne Gandrille
 */
public interface RequestConfigurator {	
	public void configure(GatewayHttpConfig gwInfo, ClientResource clientResource);
		
	default Series<Header> getHeaders(ClientResource clientResource) {
		String KEY = "org.restlet.http.headers";	
		Map<String, Object> attr = clientResource.getRequestAttributes();
		if (! attr.containsKey(KEY))
			attr.put(KEY, new Series<>(Header.class));
		Series<Header> headers = (Series<Header>) attr.get(KEY);
		return headers;
	}
}
