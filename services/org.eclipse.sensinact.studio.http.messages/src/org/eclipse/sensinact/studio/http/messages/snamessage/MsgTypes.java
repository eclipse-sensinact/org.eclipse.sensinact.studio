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
package org.eclipse.sensinact.studio.http.messages.snamessage;

import org.eclipse.sensinact.studio.http.messages.snamessage.actresponse.MsgActResponse;
import org.eclipse.sensinact.studio.http.messages.snamessage.attributevalueupdated.MsgAttributeValueUpdated;
import org.eclipse.sensinact.studio.http.messages.snamessage.completelist.MsgCompleteList;
import org.eclipse.sensinact.studio.http.messages.snamessage.describeresource.MsgDescribeRessource;
import org.eclipse.sensinact.studio.http.messages.snamessage.getresponse.MsgGetResponse;
import org.eclipse.sensinact.studio.http.messages.snamessage.lifecycle.*;
import org.eclipse.sensinact.studio.http.messages.snamessage.resourceslist.MsgResourcesList;
import org.eclipse.sensinact.studio.http.messages.snamessage.setresponse.MsgSetResponse;
import org.eclipse.sensinact.studio.http.messages.snamessage.subscriberesponse.MsgSubscribeResponse;
import org.eclipse.sensinact.studio.http.messages.snamessage.tokencreation.MsgTokenCreation;
import org.eclipse.sensinact.studio.http.messages.snamessage.unsubscriberesponse.MsgUnsubscribeResponse;

/**
 * @author Etienne Gandrille
 */
public enum MsgTypes {

	// Token management
	TOKEN_CREATION          (MsgTokenCreation.KEY,        MsgTokenCreation.class),
	/* TOKEN_RENEW */
	
	// List and describe (there will be much more than this two...)
	COMPLETE_LIST           (MsgCompleteList.KEY,         MsgCompleteList.class),
	RESOURCES_LIST          (MsgResourcesList.KEY,        MsgResourcesList.class), 
	DESCRIBE_RESOURCE       (MsgDescribeRessource.KEY,    MsgDescribeRessource.class),
	
	// Access methods
	GET_RESPONSE            (MsgGetResponse.KEY,          MsgGetResponse.class),
	SET_RESPONSE            (MsgSetResponse.KEY,          MsgSetResponse.class),
	ACT_RESPONSE            (MsgActResponse.KEY,          MsgActResponse.class),
	SUBSCRIBE_RESPONSE      (MsgSubscribeResponse.KEY,    MsgSubscribeResponse.class),
	UNSUBSCRIBE_RESPONSE    (MsgUnsubscribeResponse.KEY,  MsgUnsubscribeResponse.class),
	
	// CALLBACK 
	PROVIDER_APPEARING      (MsgProviderAppearing.KEY,    MsgProviderAppearing.class),
	PROVIDER_DISAPPEARING   (MsgProviderDisappearing.KEY, MsgProviderDisappearing.class),
	SERVICE_APPEARING       (MsgServiceAppearing.KEY,     MsgServiceAppearing.class),
	SERVICE_DISAPPEARING    (MsgServiceDisappearing.KEY,  MsgServiceDisappearing.class),
	RESOURCE_APPEARING      (MsgResourceAppearing.KEY,    MsgResourceAppearing.class),
	RESOURCE_DISAPPEARING   (MsgResourceDisappearing.KEY, MsgResourceDisappearing.class),
	
	// Other
	ATTRIBUTE_VALUE_UPDATED (MsgAttributeValueUpdated.KEY, MsgAttributeValueUpdated.class);
	
	
	private final String type;
	private final Class<?> clazz;
	
	private MsgTypes(String type, Class<?> clazz) {
		this.type = type;
		this.clazz = clazz;
	}

	public static MsgTypes get(String type) {
		
		for (MsgTypes val : values()) {
			if (val.type.equals(type))
				return val;
		}
		return null;
	}
	
	public Class<?> getTargetClass() {
		return clazz;
	}
}
