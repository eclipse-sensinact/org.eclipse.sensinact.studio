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
package org.eclipse.sensinact.studio.model.resource.utils;

import java.math.BigDecimal;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Etienne Gandrille
 */
public class JsonUtil {

	public static final String NAME_KEY = "name";
	public static final String TYPE_KEY = "type";
	public static final String VALUE_KEY = "value";
	
	public static JSONObject createObject(Object... keysValues) throws JSONException {
		JSONObject retval = new JSONObject();

		for (int i = 0; i < keysValues.length; i += 2) {
			retval.put((String) keysValues[i], keysValues[i + 1]);
		}

		return retval;
	}

	public static JSONArray createArray(Object... elements) throws JSONException {
		JSONArray jsonArray = new JSONArray();
		for (Object element : elements) {
			jsonArray.put(element);
		}
		return jsonArray;
	}

	public static JSONObject createNameTypeValue(String name, String type, Object value) throws JSONException {
		JSONObject retval = new JSONObject();

		if (value == null)
			throw new RuntimeException("value is null (name=" + name + " type=" + type + ")");
		
		// Types definition
		final String intType = int.class.toString(); // int
		final String integerType = Integer.class.getName(); // java.lang.Integer
		final String bigDecimalType = BigDecimal.class.getName(); // java.math.BigDecimal
		final String doubleType = double.class.toString(); // double
		final String objectDoubleType = Double.class.getName(); // java.lang.Double
		final String booleanType = boolean.class.toString(); // boolean
		final String objectBooleanType = Boolean.class.getName(); // java.lang.Boolean
		final String stringType = String.class.getName(); // java.lang.String
		final String JSONObjectType = JSONObject.class.getName(); // org.json.JSONObject
		
		retval.put(NAME_KEY, name);

		// Integer
		if (intType.equals(type) || integerType.equals(type) || bigDecimalType.equals(type)) {
			retval.put(TYPE_KEY, integerType);
			if (value instanceof Integer) {
				retval.put(VALUE_KEY, ((Integer) value).intValue());
				return retval;
			} else if (value instanceof String) {
				retval.put(VALUE_KEY, Integer.parseInt((String) value));
				return retval;
			} else if (value instanceof BigDecimal) {
				retval.put(VALUE_KEY, ((BigDecimal) value).intValue());
				return retval;
			} else {
				throw new RuntimeException("expected type is " + type + " but value is of type " + value.getClass().getName());
			}
		}

		// Double
		if (doubleType.equals(type) || objectDoubleType.equals(type)) {
			retval.put(TYPE_KEY, objectDoubleType);
			if (value instanceof Double) {
				retval.put(VALUE_KEY, ((Double) value).doubleValue());
				return retval;
			} else if (value instanceof BigDecimal) {
				retval.put(VALUE_KEY, ((BigDecimal) value).doubleValue());
				return retval;
			} else if (value instanceof String) {
				retval.put(VALUE_KEY, Double.parseDouble((String) value));
				return retval;
			} else {
				throw new RuntimeException("expected type is " + type + " but value is of type " + value.getClass().getName());
			}
		}

		// Boolean
		if (booleanType.equals(type) || objectBooleanType.equals(type)) {
			retval.put(TYPE_KEY, objectBooleanType);
			if (value instanceof Boolean) {
				retval.put(VALUE_KEY, ((Boolean) value).booleanValue());
				return retval;
			} else if (value instanceof String) {
				retval.put(VALUE_KEY, Boolean.parseBoolean((String) value));
				return retval;
			} else {
				throw new RuntimeException("expected type is " + type + " but value is of type " + value.getClass().getCanonicalName());
			}
		}

		// String
		if (stringType.equals(type) || "string".equals(type)) {
			retval.put(TYPE_KEY, stringType);
			if (value instanceof String) {
				String val = (String) value;
				if (val.length() >= 2) {
					if ((val.startsWith("\"") && val.endsWith("\"")) || (val.startsWith("'") && val.endsWith("'"))) {
						val = val.substring(1, val.length() - 1);
					}
				}
				retval.put(VALUE_KEY, val);
				return retval;
			} else {
				throw new RuntimeException("expected type is " + type + " but value is of type " + value.getClass().getCanonicalName());
			}
		}

		// JSON Object
		if (JSONObjectType.equals(type)) {
			retval.put(TYPE_KEY, JSONObjectType);
			if (value instanceof JSONObject) {
				retval.put(VALUE_KEY, (JSONObject) value);
				return retval;
			} else if (value instanceof String) {
				retval.put(VALUE_KEY, new JSONObject((String) value));
				return retval;
			} else {
				throw new RuntimeException("expected type is " + type + " but value is of type " + value.getClass().getCanonicalName());
			}
		}

		// Other...
		throw new RuntimeException("Should never happen");
	}

	public static String prettyPrintJsonArray(JSONArray array, boolean fullMessage) {
		StringBuilder sb = new StringBuilder();

		try {
			if (array.length() == 0) {
				sb.append("<empty array>");
			} else if (array.length() == 1) {
				sb.append("1 element : ");
				sb.append(array.getString(0));
			} else {
				sb.append(array.length() + " elements");
				if (fullMessage) {
					for (int i = 0; i < array.length(); i++) {
						sb.append("\n * " + array.getString(i));
					}
				}
			}
		} catch (JSONException e) {
			return "<Error during JSON decoding>";
		}

		return sb.toString();
	}

	public static String prettyPrintJsonObject(JSONObject object) {
		StringBuilder sb = new StringBuilder();

		try {
			boolean begin = true;
			Iterator<?> keys = object.keys();
			while (keys.hasNext()) {
				String key = (String) keys.next();
				String value = object.get(key).toString();
				if (begin)
					begin = false;
				else
					sb.append("\n");
				sb.append(" * ").append(key).append(" = ").append(value);
			}
		} catch (JSONException e) {
			return "<Error during JSON decoding>";
		}

		return sb.toString();
	}
}
