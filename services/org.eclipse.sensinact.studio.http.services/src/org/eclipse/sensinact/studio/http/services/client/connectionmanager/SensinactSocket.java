/**
 * Copyright (c) 2019 CEA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     CEA - initial API and implementation and/or initial documentation
 */
package org.eclipse.sensinact.studio.http.services.client.connectionmanager;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.eclipse.jetty.websocket.common.OpCode;
import org.eclipse.jetty.websocket.api.RemoteEndpoint;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketError;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketFrame;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import org.eclipse.jetty.websocket.api.extensions.Frame;

/**
 * @author Jander Nascimento, Etienne Gandrille
 */
@WebSocket(maxIdleTime = 0, maxTextMessageSize = 64*1024)
public class SensinactSocket {

	private static final Logger logger = Logger.getLogger(SensinactSocket.class);

	private Session session;
	private String gatewayName;
	private static NotifDispatcher dispatcher = NotifDispatcher.getInstance();
	
	public SensinactSocket(String gatewayName) {
		this.gatewayName = gatewayName;
	}

	public boolean isConnected() {
		return session != null;
	}
	
	@OnWebSocketConnect
	public void onConnect(Session session) throws IOException {
		logger.info("WebSocket connected to the gateway " + gatewayName);
		this.session = session;
		String msg = "{\"uri\":\"sensinact/SUBSCRIBE\",\"parameters\":[{\"name\":\"sender\",\"type\":\"string\",\"value\":\"(/[^/]*)+\"},{\"name\":\"pattern\",\"type\":\"boolean\",\"value\":true},{\"name\":\"complement\",\"type\":\"boolean\",\"value\":false},{\"name\":\"types\",\"type\":\"array\",\"value\":[\"UPDATE\",\"LIFECYCLE\",\"REMOTE\",\"RESPONSE\",\"ERROR\"]}]}";
		session.getRemote().sendString(msg);
		dispatcher.notifyGatewayConnected(gatewayName);
	}

	public void send(String str) throws IOException {		
		if ( ! isConnected())
			throw new IOException("Socket is NOT connected to gateway " + gatewayName);
		
		RemoteEndpoint remote = session.getRemote();
		if (remote == null)
			throw new IOException("remote endpoint is null");
		
		remote.sendString(str);
	}
	
	@OnWebSocketClose
	public void onClose(int statusCode, String reason) {
		session = null;
		logger.info("WebSocket connection closed from the gateway " + gatewayName);
		dispatcher.notifyGatewayDisconnected(gatewayName);
	}

    private boolean partial;
	private byte[] payload; 
	
	@OnWebSocketFrame
	public void onFrame(Frame frame) {
		if(OpCode.CONTINUATION != frame.getOpCode() && frame.isFin()) {
			partial = false;
			return;
		}
		partial = true;
		byte[] bytes = new byte[frame.getPayloadLength()];
		frame.getPayload().get(bytes);
		int length = payload==null?0:payload.length;
		byte[] tmpArray = new byte[length+bytes.length] ;
		if(bytes.length > 0)
			System.arraycopy(bytes,0, tmpArray, length, bytes.length);
		if(length > 0)
			System.arraycopy(payload, 0, tmpArray, 0, length);
		payload = tmpArray;	
		tmpArray = null;
		if(frame.isFin()) {
			partial = false;
			onMessage(new String(payload));
			payload = null;
			partial = true;
		}
	}	

	@OnWebSocketMessage
	public void onMessage(String msg) {
		if(partial)
			return;
		dispatcher.notifyMessage(gatewayName, msg);
	}	
	
	@OnWebSocketError
	public void onError(Throwable t) {
		t.printStackTrace();
		logger.error("Error: " + t.getMessage());
	}
}
