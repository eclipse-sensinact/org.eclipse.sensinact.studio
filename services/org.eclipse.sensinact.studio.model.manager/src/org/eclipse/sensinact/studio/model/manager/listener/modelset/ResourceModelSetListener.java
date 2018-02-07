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
package org.eclipse.sensinact.studio.model.manager.listener.modelset;

import org.eclipse.emf.transaction.ResourceSetChangeEvent;

/**
 * @author Etienne Gandrille
 */
public interface ResourceModelSetListener {
	public void modelSetUpdated(ResourceSetChangeEvent event);
}
