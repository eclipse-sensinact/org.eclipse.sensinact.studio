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

import org.eclipse.sensinact.studio.resource.Resource;
import org.eclipse.sensinact.studio.resource.ResourceFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Resource</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.sensinact.studio.resource.Resource#getAccessMethod(org.eclipse.sensinact.studio.resource.AccessMethodType) <em>Get Access Method</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class ResourceTest extends NamedElementTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ResourceTest.class);
	}

	/**
	 * Constructs a new Resource test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Resource test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Resource getFixture() {
		return (Resource)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ResourceFactory.eINSTANCE.createResource());
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

	/**
	 * Tests the '{@link org.eclipse.sensinact.studio.resource.Resource#getAccessMethod(org.eclipse.sensinact.studio.resource.AccessMethodType) <em>Get Access Method</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.sensinact.studio.resource.Resource#getAccessMethod(org.eclipse.sensinact.studio.resource.AccessMethodType)
	 * @generated
	 */
	public void testGetAccessMethod__AccessMethodType() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
		fail();
	}

} //ResourceTest
