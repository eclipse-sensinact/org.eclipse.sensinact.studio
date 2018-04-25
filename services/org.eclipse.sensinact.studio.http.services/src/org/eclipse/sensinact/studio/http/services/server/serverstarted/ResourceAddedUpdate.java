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

import java.util.List;

/**
 * @author Etienne Gandrille
 */
public class ResourceAddedUpdate extends UpdateDescriptor {
	
	private final String curPath;
	private final List<String> registeredPaths;

	public ResourceAddedUpdate(String curPath, List<String> registeredPaths) {
		super(UpdateType.RESOURCE_ADDED);
		this.curPath = curPath;
		this.registeredPaths = registeredPaths;
	}

	public List<String> getRegisteredPath() {
		return registeredPaths;
	}
	
	public String getCurPath() {
		return curPath;
	}
}
