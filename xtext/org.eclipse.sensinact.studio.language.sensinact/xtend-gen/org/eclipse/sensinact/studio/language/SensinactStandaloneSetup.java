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
package org.eclipse.sensinact.studio.language;

import org.eclipse.sensinact.studio.language.SensinactStandaloneSetupGenerated;

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
@SuppressWarnings("all")
public class SensinactStandaloneSetup extends SensinactStandaloneSetupGenerated {
  public static void doSetup() {
    SensinactStandaloneSetup _sensinactStandaloneSetup = new SensinactStandaloneSetup();
    _sensinactStandaloneSetup.createInjectorAndDoEMFRegistration();
  }
}
