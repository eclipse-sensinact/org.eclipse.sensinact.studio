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
package org.eclipse.sensinact.studio.resource.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.sensinact.studio.resource.AccessMethod;
import org.eclipse.sensinact.studio.resource.AccessMethodType;
import org.eclipse.sensinact.studio.resource.Attribute;
import org.eclipse.sensinact.studio.resource.Resource;
import org.eclipse.sensinact.studio.resource.ResourcePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.sensinact.studio.resource.impl.ResourceImpl#getFriendlyName <em>Friendly Name</em>}</li>
 *   <li>{@link org.eclipse.sensinact.studio.resource.impl.ResourceImpl#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link org.eclipse.sensinact.studio.resource.impl.ResourceImpl#getAccessMethod <em>Access Method</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ResourceImpl extends NamedElementImpl implements Resource {
	/**
	 * The default value of the '{@link #getFriendlyName() <em>Friendly Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFriendlyName()
	 * @generated
	 * @ordered
	 */
	protected static final String FRIENDLY_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFriendlyName() <em>Friendly Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFriendlyName()
	 * @generated
	 * @ordered
	 */
	protected String friendlyName = FRIENDLY_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAttribute() <em>Attribute</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttribute()
	 * @generated
	 * @ordered
	 */
	protected EList<Attribute> attribute;

	/**
	 * The cached value of the '{@link #getAccessMethod() <em>Access Method</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAccessMethod()
	 * @generated
	 * @ordered
	 */
	protected EList<AccessMethod> accessMethod;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResourcePackage.Literals.RESOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFriendlyName() {
		return friendlyName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFriendlyName(String newFriendlyName) {
		String oldFriendlyName = friendlyName;
		friendlyName = newFriendlyName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResourcePackage.RESOURCE__FRIENDLY_NAME, oldFriendlyName, friendlyName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Attribute> getAttribute() {
		if (attribute == null) {
			attribute = new EObjectContainmentEList<Attribute>(Attribute.class, this, ResourcePackage.RESOURCE__ATTRIBUTE);
		}
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AccessMethod> getAccessMethod() {
		if (accessMethod == null) {
			accessMethod = new EObjectContainmentEList<AccessMethod>(AccessMethod.class, this, ResourcePackage.RESOURCE__ACCESS_METHOD);
		}
		return accessMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AccessMethod> getAccessMethod(final AccessMethodType type) {
		EList<AccessMethod> accessMethodByType = new EObjectContainmentEList<AccessMethod>(AccessMethod.class, this, ResourcePackage.RESOURCE__ACCESS_METHOD);
				for (AccessMethod accessMethod : getAccessMethod()) {
					if (accessMethod.getType().equals(type))
						accessMethodByType.add(accessMethod);
				}
				return accessMethodByType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResourcePackage.RESOURCE__ATTRIBUTE:
				return ((InternalEList<?>)getAttribute()).basicRemove(otherEnd, msgs);
			case ResourcePackage.RESOURCE__ACCESS_METHOD:
				return ((InternalEList<?>)getAccessMethod()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ResourcePackage.RESOURCE__FRIENDLY_NAME:
				return getFriendlyName();
			case ResourcePackage.RESOURCE__ATTRIBUTE:
				return getAttribute();
			case ResourcePackage.RESOURCE__ACCESS_METHOD:
				return getAccessMethod();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ResourcePackage.RESOURCE__FRIENDLY_NAME:
				setFriendlyName((String)newValue);
				return;
			case ResourcePackage.RESOURCE__ATTRIBUTE:
				getAttribute().clear();
				getAttribute().addAll((Collection<? extends Attribute>)newValue);
				return;
			case ResourcePackage.RESOURCE__ACCESS_METHOD:
				getAccessMethod().clear();
				getAccessMethod().addAll((Collection<? extends AccessMethod>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ResourcePackage.RESOURCE__FRIENDLY_NAME:
				setFriendlyName(FRIENDLY_NAME_EDEFAULT);
				return;
			case ResourcePackage.RESOURCE__ATTRIBUTE:
				getAttribute().clear();
				return;
			case ResourcePackage.RESOURCE__ACCESS_METHOD:
				getAccessMethod().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ResourcePackage.RESOURCE__FRIENDLY_NAME:
				return FRIENDLY_NAME_EDEFAULT == null ? friendlyName != null : !FRIENDLY_NAME_EDEFAULT.equals(friendlyName);
			case ResourcePackage.RESOURCE__ATTRIBUTE:
				return attribute != null && !attribute.isEmpty();
			case ResourcePackage.RESOURCE__ACCESS_METHOD:
				return accessMethod != null && !accessMethod.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case ResourcePackage.RESOURCE___GET_ACCESS_METHOD__ACCESSMETHODTYPE:
				return getAccessMethod((AccessMethodType)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (friendlyName: ");
		result.append(friendlyName);
		result.append(')');
		return result.toString();
	}

} //ResourceImpl
