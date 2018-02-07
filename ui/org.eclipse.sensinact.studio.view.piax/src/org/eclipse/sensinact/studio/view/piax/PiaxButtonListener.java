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
package org.eclipse.sensinact.studio.view.piax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sensinact.studio.model.manager.listener.devicelocation.DeviceLocationManager;
import org.eclipse.sensinact.studio.model.manager.modelupdater.ModelEditor;
import org.eclipse.sensinact.studio.model.resource.utils.DeviceDescriptor;
import org.eclipse.sensinact.studio.model.resource.utils.GPScoordinates;
import org.eclipse.sensinact.studio.model.resource.utils.ResourceDescriptor;
import org.eclipse.sensinact.studio.preferences.ConfigurationManager;
import org.eclipse.sensinact.studio.preferences.GatewayHttpConfig;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Etienne Gandrille
 */
class PiaxButtonListener implements MouseListener {

	private static final Logger logger = Logger.getLogger(PiaxButtonListener.class);
	private final PiaxView view;

	public PiaxButtonListener(PiaxView view) {
		this.view = view;
	}

	@Override
	public void mouseDoubleClick(MouseEvent e) {
	}

	@Override
	public void mouseDown(MouseEvent e) {
	}

	@Override
	public void mouseUp(MouseEvent e) {
		final Shell shell = Display.getDefault().getActiveShell();

		// TODO Attention: seule la première gateway est prise en compte !!! 
		GatewayHttpConfig[] gateways = ConfigurationManager.getGateways();
		String gatewayID = gateways[0].getName();
		
		String deviceID = "piax";
		String serviceID = "discoveries";
		String resourceID = "sensor";

		ResourceDescriptor desc = new ResourceDescriptor(gatewayID, deviceID, serviceID, resourceID);

		try {
			if (!ModelEditor.getInstance().existsResource(desc)) {
				MessageDialog.openError(shell, "Unknown Piax", "Unavailable resource\n" + desc);
				return;
			}
		} catch (InterruptedException e1) {
			logger.error("", e1);
			return;
		}

		// Model Values
		String modelType = view.getModelType();
		Map<String, String> modelMatch = view.getModelMatch();
		Map<String, String> modelTerm = view.getModelTerm();
		List<RangeObject> modelRange = view.getModelRange();
		Map<String, String> modelOrderBy = view.getOrderBy();
		int modelSize = view.getSize();
		int modelFrom = view.getFrom();
		String expr = "";

		try {
			expr = buildJson(modelType, modelMatch, modelTerm, modelRange, modelOrderBy, modelSize, modelFrom);
		}catch (Exception e1){
			e1.printStackTrace();
		}

		Map<String, String> map = new HashMap<String, String>();
		map.put("params", expr);

		/* UPDATE THIS !
		try {
			Segments segments = new Segments.Builder().gateway(gatewayID).device(deviceID).service(serviceID).resource(resourceID).method(AccessMethodType.GET).build();			
	
			
			ObjectMessage result = (ObjectMessage) GatewayHttpClient.sendGetRequest(segments, map);
			JSONArray array = result.getObject().getJSONArray("result");
			for (int i = 0; i < array.length(); i++)
				processPiaxObject(array.getJSONObject(i));

		} catch (IOException e1) {
			MessageDialog.openError(shell, "Piax connection", "Error while getting PIAX info");
			logger.error("Error while getting PIAX info", e1);
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
		*/
	}

	private static String buildJson(String modelType, Map<String, String> modelMatch, Map<String, String> modelTerm, List<RangeObject> modelRange, Map<String, String> modelOrderBy, int modelSize, int modelFrom) throws Exception {
		// TODO by Ken :-)
		JSONObject j = new JSONObject();
		if (modelMatch != null){
			JSONObject matchj = new JSONObject();
			for(Map.Entry<String, String> match: modelMatch.entrySet()){
				matchj.put(match.getKey(), match.getValue());
			}
			j.put("match", matchj);
		}
		
		if (modelTerm != null){
			JSONObject termj = new JSONObject();
			for(Map.Entry<String, String> term: modelMatch.entrySet()){
				termj.put(term.getKey(), term.getValue());
			}
			j.put("term", termj);
		}
		
		if (modelRange != null){
			JSONObject rangej = new JSONObject();
			for(RangeObject ro: modelRange){
				JSONObject rangeChild = new JSONObject();
				if (ro.getOperator().equals("<")){
					rangeChild.put("lt", ro.getValue());
				}else if(ro.getOperator().equals(">")){
					rangeChild.put("gt", ro.getValue());
				}
				
				rangej.put(ro.getKey(), rangeChild);
			}
			j.put("range", rangej);
		}
		
		j.put("size", modelSize);
		j.put("from", modelFrom);
		
		return j.toString();
	}

	// {"timestamp":1.448531707634E12,"name":"position","resource":"position","longitude":35.86612225587049,"numericValue":371,"latitude":50.868860935141626,"uri":"/slider/cursor/position/value","serviceProvider":"slider","snaId":"sna1","serviceName":"cursor"}
	private void processPiaxObject(JSONObject piaxMsg) throws JSONException {

		String gatewayID = piaxMsg.getString("snaId");
		String deviceID = piaxMsg.getString("serviceProvider");
		String serviceID = piaxMsg.getString("serviceName");
		String resourceID = piaxMsg.getString("resource");
		ResourceDescriptor desc = new ResourceDescriptor(gatewayID, deviceID, serviceID, resourceID);

		double lat = Double.parseDouble(piaxMsg.getString("latitude"));
		double lng = Double.parseDouble(piaxMsg.getString("longitude"));
		GPScoordinates gps = new GPScoordinates(lat, lng);

		String value = null;
		if (piaxMsg.has("numericValue")) {
			value = piaxMsg.getString("numericValue");
		} else if (piaxMsg.has("stringValue")) {
			value = piaxMsg.getString("stringValue");
		} else
			throw new IllegalArgumentException("Can't find value in PIAX object");

		createPiaxObjectsInModel(desc, gps, value);
	}

	private void createPiaxObjectsInModel(ResourceDescriptor desc, GPScoordinates gps, String value) {
		// basic PIAX
		ModelEditor.getInstance().addDeviceIfNotExist(desc.getGateway(), desc.getDevice());
		ModelEditor.getInstance().addServiceIfNotExist(desc.getGateway(), desc.getDevice(), desc.getService());
		//ModelEditor.getInstance().addResourceIfNotExist(desc, ResourcePackage.Literals.PROPERTY);

		DeviceLocationManager.getInstance().updateLocationInStudio(new DeviceDescriptor(desc.getGateway(), desc.getDevice()), gps);
	}
}