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

import junit.textui.TestRunner;

import org.eclipse.sensinact.studio.resource.Gateway;
import org.eclipse.sensinact.studio.resource.ResourceFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Gateway</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class GatewayTest extends NamedElementTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(GatewayTest.class);
	}

	/**
	 * Constructs a new Gateway test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GatewayTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Gateway test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Gateway getFixture() {
		return (Gateway)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ResourceFactory.eINSTANCE.createGateway());
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

} //GatewayTest
