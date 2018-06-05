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
package org.eclipse.sensinact.studio.http.services.client.subscribe.standard;

import org.eclipse.sensinact.studio.http.messages.snamessage.MsgSensinact;
import org.eclipse.sensinact.studio.model.resource.utils.ResourceDescriptor;

/**
 * @author Etienne Gandrille
 */
public interface OldSubscriptionListener {
	public void onEvent(final MsgSensinact message, final ResourceDescriptor resource); 
}
