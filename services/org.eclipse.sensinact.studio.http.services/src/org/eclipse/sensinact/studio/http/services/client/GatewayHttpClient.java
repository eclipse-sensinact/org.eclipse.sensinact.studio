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
package org.eclipse.sensinact.studio.http.services.client;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.sensinact.studio.http.messages.snamessage.MsgFactory;
import org.eclipse.sensinact.studio.http.messages.snamessage.MsgSensinact;
import org.eclipse.sensinact.studio.http.messages.snamessage.tokencreation.MsgTokenCreation;
import org.eclipse.sensinact.studio.model.resource.utils.JsonUtil;
import org.eclipse.sensinact.studio.model.resource.utils.Segments;
import org.eclipse.sensinact.studio.preferences.ConfigurationManager;
import org.eclipse.sensinact.studio.preferences.GatewayHttpConfig;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.Context;
import org.restlet.Response;
import org.restlet.data.MediaType;
import org.restlet.data.Method;
import org.restlet.data.Parameter;
import org.restlet.data.Status;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.ClientResource;

/**
 * Central point for SYNCHRONUS communication with the sensinact gateway.
 * @author Etienne Gandrille
 */
public class GatewayHttpClient {
		
	private static final Logger logger = Logger.getLogger(GatewayHttpClient.class);
	
	private GatewayHttpClient() {
		throw new IllegalArgumentException("Should not be instantiated!");
	}

	public static MsgSensinact sendGetRequest(Segments segments) throws IOException {
		return sendGetRequest(segments, null);
	}
		
	public static MsgSensinact sendGetRequest(Segments segments, Map<String, String> params) throws IOException {		
		GatewayHttpConfig gwInfo = ConfigurationManager.getGateway(segments.getGateway());
		
		RequestConfigurator configurator = getRequestConfiguratorToken(gwInfo);
		
		return sendGetRequest(segments, gwInfo, params, configurator);
	}
		
	private static RequestConfigurator getRequestConfiguratorToken(GatewayHttpConfig gwInfo) throws IOException {
		if (gwInfo.hasAuthentication()) {
			AccessToken token = getToken(gwInfo);
			return new RequestConfiguratorToken(token);
		} else {
			return new BasicConfigurator();
		}
	}
	
	private static synchronized AccessToken getToken(GatewayHttpConfig gwInfo) throws IOException {
		String gwName = gwInfo.getName();
		AccessToken token = TokenStore.getInstance().getToken(gwName);
		if (token != null && token.isValid())
			return token;
		
		Segments segments = new Segments.Builder().gateway(gwInfo.getName()).login().build();
		MsgSensinact reponse = sendGetRequest(segments, gwInfo, null, new RequestConfiguratorCred());
		
		if (reponse instanceof MsgTokenCreation) {
			token = new AccessToken((MsgTokenCreation) reponse);
			TokenStore.getInstance().save(gwName, token);
			return token;
		}
		
		return null;
	}
	
	public static MsgSensinact sendPostRequest(Segments segments, Collection<Parameter> queryParameter,RequestParameter... parameters) throws IOException {
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
	
	public static MsgSensinact sendPostRequest(Segments segments, JSONArray parameters,Collection<Parameter> queryParameter) throws IOException {
		GatewayHttpConfig gwInfo = ConfigurationManager.getGateway(segments.getGateway());
		RequestConfigurator configurator = getRequestConfiguratorToken(gwInfo);
		
		if (parameters==null || parameters.length() == 0)
			return sendPostRequest(segments, "{}",queryParameter, configurator);
		else
			return sendPostRequest(segments, parameters.toString(), queryParameter, configurator);
	}
	
	public static MsgSensinact sendPostRequest(Segments segments, JSONArray parameters) throws IOException {
		GatewayHttpConfig gwInfo = ConfigurationManager.getGateway(segments.getGateway());
		RequestConfigurator configurator = getRequestConfiguratorToken(gwInfo);
		
		if (parameters.length() == 0)
			return sendPostRequest(segments, "{}", null, configurator);
		else
			return sendPostRequest(segments, parameters.toString(),null, configurator);
	}

	public static MsgSensinact sendPostRequest(Segments segments, JSONObject parameters) throws IOException {
		GatewayHttpConfig gwInfo = ConfigurationManager.getGateway(segments.getGateway());
		RequestConfigurator configurator = getRequestConfiguratorToken(gwInfo);
		return sendPostRequest(segments, parameters.toString(), null, configurator);
	}

	/* ======== */
	/* Internal */
	/* ======== */

	private static MsgSensinact sendGetRequest(Segments segments, GatewayHttpConfig gwInfo, Map<String, String> params, RequestConfigurator configurator) throws IOException {
		ClientResource clientResource = new ClientResource(getContext(gwInfo.getTimeout()), gwInfo.getURL().toString());
		configurator.configure(gwInfo, clientResource);
		clientResource.setRetryOnError(false);
		segments.addToClientResource(clientResource);
		
		if (params != null) {
			for (String param : params.keySet()) {
				clientResource.addQueryParameter(new Parameter(param, params.get(param)));			
			}
		}
		
		String json = null;
		MsgSensinact retval;
		try {
			//httpURLConnection.setRequestProperty("Connection","close");

			
			
			
			
			Representation cmd = clientResource.get();
			json = cmd.getText();
			cmd.exhaust();
			cmd.release();
			retval = MsgFactory.build(new JSONObject(json));
		} catch (Exception e) {
			retval = MsgFactory.build(json, e, segments);
		} 
		
		return retval;
	}
	
	private static MsgSensinact sendPostRequest(Segments segments, String jsonRequest, Collection<Parameter> queryParameter, RequestConfigurator configurator) throws IOException {
		GatewayHttpConfig gwInfo = ConfigurationManager.getGateway(segments.getGateway());		
		ClientResource clientResource = new ClientResource(getContext(gwInfo.getTimeout()), Method.POST, gwInfo.getURL().toString()) {
			@Override
			public Representation handleInbound(Response response) {
				return (response == null) ? null : response.getEntity();				
			}
		};
		
		configurator.configure(gwInfo, clientResource);
		clientResource.setRetryOnError(false);
		clientResource.getRequestAttributes();
		segments.addToClientResource(clientResource);
		StringRepresentation stringRep = new StringRepresentation(jsonRequest,MediaType.APPLICATION_JSON);
		if(queryParameter != null){
			clientResource.addQueryParameters(queryParameter);
		}
		
		Representation postResponse = clientResource.post(stringRep);
		Status status = clientResource.getResponse().getStatus();
		
		
		int code = status.getCode();
		
		StringWriter sw = new StringWriter();
		postResponse.write(sw);
		String jsonResponse = sw.toString();

		postResponse.exhaust();
		postResponse.release();
		
		try {
			return MsgFactory.build(new JSONObject(jsonResponse));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new IllegalArgumentException(jsonResponse, e);
		}
	}
	
	private static Context getContext(int timeout) throws IOException {
		Context context = new Context();
		context.getParameters().add("socketTimeout", Integer.toString(timeout));
		context.getParameters().add("idleTimeout", Integer.toString(timeout));
		
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
