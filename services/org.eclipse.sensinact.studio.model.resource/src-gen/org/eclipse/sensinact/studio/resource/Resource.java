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
 * A representation of the model object '<em><b>Resource</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.sensinact.studio.resource.Resource#getFriendlyName <em>Friendly Name</em>}</li>
 *   <li>{@link org.eclipse.sensinact.studio.resource.Resource#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link org.eclipse.sensinact.studio.resource.Resource#getAccessMethod <em>Access Method</em>}</li>
 * </ul>
 *
 * @see org.eclipse.sensinact.studio.resource.ResourcePackage#getResource()
 * @model
 * @generated
 */
public interface Resource extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Friendly Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Friendly Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Friendly Name</em>' attribute.
	 * @see #setFriendlyName(String)
	 * @see org.eclipse.sensinact.studio.resource.ResourcePackage#getResource_FriendlyName()
	 * @model
	 * @generated
	 */
	String getFriendlyName();

	/**
	 * Sets the value of the '{@link org.eclipse.sensinact.studio.resource.Resource#getFriendlyName <em>Friendly Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Friendly Name</em>' attribute.
	 * @see #getFriendlyName()
	 * @generated
	 */
	void setFriendlyName(String value);

	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.sensinact.studio.resource.Attribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute</em>' containment reference list.
	 * @see org.eclipse.sensinact.studio.resource.ResourcePackage#getResource_Attribute()
	 * @model containment="true"
	 * @generated
	 */
	EList<Attribute> getAttribute();

	/**
	 * Returns the value of the '<em><b>Access Method</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.sensinact.studio.resource.AccessMethod}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Access Method</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Access Method</em>' containment reference list.
	 * @see org.eclipse.sensinact.studio.resource.ResourcePackage#getResource_AccessMethod()
	 * @model containment="true"
	 * @generated
	 */
	EList<AccessMethod> getAccessMethod();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel body='EList<AccessMethod> accessMethodByType = new EObjectContainmentEList<AccessMethod>(AccessMethod.class, this, ResourcePackage.RESOURCE__ACCESS_METHOD);\n\t\tfor (AccessMethod accessMethod : getAccessMethod()) {\n\t\t\tif (accessMethod.getType().equals(type))\n\t\t\t\taccessMethodByType.add(accessMethod);\n\t\t}\n\t\treturn accessMethodByType;'"
	 * @generated
	 */
	EList<AccessMethod> getAccessMethod(AccessMethodType type);

} // Resource
