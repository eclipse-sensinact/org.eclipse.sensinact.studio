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

import java.io.IOException;

import org.apache.log4j.Logger;
import org.eclipse.sensinact.studio.http.client.snamessage.error.MsgExceptionError;
import org.eclipse.sensinact.studio.http.client.snamessage.error.MsgHttpError;
import org.eclipse.sensinact.studio.model.resource.utils.Segments;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * @author Etienne Gandrille
 */
public class MsgFactory {

	private static final Logger logger = Logger.getLogger(MsgFactory.class);

	
	private MsgFactory() {
		throw new RuntimeException("do no instantiate");
	}

	public static MsgSensinact build(JSONObject jsonObject) {

		// assert HTTP code exists
		String code = jsonObject.optString("statusCode", null);
		if (code != null) {
			int codeVal = Integer.parseInt(code); 
			if (codeVal < 200 || codeVal >= 300) {
				logger.info("Building message with type MsgHttpError");
				return new MsgHttpError(codeVal, jsonObject);
			}
		}
		
		// assert type exists
		String type = jsonObject.optString("type", null);
		if (type == null)
			throw new RuntimeException("type not found in json message");
		
		logger.info("Building message with type " + type);
			
		// assert builder exists
		MsgTypes registeredType = MsgTypes.get(type);
		if (registeredType == null)
			throw new RuntimeException("unknown type " + type + " in json message");
		
		// build!
		ObjectMapper mapper = getMapper();
		try {
			Object object = mapper.readValue(jsonObject.toString(), registeredType.getTargetClass());
			return (MsgSensinact) object;
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException("Error while unmarshalling json " + jsonObject.toString(), e);
		}
	}

	private static ObjectMapper getMapper() {
		ObjectMapper mapper = new ObjectMapper();
		SimpleModule module = new SimpleModule();
		module.addDeserializer(ObjectNameTypeValue.class, new NameTypeValueDeserializer());
		mapper.registerModule(module);
		return mapper;
	}
	
	public static MsgSensinact build(String json, Exception e, Segments segments) {
		return new MsgExceptionError(json, e, segments);
	}
}
