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
import org.restlet.data.ChallengeScheme;
import org.restlet.resource.ClientResource;

/**
 * @author Etienne Gandrille
 */
public class RequestConfiguratorCred implements RequestConfigurator {
	
	@Override
	public void configure(GatewayHttpConfig gwInfo, ClientResource clientResource) {
		if (gwInfo.hasAuthentication())
			setAuthentication(clientResource, gwInfo);
	}
	
	private static void setAuthentication(ClientResource clientResource, GatewayHttpConfig gwInfo) {
		clientResource.setChallengeResponse(ChallengeScheme.HTTP_BASIC, gwInfo.getUsername(), gwInfo.getPassword());
	}
	
}
