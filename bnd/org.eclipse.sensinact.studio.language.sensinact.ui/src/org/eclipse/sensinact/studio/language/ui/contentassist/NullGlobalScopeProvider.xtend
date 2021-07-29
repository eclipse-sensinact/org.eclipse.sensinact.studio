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
package org.eclipse.sensinact.studio.language.ui.contentassist

import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.IScopeProvider
import org.eclipse.emf.ecore.EObject

/**
 * This scope erase ALL available cross references.
 */
class NullGlobalScopeProvider implements IScopeProvider {
	
	override getScope(EObject context, EReference reference) {
		return IScope.NULLSCOPE;
	}
}