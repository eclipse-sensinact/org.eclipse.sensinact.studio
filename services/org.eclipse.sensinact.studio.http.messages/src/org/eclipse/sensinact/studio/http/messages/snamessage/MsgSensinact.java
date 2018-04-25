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
package org.eclipse.sensinact.studio.http.messages.snamessage;

/**
 * @author Etienne Gandrille
 */
public abstract class MsgSensinact {
	
	protected final String type;
	
	public MsgSensinact(String type) {
		this.type = type;
	}
	
	public final String getType() {
		return type;
	}
	
	public final void setType(String type) {
		if (! this.type.equals(type))
			throw new IllegalArgumentException();
	}
	
	public boolean isValid() {
		return true;
	}
}
