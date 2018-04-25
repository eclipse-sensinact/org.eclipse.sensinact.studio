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
package org.eclipse.sensinact.studio.http.services.server.serverstarted;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

/**
 * @author Etienne Gandrille
 */
public class ServerUpdatedManager {

	private static final Logger logger = Logger.getLogger(ServerUpdatedManager.class);
	
	private static ServerUpdatedManager INSTANCE = null;
	private final Set<ServerUpdatedListener> listeners = new HashSet<ServerUpdatedListener>(); 
	
	private ServerUpdatedManager() {
	}

	public static ServerUpdatedManager getInstance() {
		if (INSTANCE == null)
			INSTANCE = new ServerUpdatedManager();
		return INSTANCE;
	}
	
	public void removeServerUpdatedListener(ServerUpdatedListener listener) {
		listeners.remove(listener);
	}

	public void addServerUpdatedListener(ServerUpdatedListener listener) {
		listeners.add(listener);
	}

	public void notifyServerUpdated(UpdateDescriptor descriptor) {
		logger.debug("Server updated. Notification fired (" + listeners.size() + " listeners");
		for (ServerUpdatedListener listener : listeners) {
			listener.serverUpdated(descriptor);
		}
	}
}
