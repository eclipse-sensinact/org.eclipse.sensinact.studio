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
package org.eclipse.sensinact.studio.http.services.client;

import java.util.Date;

import org.eclipse.sensinact.studio.http.messages.snamessage.tokencreation.MsgTokenCreation;

/**
 * @author Etienne Gandrille
 */
public class AccessToken {
	
	private final String token;
	private final long generated;
	private final long validUntil;
	
	public AccessToken(MsgTokenCreation reponse) {
		this.token = reponse.getToken();
		this.generated = reponse.getGenerated();
		this.validUntil = reponse.getValidUntil();
	}

	public boolean isValid() {
		Date now = new Date();
		return now.before(new Date(validUntil));
	}
	
	public String getToken() {
		return token;
	}
}
