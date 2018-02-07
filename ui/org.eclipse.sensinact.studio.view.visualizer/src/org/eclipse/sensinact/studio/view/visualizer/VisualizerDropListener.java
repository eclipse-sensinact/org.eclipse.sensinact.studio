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
package org.eclipse.sensinact.studio.view.visualizer;

import org.apache.log4j.Logger;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sensinact.studio.model.manager.modelupdater.ModelEditor;
import org.eclipse.sensinact.studio.model.resource.utils.ResourceDescriptor;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * @author Etienne Gandrille
 */
public class VisualizerDropListener implements DropTargetListener {

	private final VisualizerView visualizerView;

	private static final Logger logger = Logger.getLogger(VisualizerDropListener.class);
	
	public VisualizerDropListener(VisualizerView visualizerView) {
		this.visualizerView = visualizerView;
	}

	@Override
	public void dragEnter(DropTargetEvent event) {
	}

	@Override
	public void dragLeave(DropTargetEvent event) {
	}

	@Override
	public void dragOperationChanged(DropTargetEvent event) {
	}

	@Override
	public void dragOver(DropTargetEvent event) {
	}

	@Override
	public void drop(DropTargetEvent event) {
		try {
			if (TextTransfer.getInstance().isSupportedType(event.currentDataType)) {
				if (event.widget instanceof DropTarget) {	
					
					ResourceDescriptor rDescriptor = null;
					try {
						rDescriptor = new ResourceDescriptor((String) event.data);
					} catch (Exception e) {
						throw new Exception("Only resources can be displayed in the visualizer");
					}
					
					String typeName = ModelEditor.getInstance().getResourceClass(rDescriptor).getName();

					VisualizerSettings visuSettings = new VisualizerSettings(rDescriptor, typeName);
					visualizerView.dropValidated(visuSettings);
				}
			}
		} catch (Exception e) {
			Shell shell = Display.getCurrent().getActiveShell();
			String msg = e.getMessage();
			logger.error("Drop error: " + msg);
			MessageDialog.openError(shell, "Error", msg);
		}
	}

	@Override
	public void dropAccept(DropTargetEvent event) {
	}
}
