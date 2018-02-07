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
package org.eclipse.sensinact.studio.view.projectexplorer.handler.sna2json;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Etienne Gandrille
 */
public class VariableGenerator {
	
	private final static List<VariableGenerator> variables = new ArrayList<>();

	private final String prefix;
	private int cpt = 0;
	
	private VariableGenerator(String prefix) {
		this.prefix = prefix;
	}
	
	public static VariableGenerator get(String prefix) {
		if (prefix == null || prefix.isEmpty())
			throw new IllegalArgumentException("Prefix should not be null or empty");
		
		for (VariableGenerator variable : variables)
			if (variable.getPrefix().equals(prefix))
				return variable;
		VariableGenerator var = new VariableGenerator(prefix);
		variables.add(var);
		return var;
	}

	public String getPrefix() {
		return prefix;
	} 
	
	public String newVariable() {
		cpt++;
		return curVariable();
	}
	
	public String curVariable() {
		return prefix + cpt;
	}
	
}
