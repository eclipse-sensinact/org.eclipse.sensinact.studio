/**
 * Copyright (c) 2017 CEA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     CEA - initial API and implementation and/or initial documentation
 */
package org.eclipse.sensinact.studio.navigator.device.toolbar;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import org.eclipse.sensinact.studio.model.manager.listener.subscription.SubscriptionManager;
import org.eclipse.sensinact.studio.model.manager.modelupdater.ModelEditor;
import org.eclipse.sensinact.studio.model.manager.modelupdater.ModelUpdater;
import org.eclipse.sensinact.studio.model.resource.utils.Constants;
import org.eclipse.sensinact.studio.preferences.ConfigurationManager;
import org.eclipse.sensinact.studio.preferences.GatewayHttpConfig;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("serial")
@WebSocket(maxTextMessageSize = 64 * 1024)
public class SensinactSocket {

	private static final Logger logger = Logger.getLogger(SensinactSocket.class);
	
    private final CountDownLatch closeLatch;
    private Session session;
    private String gatewayID;
	
    public SensinactSocket(String gatewayID) {
        this.closeLatch = new CountDownLatch(1);
        this.gatewayID=gatewayID;
    }

    public boolean awaitClose(int duration, TimeUnit unit) throws InterruptedException {
        return this.closeLatch.await(duration, unit);
    }

    @OnWebSocketClose
    public void onClose(int statusCode, String reason) {
        session=null;
        System.out.println("WebSocket connection closed from the gateway "+gatewayID);
        this.closeLatch.countDown();
        try {
        	GatewayHttpConfig gwConfig = ConfigurationManager.getGateway(gatewayID);
            ModelUpdater.getInstance().unsubscribeLastEvent(gwConfig.getName());
    		SensinactWebSocketConnectionManager.getInstance().disconnect(gwConfig.getName());
    		ModelEditor.getInstance().clearGatewayContent(gwConfig.getName());	
        }catch(Exception e){
        	logger.log(Priority.DEBUG, (Object)("Websocket clients was disconnected from the server "+gatewayID));
        }
        
        
    }

    @OnWebSocketConnect
    public void onConnect(Session session) {
    	System.out.println("WebSocket connected to the gateway "+gatewayID);
        this.session = session;
    }

    @OnWebSocketMessage
    public void onMessage(String msg) {
    	logger.log(Priority.INFO, (Object)("Websocket message received from "+gatewayID));
    	String uri;
		try {
			JSONObject jsonMessage=new JSONObject(msg);
			uri = jsonMessage.getString("uri");		
			SubscriptionManager sm=SubscriptionManager.getInstance();
			List<String> subscriptionids=sm.getSubscriptionIDFromResourceURI(uri);
			//Find subscription with a given destination
			if(subscriptionids.size()!=0)
			for(String subscriptionID:subscriptionids){
				logger.log(Priority.DEBUG, (Object)("Sending notification to subscriptionID:"+subscriptionID));
				sm.callbackRecieved(msg, subscriptionID);
			}
			else {
				//Case so far the notification was not dispatched, dispatch system message if that correspond to one
				String subscriptionID=sm.getSubscriptionId(Constants.createLastEventRD(gatewayID));
				sm.callbackRecieved(msg, subscriptionID);
			}
		} catch (JSONException e) {
			logger.log(Priority.DEBUG, (Object)("Error receiving message:"+e.getMessage()));
		}
    	
    }
    
    public Session getSession(){
    	return session;
    }
}
