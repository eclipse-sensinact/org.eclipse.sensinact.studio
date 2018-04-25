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

/**
 * @author Etienne Gandrille
 */
public class PortUpdate extends UpdateDescriptor {

	private final int port;

	public PortUpdate(int port) {
		super(UpdateType.PORT_UPDATE);
		this.port = port;
	}

	public int getPort() {
		return port;
	}
}
