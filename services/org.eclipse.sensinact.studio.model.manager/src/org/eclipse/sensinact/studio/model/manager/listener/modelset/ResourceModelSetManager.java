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
package org.eclipse.sensinact.studio.model.manager.listener.modelset;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;

/**
 * @author Etienne Gandrille
 */
public class ResourceModelSetManager {

	private static final Logger logger = Logger.getLogger(ResourceModelSetManager.class);
	
	private static ResourceModelSetManager INSTANCE = null;

	private List<ResourceModelSetListener> listeners = new ArrayList<>();
	
	private ResourceModelSetManager() {
	}

	public static ResourceModelSetManager getInstance() {
		if (INSTANCE == null)
			INSTANCE = new ResourceModelSetManager();
		return INSTANCE;
	}
	
	public boolean subscribe(ResourceModelSetListener listener) {
		return listeners.add(listener);
	}
	
	public boolean unsubscribe(ResourceModelSetListener listener) {
		return listeners.remove(listener);
	}
	
	void notifyListeners(ResourceSetChangeEvent event) {
		logger.debug("Resource model set updated. Notification fired (" + listeners.size() + " listeners");
		for (ResourceModelSetListener listener : listeners) {
			listener.modelSetUpdated(event);
		}
	}
}
