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

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.apache.log4j.Logger;
import org.eclipse.sensinact.studio.http.services.server.serverstarted.PortUpdate;
import org.eclipse.sensinact.studio.http.services.server.serverstarted.ResourceAddedUpdate;
import org.eclipse.sensinact.studio.http.services.server.serverstarted.ServerUpdatedManager;
import org.eclipse.sensinact.studio.preferences.ConfigurationListerner;
import org.eclipse.sensinact.studio.preferences.ConfigurationManager;
import org.eclipse.sensinact.studio.preferences.GatewayHttpConfig;
import org.restlet.Component;
import org.restlet.Restlet;
import org.restlet.data.Protocol;
import org.restlet.engine.Engine;
import org.restlet.resource.ServerResource;

/**
 * @author Etienne Gandrille
 */
public class GatewayHttpServer extends SensinactServerResource implements ConfigurationListerner {

	private static final Logger logger = Logger.getLogger(GatewayHttpServer.class);

	private Component serverComponent;

	private List<String> registeredPaths = new ArrayList<>();

	private boolean serverRuning = false;

	private static GatewayHttpServer instance;

	synchronized public static GatewayHttpServer getInstance() {
		if (instance == null) {
			instance = new GatewayHttpServer();
			try {
				int port = ConfigurationManager.getStudioPort();
				instance.initServer();
				instance.updateServerPort(port);
			} catch (Exception e) {
				logger.error("GatewayHttpServer creation", e);
			}
		}
		return instance;
	}

	public boolean isServerRuning() {
		return serverRuning;
	}

	private GatewayHttpServer() {
		ConfigurationManager.addListener(this);
		configureEngine();
	}

	private void configureEngine() {
		// Restlet global config
		Engine.setLogLevel(Level.OFF);

		// This is used to allow the server to return bundle resources
		Engine.getInstance().getRegisteredClients().add(new BundleResourceClientHelper(null));
	}

	private void initServer() throws Exception {
		if (serverComponent == null) {

			// Create the webapp component
			serverComponent = new Component();
			serverComponent.getClients().add(BundleResourceClientHelper.BUNDLERESOURCE);
		}
	}

	public void attach(String uriPattern, Restlet target) throws Exception {
		logger.debug("http resource registered: " + uriPattern);
		registeredPaths.add(uriPattern);
		serverComponent.getDefaultHost().attach(uriPattern, target);
		if (serverComponent.isStarted())
			ServerUpdatedManager.getInstance().notifyServerUpdated(new ResourceAddedUpdate(uriPattern, registeredPaths));
	}

	public void attach(String pathTemplate, Class<? extends ServerResource> targetClass) throws Exception {
		logger.debug("http resource registered: " + pathTemplate);
		registeredPaths.add(pathTemplate);
		serverComponent.getDefaultHost().attach(pathTemplate, targetClass);
		if (serverComponent.isStarted())
			ServerUpdatedManager.getInstance().notifyServerUpdated(new ResourceAddedUpdate(pathTemplate, registeredPaths));
	}

	public void updateServerPort(int port) throws Exception {
		// stop running server
		if (serverRuning) {
			serverRuning = false;
			serverComponent.stop();
			serverComponent.getServers().remove(0);
		}

		// start new server
		if (port != 0) {
			serverComponent.getServers().add(Protocol.HTTP, port);
			serverComponent.start();
			serverRuning = true;
		}

		// notify
		ServerUpdatedManager.getInstance().notifyServerUpdated(new PortUpdate(port));
	}

	/* ======================== */
	/* Config listener callback */
	/* ======================== */

	@Override
	public void studioPortUpdatedNotif(int port) {
		try {
			updateServerPort(port);
		} catch (Exception e) {
			logger.error("update server port", e);
		}
	}

	@Override
	public void gatewayAddedOrUpdatedNotif(GatewayHttpConfig gateway) {
		// do nothing
	}

	@Override
	public void gatewayRemovedNotif(String name) {
		// do nothing
	}
}
