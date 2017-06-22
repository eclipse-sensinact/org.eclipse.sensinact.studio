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
 * A representation of the model object '<em><b>Access Method</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.sensinact.studio.resource.AccessMethod#getParameter <em>Parameter</em>}</li>
 *   <li>{@link org.eclipse.sensinact.studio.resource.AccessMethod#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.sensinact.studio.resource.ResourcePackage#getAccessMethod()
 * @model
 * @generated
 */
public interface AccessMethod extends EObject {
	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.sensinact.studio.resource.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter</em>' containment reference list.
	 * @see org.eclipse.sensinact.studio.resource.ResourcePackage#getAccessMethod_Parameter()
	 * @model containment="true"
	 * @generated
	 */
	EList<Parameter> getParameter();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.sensinact.studio.resource.AccessMethodType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.eclipse.sensinact.studio.resource.AccessMethodType
	 * @see #setType(AccessMethodType)
	 * @see org.eclipse.sensinact.studio.resource.ResourcePackage#getAccessMethod_Type()
	 * @model
	 * @generated
	 */
	AccessMethodType getType();

	/**
	 * Sets the value of the '{@link org.eclipse.sensinact.studio.resource.AccessMethod#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.eclipse.sensinact.studio.resource.AccessMethodType
	 * @see #getType()
	 * @generated
	 */
	void setType(AccessMethodType value);

} // AccessMethod
