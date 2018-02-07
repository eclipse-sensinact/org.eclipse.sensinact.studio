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
package org.eclipse.sensinact.studio.perspective;

import org.eclipse.sensinact.studio.navigator.device.DeviceNavigatorView;
import org.eclipse.sensinact.studio.view.outdoor.OutdoorDeploymentView;
import org.eclipse.sensinact.studio.view.visualizer.VisualizerView;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

/**
 * @author Etienne Gandrille
 */
public class PerspectiveFactory implements IPerspectiveFactory {

	public final static String NAVIGATOR_FOLDER_ID = "org.eclipse.sensinact.studio.folderLayout.navigator";
	public final static String VIZUALIZER_FOLDER_ID = "org.eclipse.sensinact.studio.folderLayout.visualizer";
	public final static String DEPLOY_FOLDER_ID = "org.eclipse.sensinact.studio.folderLayout.deploymentView";
	public final static String GATEWAY_FOLDER_ID = "org.eclipse.sensinact.studio.folderLayout.gateway";
	
	@Override
	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		IFolderLayout navigatorFolderLayout = layout.createFolder(NAVIGATOR_FOLDER_ID, IPageLayout.LEFT, 0.25f,editorArea);
		IFolderLayout visualizerFolderLayout = layout.createFolder(VIZUALIZER_FOLDER_ID, IPageLayout.BOTTOM, 0.80f, NAVIGATOR_FOLDER_ID);
		IFolderLayout deploymentViewFolderLayout = layout.createFolder(DEPLOY_FOLDER_ID, IPageLayout.TOP, 0.50f,editorArea);
		
		navigatorFolderLayout.addView(DeviceNavigatorView.VIEW_ID);
		navigatorFolderLayout.addView(IPageLayout.ID_PROJECT_EXPLORER);
		
		visualizerFolderLayout.addView(VisualizerView.VIEW_ID);
		
		deploymentViewFolderLayout.addView(OutdoorDeploymentView.VIEW_ID);
	}
}
