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

import org.apache.log4j.Logger;
import org.restlet.Application;
import org.restlet.resource.ServerResource;

/**
 * @author Etienne Gandrille
 */
public class RouteUtil {

	public static final String ENCODING = "UTF-8";
	
	private static final Logger logger = Logger.getLogger(RouteUtil.class);
	
	private static final GatewayHttpServer server = GatewayHttpServer.getInstance();
	
	public static boolean attachRoute(String pathTemplate, Class<? extends ServerResource> targetClass) {
		try {
			server.attach(pathTemplate, targetClass);
			return true;
		} catch (Exception e) {
			logger.error("attach route fails", e);
			return false;
		}
	}
	
	public static boolean attachRoute(String pathTemplate, Application application) {
		try {
			server.attach(pathTemplate, application);
			return true;
		} catch (Exception e) {
			logger.error("attach route fails", e);
			return false;
		}
	}	
}
