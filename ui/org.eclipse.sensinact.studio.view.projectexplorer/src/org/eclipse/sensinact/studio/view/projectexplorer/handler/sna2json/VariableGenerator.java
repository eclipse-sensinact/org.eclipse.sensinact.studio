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

	private final String appName;
	private final String prefix;
	private int cpt = 0;
	
	private VariableGenerator(String appName, String prefix) {
		this.appName = appName;
		this.prefix = prefix;
	}
	
	public static VariableGenerator get(String appName, String prefix) {

		if (appName == null || appName.isEmpty())
			throw new IllegalArgumentException("AppName should not be null or empty");
		
		if (prefix == null || prefix.isEmpty())
			throw new IllegalArgumentException("Prefix should not be null or empty");
		
	
		for (VariableGenerator variable : variables)
			if (variable.getPrefix().equals(prefix) && variable.getAppName().equals(appName))
				return variable;
		
		VariableGenerator var = new VariableGenerator(appName, prefix);
		variables.add(var);
		return var;
	}

	public String getAppName() {
		return appName;
	}
	
	public String getPrefix() {
		return prefix;
	} 
	
	public Variable newVariable() {
		cpt++;
		return new Variable(appName, prefix, cpt);
	}
	
	public Variable curVariable() {
		return new Variable(appName, prefix, cpt);
	}
}
