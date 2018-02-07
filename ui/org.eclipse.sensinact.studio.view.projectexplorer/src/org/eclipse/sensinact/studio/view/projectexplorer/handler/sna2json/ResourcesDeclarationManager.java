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
package org.eclipse.sensinact.studio.view.projectexplorer.handler.sna2json;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;

import org.eclipse.sensinact.studio.language.sensinact.DSL_Resource;

/**
 * @author Etienne Gandrille
 */
public class ResourcesDeclarationManager {

	private final Map<String, DSL_Resource> name2fullPath = new HashMap<>();
	
	public ResourcesDeclarationManager(EList<DSL_Resource> resources) {
		for (DSL_Resource resource : resources) {
			name2fullPath.put(resource.getName(), resource);
		}
	}
	
	public DSL_Resource getResourceFromName(String name) {
		DSL_Resource resource = name2fullPath.get(name);
		if (resource == null)
			throw new IllegalArgumentException(name);
		return resource;
	}
	
	public String getPathFromName(String name) {
		DSL_Resource resource = getResourceFromName(name);
		return "/" + resource.getDeviceID() + "/" + resource.getServiceID() + "/" + resource.getResourceID();
	}
}
