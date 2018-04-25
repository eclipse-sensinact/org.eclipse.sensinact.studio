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
package org.eclipse.sensinact.studio.view.projectexplorer.handler;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sensinact.studio.ui.common.dialog.SnaHandler;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.sensinact.studio.http.messages.snamessage.MsgSensinact;
import org.eclipse.sensinact.studio.language.sensinact.DSL_SENSINACT;
import org.eclipse.sensinact.studio.language.sensinact.Sensinact;

/**
 * @author Etienne Gandrille
 */
public abstract class SnaAppHandler extends SnaHandler {
	
	protected DSL_SENSINACT fileURI2eca(URI uri) {
		ResourceSet rs = new ResourceSetImpl();
		org.eclipse.emf.ecore.resource.Resource r = rs.getResource(uri, true);
		Sensinact sens = (Sensinact) r.getContents().get(0);
		return sens.getEca();
	}
	
	protected URI selection2fileURI(ExecutionEvent event) {
		Object firstElement = getSelectedElement(event);
		if (firstElement != null && firstElement instanceof IFile) {
			IFile file = (IFile) firstElement;			
			// IProject project = file.getProject();
			// createFolder(project);
			return URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		}

		return null;
	}

	protected void createFolder(IProject project) throws CoreException {
		IFolder srcGenFolder = project.getFolder("src-gen");
		if (!srcGenFolder.exists()) {
			srcGenFolder.create(true, true, new NullProgressMonitor());
		}
	}
		
	protected String computeRuleName(URI snaFileURI) {
		String fileName = snaFileURI.segment(snaFileURI.segmentCount()-1);
		
		// removes extension at the end of the filename
		if (fileName.lastIndexOf(".") != -1)
			fileName = fileName.substring(0, fileName.lastIndexOf("."));
		return fileName;
	}
	
	protected void displayResult(Shell shell, String title, String fileName, MsgSensinact response) {
		// TODO Needs to be improved. Displayed information are a bit weak...
		
		String description = response.toString();	
		if (response.isValid())
			MessageDialog.openInformation(shell, title, description);
		else
			MessageDialog.openError(shell, title, description);
	}
	
	protected void displayResult(Shell shell, String title, String fileName, Exception e) {
		String description = e.getMessage() + "\n" + "filename: " + fileName;
		MessageDialog.openError(shell, title, description);
	}
}
