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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Studio</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.sensinact.studio.resource.Studio#getGateways <em>Gateways</em>}</li>
 * </ul>
 *
 * @see org.eclipse.sensinact.studio.resource.ResourcePackage#getStudio()
 * @model
 * @generated
 */
public interface Studio extends EObject {
	/**
	 * Returns the value of the '<em><b>Gateways</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.sensinact.studio.resource.Gateway}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gateways</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gateways</em>' containment reference list.
	 * @see org.eclipse.sensinact.studio.resource.ResourcePackage#getStudio_Gateways()
	 * @model containment="true"
	 * @generated
	 */
	EList<Gateway> getGateways();

} // Studio
