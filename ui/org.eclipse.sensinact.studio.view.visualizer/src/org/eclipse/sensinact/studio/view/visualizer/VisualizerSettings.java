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
package org.eclipse.sensinact.studio.view.visualizer;

import org.eclipse.sensinact.studio.model.resource.utils.ResourceDescriptor;

/**
 * @author Etienne Gandrille
 */
public class VisualizerSettings {

	private final ResourceDescriptor rDescriptor;
	private final String typeName;
	
	public VisualizerSettings(ResourceDescriptor rDescriptor, String typeName) {
		this.rDescriptor = rDescriptor;
		this.typeName = typeName;
	}
	
	public ResourceDescriptor getDescriptor() {
		return rDescriptor;
	}

	public String getTypeName() {
		return typeName;
	}
}
