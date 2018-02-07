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
package org.eclipse.sensinact.studio.webapp.outdoor.content;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.data.Reference;
import org.restlet.resource.Directory;

/**
 * @author Nicolas Hili
 * @since  Nov 19, 2014
 */
public class OutdoorResources extends Application {
	@Override
    public Restlet createInboundRoot() {
    	Directory dir = new Directory(getContext(), new Reference(getClass().getClassLoader().getResource("/webapp")));
    	return dir;
    }
}