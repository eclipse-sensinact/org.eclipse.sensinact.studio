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
package org.eclipse.sensinact.studio.http.messages.snamessage;

import java.util.List;

/**
 * @author Etienne Gandrille
 */
public abstract class MsgSensinact {

	public static final String KEY = "KEY";
	public static final int PRIME = 31;
	
	protected final String type;
	protected String uri;
	
	private List<ObjectFilter> filters;

	public MsgSensinact(String type) {
		this.type = type;
	}
	
	public String getUri() {
		return uri;
	}
	
	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getType() {
		return type;
	}
	
	public final void setType(String type) {
		if (! this.type.equals(type))
			throw new IllegalArgumentException();
	}

	public List<ObjectFilter> getFilters() {
		return filters;
	}
	
	public ObjectFilter getFilter(String filterType) {
		for (ObjectFilter filter : filters)
			if (filter.getType().equals(filterType))
				return filter;
		return null;
	}

	public void setFilters(List<ObjectFilter> filters) {
		this.filters = filters;
	}

	public boolean isValid() {
		return true;
	}
	
	public abstract MsgCategory getCategory();
}
