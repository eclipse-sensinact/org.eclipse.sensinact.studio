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
 * A representation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.sensinact.studio.resource.Action#getState <em>State</em>}</li>
 * </ul>
 *
 * @see org.eclipse.sensinact.studio.resource.ResourcePackage#getAction()
 * @model
 * @generated
 */
public interface Action extends Resource {
	/**
	 * Returns the value of the '<em><b>State</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.sensinact.studio.resource.StateVariable}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.sensinact.studio.resource.StateVariable#getModifier <em>Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' reference list.
	 * @see org.eclipse.sensinact.studio.resource.ResourcePackage#getAction_State()
	 * @see org.eclipse.sensinact.studio.resource.StateVariable#getModifier
	 * @model opposite="modifier"
	 * @generated
	 */
	EList<StateVariable> getState();

} // Action
