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
package org.eclipse.sensinact.studio.model.manager.http;

import org.eclipse.sensinact.studio.http.services.server.RouteUtil;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

/**
 * @author Etienne Gandrille
 */
@Component
public class InitRoutes {
	
	@Activate
	public void activate() {
		RouteUtil.attachRoute("/webapp/deviceinfo/{gateway}/{device}", DeviceInfoRoute.class);
		RouteUtil.attachRoute("/webapp/deviceinfo/{gateway}/{device}/{service}", ServiceInfoRoute.class);
		RouteUtil.attachRoute("/webapp/performAction/{gateway}/{device}/{service}/{ressource}", PerformActionRoute.class);
		RouteUtil.attachRoute("/webapp/updatelocation/{gateway}/{device}", UpdateLocationRoute.class);
	}
	
	@Deactivate
	public void deactivate() {
		RouteUtil.detachRoute("/webapp/deviceinfo/{gateway}/{device}", DeviceInfoRoute.class);
		RouteUtil.detachRoute("/webapp/deviceinfo/{gateway}/{device}/{service}", ServiceInfoRoute.class);
		RouteUtil.detachRoute("/webapp/performAction/{gateway}/{device}/{service}/{ressource}", PerformActionRoute.class);
		RouteUtil.detachRoute("/webapp/updatelocation/{gateway}/{device}", UpdateLocationRoute.class);
	}
}
