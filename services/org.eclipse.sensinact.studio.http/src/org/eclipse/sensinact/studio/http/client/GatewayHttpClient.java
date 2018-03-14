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
package org.eclipse.sensinact.studio.http.client;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Map;

import org.eclipse.sensinact.studio.http.client.snamessage.SnaMessage;
import org.eclipse.sensinact.studio.http.client.snamessage.SnaMessageFactory;
import org.eclipse.sensinact.studio.model.resource.utils.JsonUtil;
import org.eclipse.sensinact.studio.model.resource.utils.Segments;
import org.eclipse.sensinact.studio.preferences.ConfigurationManager;
import org.eclipse.sensinact.studio.preferences.GatewayHttpConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.Context;
import org.restlet.Response;
import org.restlet.data.ChallengeScheme;
import org.restlet.data.MediaType;
import org.restlet.data.Method;
import org.restlet.data.Parameter;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.ClientResource;

/**
 * Central point for SYNCHRONUS communication with the sensinact gateway.
 * @author Etienne Gandrille
 */
public class GatewayHttpClient {

	private GatewayHttpClient() {
		throw new IllegalArgumentException("Should not be instantiated!");
	}

	public static SnaMessage sendGetRequest(Segments segments) throws IOException {
		return sendGetRequest(segments, null);
	}

	public static SnaMessage sendGetRequest(Segments segments, Map<String, String> params) throws IOException {
		GatewayHttpConfig gwInfo = ConfigurationManager.getGateway(segments.getGateway());
		ClientResource clientResource = new ClientResource(getContext(gwInfo), gwInfo.getURL().toString());
		if (gwInfo.hasAuthentication())
			setAuthentication(clientResource, gwInfo);
		clientResource.setRetryOnError(false);
		segments.addToClientResource(clientResource);
		
		if (params != null) {
			for (String param : params.keySet()) {
				clientResource.addQueryParameter(new Parameter(param, params.get(param)));			
			}
		}
		
		String json = null;
		try {
			json = clientResource.get().getText();
			return SnaMessageFactory.build(segments.getGateway(), new JSONObject(json));
		} catch (Exception e) {
			try {
				return SnaMessage.build(new JSONObject(json),e, segments);
			} catch (JSONException e1) {
				throw new IllegalArgumentException(json);
			}
		} 
	}

	public static SnaMessage sendPostRequest(Segments segments, Collection<Parameter> queryParameter,RequestParameter... parameters) throws IOException {
		JSONArray jsonParameters = new JSONArray();
		for (RequestParameter parameter : parameters) {
			try {
				jsonParameters.put(JsonUtil.createNameTypeValue(parameter.name, parameter.type, parameter.value));
			} catch (JSONException e) {
				throw new IOException(e);
			}
		}
		return sendPostRequest(segments, jsonParameters,queryParameter);
	}

	
	public static SnaMessage sendPostRequest(Segments segments, JSONArray parameters,Collection<Parameter> queryParameter) throws IOException {
		if (parameters==null || parameters.length() == 0)
			return sendPostRequest(segments, "{}",queryParameter);
		else
			return sendPostRequest(segments, parameters.toString(),queryParameter);
	}
	
	public static SnaMessage sendPostRequest(Segments segments, JSONArray parameters) throws IOException {
		if (parameters.length() == 0)
			return sendPostRequest(segments, "{}",null);
		else
			return sendPostRequest(segments, parameters.toString(),null);
	}

	public static SnaMessage sendPostRequest(Segments segments, JSONObject parameters) throws IOException {
		return sendPostRequest(segments, parameters.toString(),null);
	}

	/* ======== */
	/* Internal */
	/* ======== */

	private static SnaMessage sendPostRequest(Segments segments, String jsonRequest,Collection<Parameter> queryParameter) throws IOException {
		
		GatewayHttpConfig gwInfo = ConfigurationManager.getGateway(segments.getGateway());
		ClientResource clientResource = new ClientResource(getContext(gwInfo), Method.POST, gwInfo.getURL().toString()) {
			@Override
			public Representation handleInbound(Response response) {
				return (response == null) ? null : response.getEntity();
			}
		};
		setAuthentication(clientResource, gwInfo);
		clientResource.setRetryOnError(false);
		clientResource.getRequestAttributes();
		segments.addToClientResource(clientResource);
		StringRepresentation stringRep = new StringRepresentation(jsonRequest,MediaType.APPLICATION_JSON);
		if(queryParameter!=null){
			clientResource.addQueryParameters(queryParameter);
		}
		
		Representation postResponse = clientResource.post(stringRep);
		
		StringWriter sw = new StringWriter();
		postResponse.write(sw);
		String jsonResponse = sw.toString();
		
		try {
			return SnaMessageFactory.build(segments.getGateway(), new JSONObject(jsonResponse));
		} catch (Exception e) {
			throw new IllegalArgumentException(jsonResponse);
		}
	}

	private static void setAuthentication(ClientResource clientResource, GatewayHttpConfig gwInfo) {
		clientResource.setChallengeResponse(ChallengeScheme.HTTP_BASIC, gwInfo.getUsername(), gwInfo.getPassword());
	}
	
	private static Context getContext(GatewayHttpConfig gwInfo) throws IOException {
		Context context = new Context();
		context.getParameters().add("socketTimeout", Integer.toString(gwInfo.getTimeout()));
		context.getParameters().add("idleTimeout", Integer.toString(gwInfo.getTimeout()));
		return context;
	}

	public static class RequestParameter {
		public final String name;
		public final String type;
		public final String value;

		public RequestParameter(String name, String type, String value) {
			this.name = name;
			this.type = type;
			this.value = value;
		}
	}
}
