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
/**
 */
package org.eclipse.sensinact.studio.resource.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.eclipse.sensinact.studio.resource.AccessMethod;
import org.eclipse.sensinact.studio.resource.ResourceFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Access Method</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class AccessMethodTest extends TestCase {

	/**
	 * The fixture for this Access Method test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AccessMethod fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(AccessMethodTest.class);
	}

	/**
	 * Constructs a new Access Method test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AccessMethodTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Access Method test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(AccessMethod fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Access Method test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AccessMethod getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ResourceFactory.eINSTANCE.createAccessMethod());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //AccessMethodTest
