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
package org.eclipse.sensinact.studio.http.messages;

/**
 * @author Etienne Gandrille
 */
public enum HTTP_CODE {
	CODE_100(100, "Continue"),
	CODE_101(101, "Switching Protocols"),
	CODE_102(102, "Processing"),
	CODE_200(200, "OK"),
	CODE_201(201, "Created"),
	CODE_202(202, "Accepted"),
	CODE_203(203, "Non-Authoritative Information"),
	CODE_204(204, "No Content"),
	CODE_205(205, "Reset Content"),
	CODE_206(206, "Partial Content"),
	CODE_207(207, "Multi-Status (WebDAV; RFC 4918)"),
	CODE_208(208, "Already Reported (WebDAV; RFC 5842)"),
	CODE_226(226, "IM Used (RFC 3229)"),
	CODE_300(300, "Multiple Choices"),
	CODE_301(301, "301 Moved Permanently"),
	CODE_302(302, "Found"),
	CODE_303(303, "See Other"),
	CODE_304(304, "Not Modified"),
	CODE_305(305, "Use Proxy (since HTTP/1.1)"),
	CODE_306(306, "Switch Proxy"),
	CODE_307(307, "Temporary Redirect (since HTTP/1.1)"),
	CODE_308(308, "Permanent Redirect (RFC 7538)"),
	CODE_400(400, "Bad Request"),
	CODE_401(401, "Unauthorized"),
	CODE_402(402, "Payment Required"),
	CODE_403(403, "Forbidden"),
	CODE_404(404, "Not Found"),
	CODE_405(405, "Method Not Allowed"),
	CODE_406(406, "Not Acceptable"),
	CODE_407(407, "Proxy Authentication Required"),
	CODE_408(408, "Request Timeout"),
	CODE_409(409, "Conflict"),
	CODE_410(410, "Gone"),
	CODE_411(411, "Length Required"),
	CODE_412(412, "Precondition Failed"),
	CODE_413(413, "Payload Too Large"),
	CODE_414(414, "URI Too Long"),
	CODE_415(415, "Unsupported Media Type"),
	CODE_416(416, "Range Not Satisfiable"),
	CODE_417(417, "Expectation Failed"),
	CODE_418(418, "I'm a teapot (RFC 2324)"),
	CODE_419(419, "Authentication Timeout"),
	CODE_420(420, "Method Failure"),
	CODE_421(421, "Misdirected Request"),
	CODE_422(422, "Unprocessable Entity (WebDAV; RFC 4918)"),
	CODE_423(423, "Locked (WebDAV; RFC 4918)"),
	CODE_424(424, "Failed Dependency (WebDAV; RFC 4918)"),
	CODE_426(426, "Upgrade Required"),
	CODE_428(428, "Precondition Required"),
	CODE_429(429, "Too Many Requests"),
	CODE_431(431, "Request Header Fields Too Large"),
	CODE_440(440, "Login Timeout (Microsoft)"),
	CODE_444(444, "No Response (Nginx)"),
	CODE_449(449, "Retry With (Microsoft)"),
	CODE_450(450, "Blocked by Windows Parental Controls (Microsoft)"),
	CODE_451(451, "Unavailable For Legal Reasons"),
	CODE_494(494, "Request Header Too Large (Nginx)"),
	CODE_495(495, "Cert Error (Nginx)"),
	CODE_496(496, "No Cert (Nginx)"),
	CODE_497(497, "HTTP to HTTPS (Nginx)"),
	CODE_498(498, "Token expired/invalid (Esri)"),
	CODE_499(499, "Client Closed Request (Nginx)"),
	CODE_500(500, "Internal Server Error"),
	CODE_501(501, "Not Implemented"),
	CODE_502(502, "Bad Gateway"),
	CODE_503(503, "Service Unavailable"),
	CODE_504(504, "Gateway Timeout"),
	CODE_505(505, "HTTP Version Not Supported"),
	CODE_506(506, "Variant Also Negotiates (RFC 2295)"),
	CODE_507(507, "Insufficient Storage (WebDAV; RFC 4918)"),
	CODE_508(508, "Loop Detected (WebDAV; RFC 5842)"),
	CODE_509(509, "Bandwidth Limit Exceeded (Apache bw/limited extension)"),
	CODE_510(510, "Not Extended (RFC 2774)"),
	CODE_511(511, "Network Authentication Required"),
	CODE_520(520, "Unknown Error"),
	CODE_522(522, "Origin Connection Time-out"),
	CODE_598(598, "Network read timeout error (Unknown)"),
	CODE_599(599, "Network connect timeout error (Unknown)");
	  
	private final int code;
	private final String message;
	   
	private HTTP_CODE(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public String getType() {
		if (code >= 100 && code <= 199)
			return "Informational";
		if (code >= 200 && code <= 299)
			return "Success";
		if (code >= 300 && code <= 399)
			return "Redirection";
		if (code >= 400 && code <= 499)
			return "Client Error";
		if (code >= 500 && code <= 599)
			return "Server Error";
		throw new IllegalArgumentException("Unknown HTTP CODE " + code);
	}
	
	public String toString(){
		return "HTTP " + code + ": " + getType() + " (" + message + ")";
	}
	
	public int getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}
	
	public static HTTP_CODE toCode(int code) {
		for (HTTP_CODE hc : HTTP_CODE.values())
			if (hc.getCode() == code)
				return hc;
		throw new IllegalArgumentException("Unknown HTTP CODE " + code);
	}
}
