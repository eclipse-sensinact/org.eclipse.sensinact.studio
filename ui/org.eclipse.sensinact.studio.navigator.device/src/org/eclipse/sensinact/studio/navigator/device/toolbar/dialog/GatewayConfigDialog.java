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
package org.eclipse.sensinact.studio.navigator.device.toolbar.dialog;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.sensinact.studio.preferences.GatewayHttpConfig;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

/**
 * @author Etienne Gandrille
 */
public class GatewayConfigDialog extends TitleAreaDialog {

	// default model values
	// also used for storing values while closing window
	private String name = "NewConfiguration";
	private String address = "";
	private int port = 8080;
	private int timeout = 10000;
	private String username;
	private String password;
	
	
	// Widgets
	private Text nameText;
	private Text addressText;
	private Spinner portSpinner;
	private Spinner timeoutSpinner;
	private Text usernameText;
	private Text passwordText;
	private boolean isEditable;
	private final String[] gatewayNames;

	public GatewayConfigDialog(Shell parent, String[] gatewayNames) {
		super(parent);
		isEditable = true;
		this.gatewayNames = gatewayNames;
		this.username = "";
		this.password = "";
	}
	
	public GatewayConfigDialog(Shell parent, String name, String address, int port, int timeout, String username, String password) {
		super(parent);
		this.name = name;
		this.address = address;
		this.port = port;
		this.timeout = timeout;
		this.isEditable = false;
		this.gatewayNames = null;
		this.username = username;
		this.password = password;
	}

	public GatewayHttpConfig getGateway() {
		return new GatewayHttpConfig(name, address, port, timeout, username, password);
	}
	
	@Override
	public void create() {
		super.create();
		setTitle("New gateway configuration");
		validateAll(gatewayNames);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);

		// container with two columns
		Composite container = new Composite(area, SWT.NONE);
		container.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true));
		container.setLayout(new GridLayout(2, false));

		// text fields
		nameText = createTextField(container, "Configuration Name", gatewayNames, name, isEditable, false);
		addressText = createTextField(container, "Address", gatewayNames, address, true, false); 
		addressText.setToolTipText("The address of the gateway.\navailable addresses:\nhttp://localhost\nhttp://192.168.1.69\nlocalhost\n192.168.1.69");				
		
		// Spinner fields
		portSpinner = createSpinnerField(container, "Port", 10000, port);
		timeoutSpinner = createSpinnerField(container, "Timeout (ms)", 60000, timeout);		
	
		// credentials
		usernameText = createTextField(container, "Username", new String[0], username, true, false); 
		passwordText = createTextField(container, "Password", new String[0], password, true, true);
		
		return area;
	}

	private Text createTextField(Composite container, String label, final String[] gatewayNames, String initValue, boolean readOnly, boolean ispassword) {
		
		// label
		new Label(container, SWT.NONE).setText(label);
		
		// field
		Text text = new Text(container, SWT.BORDER);
		if (ispassword)
			text.setEchoChar('*');
		text.setText(initValue);
		text.setEditable(readOnly);
		text.setLayoutData(new GridData(GridData.FILL, SWT.TOP, true, false));
		
		
		// listeners
		text.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {}
			@Override
			public void focusLost(FocusEvent e) {
				validateAll(gatewayNames);
			}
		});
		text.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {
				validateAll(gatewayNames);
			}
		});
		
		return text;
	}
	
	private Spinner createSpinnerField(Composite container, String label, int maximum, int initValue) {
		
		// label
		new Label(container, SWT.NONE).setText(label);

		// field
		Spinner portSpinner = new Spinner(container, SWT.BORDER);
		portSpinner.setMaximum(maximum);
		portSpinner.setSelection(initValue);
		portSpinner.setLayoutData(new GridData(GridData.FILL, SWT.TOP, true, false));
		
		return portSpinner;
	}
	
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	@Override
	protected void okPressed() {
		this.name = nameText.getText();
		this.address = addressText.getText();
		this.port = portSpinner.getSelection();
		this.timeout = timeoutSpinner.getSelection();
		this.username = usernameText.getText();
		this.password = passwordText.getText();
		super.okPressed();
	}
	
	// ==========
	// Validation
	// ==========

	private void validateAll(String[] gatewayNames) {
		String error = getError(gatewayNames);
		if (error != null) {
			setErrorMessage(error);
			getButton(OK).setEnabled(false);
		} else {
			setErrorMessage(null);
			getButton(OK).setEnabled(true);
		}
	}

	private String getError(String[] gatewayNames) {
		String nameError = checkName(gatewayNames);
		if (nameError != null) {
			return nameError;
		}

		String addressError = checkAddress();
		if (addressError != null) {
			return addressError;
		}
		
		return null;
	}
	
	private String checkName(String[] gatewayNames) {
		String name = nameText.getText();
		if (name.trim().equals("")) {
			return "The configuration name must be set";
		}
		if (gatewayNames != null) {
			for (String gatewayName : gatewayNames) {
				if (gatewayName.trim().equals(name.trim()))
						return "The gateway " + name + " already exists";
			}
		}
		
		return null;
	}

	private String checkAddress() {
		String address = addressText.getText().trim();
		if (address.equals("")) {
			return "The gateway address must be set";
		}

		boolean isLocalhost = address.equals("localhost") || address.equals("http://localhost");
		boolean isIPv4 = address.matches("^(http://)?[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}$");
		boolean isDnsName = address.matches("^(http://)?[0-9A-Za-z\\.]+\\.[A-Za-z]{2,8}$");
		if (!isLocalhost && !isIPv4 & !isDnsName) {
			return "The gateway address is not well formed";
		}

		return null;
	}
}
