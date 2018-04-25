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
package org.eclipse.sensinact.studio.http.services.server;

import java.net.URL;
import java.util.Date;

import org.restlet.Client;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.Method;
import org.restlet.data.Protocol;
import org.restlet.data.Status;
import org.restlet.engine.local.Entity;
import org.restlet.engine.local.LocalClientHelper;
import org.restlet.representation.InputRepresentation;
import org.restlet.representation.Representation;

/**
 * @author Nicolas Hili
 * @since  Nov 19, 2014
 * 
 * @see http://permalink.gmane.org/gmane.comp.java.restlet/12378
 */
public class BundleResourceClientHelper extends LocalClientHelper {

	public static final Protocol BUNDLERESOURCE = new Protocol("bundleresource","BUNDLERESOURCE", "OSGI Bundle Resource", Protocol.UNKNOWN_PORT);
	
	public BundleResourceClientHelper(Client client) {
		super(client);
		getProtocols().add(BUNDLERESOURCE);
	}
	
	@Override
	protected void handleLocal(Request request, Response response, String decodedPath) {
		String scheme = request.getResourceRef().getScheme();
		if(BUNDLERESOURCE.getSchemeName().equalsIgnoreCase(scheme)) {
			handleFile(request,response);
		} else {
			throw new IllegalArgumentException("Protocol " + scheme + " not supported, only BUNDLERESOURCE is supported");
		}
	}
	
	private void handleFile(Request request, Response response)
	{
		if(Method.GET.equals(request.getMethod()) || Method.HEAD.equals(request.getMethod())) {
			handleGet(request,response);
		}
		else {
            response.setStatus(Status.CLIENT_ERROR_METHOD_NOT_ALLOWED);
            response.getAllowedMethods().add(Method.GET);
            response.getAllowedMethods().add(Method.HEAD);
        }
	}
	
	private void handleGet(Request request, Response response)
	{
		try {
			String path = request.getResourceRef().getPath();
			URL url = new URL(request.getResourceRef().toString());
            Representation output = new InputRepresentation(url.openStream(), getMetadataService().getDefaultMediaType());
            output.setLocationRef(request.getResourceRef());
            output.setModificationDate(new Date());

            // Update the expiration date
            long timeToLive = getTimeToLive();

            if (timeToLive == 0) {
                output.setExpirationDate(null);
            } else if (timeToLive > 0) {
                output.setExpirationDate(new Date(System
                        .currentTimeMillis()
                        + (1000L * timeToLive)));
            }

            // Update the metadata based on file extensions
            String name = path.substring(path.lastIndexOf('/') + 1);
            Entity.updateMetadata(name, output, true, getMetadataService());

            // Update the response
            response.setEntity(output);
            response.setStatus(Status.SUCCESS_OK);						
		} catch(Exception e) {
			response.setStatus(Status.CLIENT_ERROR_NOT_FOUND);			
		}
	}

}
