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

import org.eclipse.sensinact.studio.resource.ResourceFactory;
import org.eclipse.sensinact.studio.resource.SensorData;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Sensor Data</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SensorDataTest extends ResourceTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SensorDataTest.class);
	}

	/**
	 * Constructs a new Sensor Data test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SensorDataTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Sensor Data test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected SensorData getFixture() {
		return (SensorData)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(ResourceFactory.eINSTANCE.createSensorData());
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

} //SensorDataTest
