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
package org.eclipse.sensinact.studio.navigator.device;

import java.text.Collator;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.sensinact.studio.resource.impl.NamedElementImpl;

/**
 * @author Etienne Gandrille
 */
 public class DeviceNavigatorSorter extends ViewerSorter {

	public DeviceNavigatorSorter() {
	}

	public DeviceNavigatorSorter(Collator collator) {
		super(collator);
	}
	
	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {
		NamedElementImpl object1 = (NamedElementImpl) e1;
		NamedElementImpl object2 = (NamedElementImpl) e2;
		
		return object1.getName().compareToIgnoreCase(object2.getName());
	}
}
