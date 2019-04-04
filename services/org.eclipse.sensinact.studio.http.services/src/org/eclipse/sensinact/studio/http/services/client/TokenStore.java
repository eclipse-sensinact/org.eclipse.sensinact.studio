/**
 * Copyright (c) 2019 CEA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     CEA - initial API and implementation and/or initial documentation
 */
package org.eclipse.sensinact.studio.http.services.client;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class TokenStore {
	
	private final Map<String, AccessToken> tokens = new HashMap<>(); 

	private static final Logger logger = Logger.getLogger(TokenStore.class);

	private static TokenStore INSTANCE = null;

	private TokenStore() {
	}

	public synchronized static TokenStore getInstance() {
		if (INSTANCE == null)
			INSTANCE = new TokenStore();
		return INSTANCE;
	}

	public AccessToken getToken(String gwName) {
		return tokens.get(gwName);
	}

	public void save(String gwName, AccessToken token) {
		tokens.put(gwName, token);
	}
	
	
	
}
