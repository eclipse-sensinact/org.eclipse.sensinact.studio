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
package org.eclipse.sensinact.studio.model.manager.http;

import java.util.List;

import org.eclipse.sensinact.studio.http.messages.snamessage.MsgSensinact;
import org.eclipse.sensinact.studio.http.services.client.subscribe.standard.OldSubscriptionManager;
import org.restlet.Response;
import org.restlet.data.Status;
import org.restlet.resource.Post;

/**
 * @author Etienne Gandrille
 */
public class GatewayHttpServerRouteOld extends GatewayHttpServerRoute {

	@Post("json")
	public Response getValue(String params) {
		return super.getValue(params);
	}

	@Override
	protected Status notify(String id, List<MsgSensinact> messages) {
		return OldSubscriptionManager.getInstance().callbackRecieved(id, messages);
	}
}
