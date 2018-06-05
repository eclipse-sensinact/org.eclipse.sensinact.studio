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
package org.eclipse.sensinact.studio.model.manager.http;

import org.eclipse.sensinact.studio.http.services.client.subscribe.agent.Agent;
import org.eclipse.sensinact.studio.http.services.client.subscribe.standard.OldSubscriptionManager;
import org.eclipse.sensinact.studio.http.services.server.RouteUtil;

/**
 * @author Etienne Gandrille
 */
public abstract class InitRoutes {

	public static void initRoutes() {
		RouteUtil.attachRoute("/webapp/deviceinfo/{gateway}/{device}", DeviceInfoRoute.class);
		RouteUtil.attachRoute("/webapp/deviceinfo/{gateway}/{device}/{service}", ServiceInfoRoute.class);
		RouteUtil.attachRoute("/webapp/performAction/{gateway}/{device}/{service}/{ressource}", PerformActionRoute.class);
		RouteUtil.attachRoute("/webapp/updatelocation/{gateway}/{device}", UpdateLocationRoute.class);
		RouteUtil.attachRoute(Agent.PATH, GatewayHttpServerRouteAgent.class);
		RouteUtil.attachRoute(OldSubscriptionManager.PATH, GatewayHttpServerRouteOld.class);
	}
}
