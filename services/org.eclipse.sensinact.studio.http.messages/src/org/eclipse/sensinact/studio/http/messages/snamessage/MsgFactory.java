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

import java.io.IOException;

import org.apache.log4j.Logger;
import org.eclipse.sensinact.studio.http.messages.snamessage.basic.MsgExceptionError;
import org.eclipse.sensinact.studio.http.messages.snamessage.basic.MsgHttpError;
import org.eclipse.sensinact.studio.http.messages.snamessage.basic.MsgOk;
import org.eclipse.sensinact.studio.model.resource.utils.Segments;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.DeserializationFeature;
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
		
		int httpCode = getStatusCode(jsonObject);
		String msgType = jsonObject.optString("type", null);
		
		// HTTP error code
		if (httpCode != -1 && (httpCode < 200 || httpCode >= 300)) {
			logger.info("Building message with type MsgHttpError");
			return new MsgHttpError(httpCode, jsonObject);
		}
		
		// assert type exists	
		if (msgType == null) {
			if (httpCode != -1)
				return new MsgOk(httpCode, jsonObject);
			else
				throw new RuntimeException("type not found in json message");
		}
		
		logger.info("Building message with type " + msgType);
			
		// assert builder exists
		MsgTypes registeredType = MsgTypes.get(msgType);
		if (registeredType == null) {
			if (httpCode != -1)
				return new MsgOk(httpCode, jsonObject);
			else
				throw new RuntimeException("unknown type " + msgType + " in json message");	
		}
			
		// build!
		ObjectMapper mapper = getMapper();
		try {
			Object object = mapper.readValue(jsonObject.toString(), registeredType.getTargetClass());
			return (MsgSensinact) object;
		} catch (IOException e) {
			String msg = "Error while unmarshalling json " + jsonObject.toString();
			
			logger.error(msg);
			logger.error(e.getMessage(), e);
			
			if (httpCode != -1)
				return new MsgOk(httpCode, jsonObject);
			else
				throw new RuntimeException("Error while unmarshalling json " + jsonObject.toString(), e);
		}
	}
	
	private static final int getStatusCode(JSONObject jsonObject) {
		String code = jsonObject.optString("statusCode", null);
		if (code == null)
			return -1;
		else
			return Integer.parseInt(code);	
	}
	
	private static ObjectMapper getMapper() {
		ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		SimpleModule module = new SimpleModule();
		module.addDeserializer(ObjectNameTypeValue.class, new NameTypeValueDeserializer());
		mapper.registerModule(module);
		return mapper;
	}
	
	public static MsgSensinact build(String json, Exception e, Segments segments) {
		return new MsgExceptionError(json, e, segments);
	}
}
