/**
 * Copyright (c) 2017 CEA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     CEA - initial API and implementation and/or initial documentation
 */
/**
 */
package org.eclipse.sensinact.studio.resource;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.sensinact.studio.resource.StateVariable#getModifier <em>Modifier</em>}</li>
 * </ul>
 *
 * @see org.eclipse.sensinact.studio.resource.ResourcePackage#getStateVariable()
 * @model
 * @generated
 */
public interface StateVariable extends Resource {
	/**
	 * Returns the value of the '<em><b>Modifier</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.sensinact.studio.resource.Action}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.sensinact.studio.resource.Action#getState <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Modifier</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Modifier</em>' reference list.
	 * @see org.eclipse.sensinact.studio.resource.ResourcePackage#getStateVariable_Modifier()
	 * @see org.eclipse.sensinact.studio.resource.Action#getState
	 * @model opposite="state"
	 * @generated
	 */
	EList<Action> getModifier();

} // StateVariable
