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
package org.eclipse.sensinact.studio.http.client.snamessage;

import org.apache.log4j.Logger;
import org.eclipse.sensinact.studio.http.client.snamessage.gateway.LifecycleProviderAppearing;
import org.eclipse.sensinact.studio.http.client.snamessage.gateway.LifecycleProviderDisappearing;
import org.eclipse.sensinact.studio.http.client.snamessage.gateway.LifecycleResourceAppearing;
import org.eclipse.sensinact.studio.http.client.snamessage.gateway.LifecycleResourceDisappearing;
import org.eclipse.sensinact.studio.http.client.snamessage.gateway.LifecycleServiceAppearing;
import org.eclipse.sensinact.studio.http.client.snamessage.gateway.LifecycleServiceDisappearing;
import org.eclipse.sensinact.studio.http.client.snamessage.gateway.ResponseAct;
import org.eclipse.sensinact.studio.http.client.snamessage.gateway.ResponseCustom;
import org.eclipse.sensinact.studio.http.client.snamessage.gateway.ResponseDescribe;
import org.eclipse.sensinact.studio.http.client.snamessage.gateway.ResponseGet;
import org.eclipse.sensinact.studio.http.client.snamessage.gateway.ResponseSet;
import org.eclipse.sensinact.studio.http.client.snamessage.gateway.ResponseSubscribe;
import org.eclipse.sensinact.studio.http.client.snamessage.gateway.ResponseUnsubscribe;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Etienne Gandrille
 */
public class SnaMessageFactory {

	private static final Logger logger = Logger.getLogger(SnaMessageFactory.class);

	private SnaMessageFactory() {
		throw new RuntimeException("do no instantiate");
	}

	public static SnaMessage build(String gateway, JSONObject jsonObject) {

		try {
			String type = jsonObject.optString("type", null);

			if (type == null) {
				SnaMessage message;
				try {
					message = new ResponseCustom(jsonObject.toString(),new JSONObject("{type:'custom',uri:'custom://'}"));
					return message;
				} catch (JSONException e1) {
					throw new RuntimeException();
				}
			}

			if (type.equals(UpdateAttribute.KEY)) {
				// check nested message
				try {
					JSONObject valueObject = new JSONObject(jsonObject.getJSONObject("notification").getString("value"));
					return build(gateway, valueObject);
				} catch (Exception e) {
					// do nothing
				}
				
				// no nested message
				return new UpdateAttribute(gateway, jsonObject);
			}

			// ACT / GET / SET / DESCRIBE / SUBSCRIBE / UNSUBSCRIBE
			else if (type.equals(ResponseAct.KEY))
				return new ResponseAct(jsonObject);
			else if (type.equals(ResponseGet.KEY))
				return ResponseGet.build(jsonObject);
			else if (type.equals(ResponseSet.KEY))
				return ResponseSet.build(jsonObject);
			else if (type.equals(ResponseDescribe.KEY))
				return ResponseDescribe.build(jsonObject);
			else if (type.equals(ResponseSubscribe.KEY))
				return new ResponseSubscribe(jsonObject);
			else if (type.equals(ResponseUnsubscribe.KEY))
				return new ResponseUnsubscribe(jsonObject);

			// lifecycle
			else if (type.equals(LifecycleProviderAppearing.KEY))
				return new LifecycleProviderAppearing(jsonObject);
			else if (type.equals(LifecycleProviderDisappearing.KEY))
				return new LifecycleProviderDisappearing(jsonObject);
			else if (type.equals(LifecycleServiceAppearing.KEY))
				return new LifecycleServiceAppearing(jsonObject);
			else if (type.equals(LifecycleServiceDisappearing.KEY))
				return new LifecycleServiceDisappearing(jsonObject);
			else if (type.equals(LifecycleResourceAppearing.KEY))
				return new LifecycleResourceAppearing(jsonObject);
			else if (type.equals(LifecycleResourceDisappearing.KEY))
				return new LifecycleResourceDisappearing(jsonObject);

			// REST
			else if (type.equals(RestProvidersList.KEY))
				return new RestProvidersList(jsonObject);
			else if (type.equals(RestServicesList.KEY))
				return new RestServicesList(jsonObject);
			else if (type.equals(RestResourcesList.KEY))
				return new RestResourcesList(jsonObject);

			else {
				String msg = "Unknown type: " + type + " in json " + jsonObject.toString();
				logger.error(msg);
				throw new RuntimeException(msg);
			}
		} catch (JSONException e) {
			logger.error(e);
		}

		// Unknown message
		String msg = "Unknown message: " + jsonObject.toString();
		logger.error(msg);
		throw new RuntimeException(msg);
	}

}
