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
package org.eclipse.sensinact.studio.view.piax;

/**
 * @author Etienne Gandrille
 */
public class RangeObject {

	private static final String allowedOperators[] = { "<", ">" };

	private final String key;
	private final String operator;
	private final long value;

	public static RangeObject build(String text) {

		for (String op : allowedOperators) {
			int idx = text.indexOf(op);

			if (idx != -1) {
				String tmpKey = text.substring(0, idx).trim();
				String tmpValue = text.substring(idx + op.length()).trim();
				if (!tmpKey.isEmpty() && !tmpValue.isEmpty()) {
					try {
						return new RangeObject(tmpKey, op, Long.parseLong(tmpValue));
					} catch (NumberFormatException e) {
						// do nothing... just iterate...
					}
				}
			}
		}
		throw new IllegalArgumentException(text + " is not a valid range");
	}
	
	private RangeObject(String key, String operator, long value) {
		this.key = key;
		this.operator = operator;
		this.value = value;
	}
	
	public String getKey() {
		return key;
	}
	
	public String getOperator() {
		return operator;
	}
	
	public long getValue() {
		return value;
	}
}
