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
package org.eclipse.sensinact.studio.ui.common.dialog;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

/**
 * @author Etienne Gandrille
 */
public class SimpleDialog extends MessageDialog {

    /**
     * Create a message dialog. Note that the dialog will have no visual
     * representation (no widgets) until it is told to open.
     *
     * @param parentShell
     *            the parent shell, or <code>null</code> to create a top-level shell
     * @param dialogTitle
     *            the dialog title, or <code>null</code> if none
     * @param dialogMessage
     *            the dialog message
     * @param dialogImageType
     *            one of the following values:
     *            <ul>
     *            <li><code>MessageDialog.NONE</code> for a dialog with no
     *            image</li>
     *            <li><code>MessageDialog.ERROR</code> for a dialog with an
     *            error image</li>
     *            <li><code>MessageDialog.INFORMATION</code> for a dialog
     *            with an information image</li>
     *            <li><code>MessageDialog.QUESTION </code> for a dialog with a
     *            question image</li>
     *            <li><code>MessageDialog.WARNING</code> for a dialog with a
     *            warning image</li>
     *            </ul>
     */
	public SimpleDialog(Shell parentShell, String dialogTitle, String dialogMessage, int dialogImageType) {
		super(parentShell, dialogTitle, null, dialogMessage, dialogImageType, new String[] { IDialogConstants.OK_LABEL, }, 0);
	}
}
