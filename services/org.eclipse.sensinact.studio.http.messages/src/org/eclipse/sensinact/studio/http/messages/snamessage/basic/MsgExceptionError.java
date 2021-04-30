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
package org.eclipse.sensinact.studio.http.messages.snamessage.basic;

import org.eclipse.sensinact.studio.http.messages.snamessage.MsgCategory;

/**
 * @author Etienne Gandrille
 */
public class MsgExceptionError extends MsgError {

	private final String jsonObject;
	private final Exception exception;
	
	public MsgExceptionError(String jsonObject, Exception exception) {
		this.jsonObject = jsonObject;
		this.exception = exception;
	}

	@Override
	public MsgCategory getCategory() {
		return MsgCategory.OTHER;
	}
	
	public String getJsonObject() {
		return jsonObject;
	}

	public Exception getException() {
		return exception;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((exception == null) ? 0 : exception.hashCode());
		result = prime * result + ((jsonObject == null) ? 0 : jsonObject.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MsgExceptionError other = (MsgExceptionError) obj;
		if (exception == null) {
			if (other.exception != null)
				return false;
		} else if (!exception.equals(other.exception))
			return false;
		if (jsonObject == null) {
			if (other.jsonObject != null)
				return false;
		} else if (!jsonObject.equals(other.jsonObject))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MsgExceptionError [jsonObject=" + jsonObject + ", exception=" + exception + "]";
	}
}
