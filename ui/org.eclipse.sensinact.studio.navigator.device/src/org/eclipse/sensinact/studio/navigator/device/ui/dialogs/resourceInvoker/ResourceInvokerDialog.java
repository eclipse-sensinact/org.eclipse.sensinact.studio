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
package org.eclipse.sensinact.studio.navigator.device.ui.dialogs.resourceInvoker;

import org.apache.log4j.Logger;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.sensinact.studio.http.client.GatewayHttpClient;
import org.eclipse.sensinact.studio.http.client.GatewayHttpClient.RequestParameter;
import org.eclipse.sensinact.studio.http.client.snamessage.SnaMessage;
import org.eclipse.sensinact.studio.model.manager.listener.subscription.SubscriptionListener;
import org.eclipse.sensinact.studio.model.manager.listener.subscription.SubscriptionManager;
import org.eclipse.sensinact.studio.model.resource.utils.ResourceDescriptor;
import org.eclipse.sensinact.studio.model.resource.utils.Segments;
import org.eclipse.sensinact.studio.navigator.device.ui.dialogs.resourceInvoker.methodprovider.MethodProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import org.eclipse.sensinact.studio.resource.AccessMethod;
import org.eclipse.sensinact.studio.resource.AccessMethodType;

/**
 * @author Nicolas Hili
 */
public class ResourceInvokerDialog extends TitleAreaDialog implements SubscriptionListener {

	private static final Logger logger = Logger.getLogger(ResourceInvokerDialog.class);
	
	private final ResourceDescriptor descriptor;	
	private final MethodProvider methodProvider;

	private ParametersComposite parameterComposite;
	private ResultLabel resultLabel;
	
	public ResourceInvokerDialog(Shell parent, ResourceDescriptor descriptor, MethodProvider methodProvider) {
		super(parent);
		
		this.descriptor = descriptor;
		
		this.methodProvider = methodProvider;
		methodProvider.registerResourceInvokerDialog(this);
		setHelpAvailable(false);
	}
	
	@Override
	public void create() {
		super.create();
		setTitle("Resource Invoker");
		setShellStyle(SWT.DIALOG_TRIM | SWT.RESIZE | SWT.MAX);
	}
		
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		configureDialogArea(area);

		methodProvider.createDialogArea(area);
		parameterComposite = new ParametersComposite(area);
		resultLabel = new ResultLabel(area);
			
		return area;
	}
	
	@Override
	protected Control createContents(Composite parent) {
		Control control = super.createContents(parent);
		updateWidgets();
		return control;
	}
	
	
	private static void configureDialogArea(Composite area) {
		GridLayout gridLayout = (GridLayout) area.getLayout();
		gridLayout.marginRight = 5;
		gridLayout.marginLeft = 5;
		GridData gridData = (GridData) area.getLayoutData();
		gridData.widthHint = 640;
	}
	
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.PROCEED_ID, "Proceed", true);
		getButton(IDialogConstants.PROCEED_ID).setEnabled(false);
		super.createButtonsForButtonBar(parent);
		getButton(OK).setVisible(false);
		getButton(CANCEL).setText("Close");
		setDialogHelpAvailable(false);
		getButton(IDialogConstants.PROCEED_ID).addMouseListener(new MouseListener() {		
			@Override
			public void mouseUp(MouseEvent e) {
				launchRequest(e);
			}

			@Override
			public void mouseDown(MouseEvent e) {}

			@Override
			public void mouseDoubleClick(MouseEvent e) {}
		});
	}
	
	public void updateWidgets() {
		String type = methodProvider.getAccessMethodType();
		AccessMethod method = methodProvider.getAccessMethod();
		
        // update parameters
		if (method != null) {
			parameterComposite.createParameterList(method);
			getShell().pack(true);
			getShell().setSize(getShell().computeSize(SWT.DEFAULT, SWT.DEFAULT, true));	
		} else {
			parameterComposite.clearContent();
		}
		
		// button value
		if (type != null) {
			getButton(IDialogConstants.PROCEED_ID).setText(type);
		} else {
			getButton(IDialogConstants.PROCEED_ID).setText("Proceed");
		}
		
		// click button 
		if (method != null && type != null) {
			getButton(IDialogConstants.PROCEED_ID).setEnabled(true);
		} else {
			getButton(IDialogConstants.PROCEED_ID).setEnabled(false);
		}
	}

	protected void launchRequest(MouseEvent e) {
		AccessMethodType type = AccessMethodType.get(methodProvider.getAccessMethodType());		
		String message = "";
		switch (type) {
		case GET:
			message = actionPressed();
			break;
		case ACT:
			message = actionPressed();
			break;
		case SUBSCRIBE:
			message = subscribePressed();
			break;
		case UNSUBSCRIBE:
			message = unsubscribePressed();
			break;
		case SET:
			message = actionPressed();
			break;
		default:
			break;
		}
		
		resultLabel.setText(message);		
	}
	
	/**
	 * This method is called when the user selected an ACT/GET/SET access method.
	 * It sends an ACT/GET/SET request to the gateway and get the result of the request
	 * @return the result of the request
	 */
	private String actionPressed() {
		try {
			AccessMethod method = methodProvider.getAccessMethod();
			AccessMethodType type = method.getType();
			Segments segments = new Segments.Builder().resource(descriptor).method(type).build();
			if (type.equals(AccessMethodType.GET)) {
				return GatewayHttpClient.sendGetRequest(segments).getFullDescription();	
			} else {
				RequestParameter[] params = parameterComposite.getParametersValues(method);
				return GatewayHttpClient.sendPostRequest(segments,null, params).getFullDescription();
			}
		} catch (Exception e) {
			logger.error("action failure", e);
			return "[ERROR] " + e.getMessage();
		}
	}
	
	/**
	 * This method is called when the user selected an GET access method.
	 * It sends an GET request to the gateway and get the result of the request
	 * @return the result of the request
	 */
	private String subscribePressed() 
	{
		try {
			String id = SubscriptionManager.getInstance().subscribeResource(descriptor, this);
			return "Subscribe success id=" + id;
		} catch (Exception e) {
			logger.error("Subscribe failure", e);
			return "[ERROR] " + e.getMessage();
		}
	}

	/**
	 * This method is called when the user selected an UNSUBSCRIBE access method.
	 * It sends an UNSUBSCRIBE request to the gateway using the current subscriptionId 
	 * of the resource  passed as parameter
	 * 
	 * @return the result of the request
	 */
	private String unsubscribePressed() 
	{
		try {
			SubscriptionManager.getInstance().unsubscribeResource(descriptor, this);
			return "unsubscribe success";
		} catch (Exception e) {
			logger.error("Unsubscribe failure",e);
			return "[ERROR] " + e.getMessage();
		}
	}

	@Override
	public void onEvent(SnaMessage response, ResourceDescriptor resource)
	{	
//		Segments segments = new Segments.Builder().resource(resource
//				).method(AccessMethodType.GET).build();
//		//String msg = "";
//		try {
//			//msg = GatewayHttpClient.sendGetRequest(segments).getPrettyPrintedValue();
//		} catch (Exception e) 
//		{
//			logger.error("unsubscribe failure", e);
//			//msg = e.getMessage();
//		}
		resultLabel.setText("[SUBSCRIBE EVENT] " + response.getPrettyPrintedValue());
		
	}
}
