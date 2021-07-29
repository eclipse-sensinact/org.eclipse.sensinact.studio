/**
 * Copyright (c) 2019 CEA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     CEA - initial API and implementation and/or initial documentation
 */
package org.eclipse.sensinact.studio.webapp.indoor;

import org.eclipse.sensinact.studio.http.services.server.RouteUtil;
import org.eclipse.sensinact.studio.webapp.indoor.content.IndoorApplication;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

/**
 * @author Etienne Gandrille
 */
@Component
public class Startup{

	private IndoorApplication route;

	@Activate
	public void activate() {
		RouteUtil.attachRoute("/webapp/indoor", route = new IndoorApplication());
	}
	
	public void deactivate() {
		RouteUtil.detachRoute("/webapp/indoor", route);
	}
}
