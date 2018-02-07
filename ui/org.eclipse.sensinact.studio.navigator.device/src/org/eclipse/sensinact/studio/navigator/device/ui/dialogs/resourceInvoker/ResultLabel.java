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

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * @author Etienne Gandrille
 */
public class ResultLabel {

	/**
	 * The label of the result Text
	 */
	private Label resultLabel;

	/**
	 * The Text widget to display the return value of the gateway, for an ACT, GET, SET
	 */
	private Text resultText;
	
	ResultLabel(Composite area) {
		resultLabel = new Label(area, SWT.NONE);
		resultLabel.setText("Result:");
		
		resultText = new Text(area, SWT.BORDER | SWT.READ_ONLY | SWT.MULTI | SWT.WRAP);
		GridData gridData = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gridData.heightHint = 5 * resultText.getLineHeight();
		resultText.setLayoutData(gridData);
	}
	
	void setText(String text) {
		resultText.setText(text);
	}
}
