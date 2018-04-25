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
import org.restlet.resource.ClientResource;

/**
 * @author Etienne Gandrille
 */
public class BasicConfigurator implements RequestConfigurator {
	@Override
	public void configure(GatewayHttpConfig gwInfo, ClientResource clientResource) {
		// do nothing
	}
}
