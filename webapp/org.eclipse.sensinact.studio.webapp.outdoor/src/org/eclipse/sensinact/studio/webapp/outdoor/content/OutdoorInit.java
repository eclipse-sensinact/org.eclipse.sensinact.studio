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
package org.eclipse.sensinact.studio.webapp.outdoor.content;

import org.eclipse.sensinact.studio.http.services.server.SensinactServerResource;
import org.restlet.resource.Get;

/**
 * @author Etienne Gandrille
 */
public class OutdoorInit extends SensinactServerResource {

	/** Location displayed when studio starts */
	private static final LOCATION DEFAULT_LOCATION = LOCATION.CEA_GRENOBLE;

	@Get
	public String getValue(String params) {
		return getDefaultLocation();
	}
	
	public static String getDefaultLocation() {
		return DEFAULT_LOCATION.toJSON();
	}
	
	public enum LOCATION
	{
		SANTANDER("43.464304", "-3.810365", "13"), 
		CEA_GRENOBLE("45.19954840972916", "5.702977180480957", "15"), 
		MURCIA("37.98682789766166", "-1.1273860931396484", "13"),
		PALERMO("38.16270754361624","13.309797048568726","13");
		
		private final String lat;
		private final String lng;
		private final String zoom;

		private LOCATION(String lat, String lng, String zoom) {
			this.lat = lat;
			this.lng = lng;
			this.zoom = zoom;
		}
		
		public String toJSON() {
			StringBuilder sb = new StringBuilder();
			sb.append("{");
			buildJSONAttribute(sb, "lat", lat);
			sb.append(",");
			buildJSONAttribute(sb, "lng", lng);
			sb.append(",");
			buildJSONAttribute(sb, "zoom", zoom);
			sb.append("}");
			return sb.toString();
		}

		private void buildJSONAttribute(StringBuilder sb, String key, String val) {
			sb.append("\"").append(key).append("\"").append(":").append("\"").append(val).append("\"");
		}
	}
}
