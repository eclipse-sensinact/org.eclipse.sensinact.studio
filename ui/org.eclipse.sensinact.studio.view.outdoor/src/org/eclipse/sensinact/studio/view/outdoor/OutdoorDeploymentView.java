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
package org.eclipse.sensinact.studio.view.outdoor;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.log4j.Logger;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.sensinact.studio.http.services.server.GatewayHttpServer;
import org.eclipse.sensinact.studio.http.services.server.serverstarted.PortUpdate;
import org.eclipse.sensinact.studio.http.services.server.serverstarted.ResourceAddedUpdate;
import org.eclipse.sensinact.studio.http.services.server.serverstarted.ServerUpdatedListener;
import org.eclipse.sensinact.studio.http.services.server.serverstarted.ServerUpdatedManager;
import org.eclipse.sensinact.studio.http.services.server.serverstarted.UpdateDescriptor;
import org.eclipse.sensinact.studio.model.manager.listener.devicelocation.DeviceLocationListener;
import org.eclipse.sensinact.studio.model.manager.listener.devicelocation.DeviceLocationManager;
import org.eclipse.sensinact.studio.model.resource.utils.DeviceDescriptor;
import org.eclipse.sensinact.studio.model.resource.utils.GPScoordinates;
import org.eclipse.sensinact.studio.preferences.ConfigurationManager;
import org.eclipse.sensinact.studio.webapp.outdoor.Startup;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.browser.ProgressEvent;
import org.eclipse.swt.browser.ProgressListener;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

/**
 * @author Nicolas Hili, Etienne Gandrille
 */
public class OutdoorDeploymentView implements ServerUpdatedListener, DeviceLocationListener {

	private static final Logger logger = Logger.getLogger(OutdoorDeploymentView.class);
	
	public static final String VIEW_ID = "org.eclipse.sensinact.studio.view.outdoor.view";
	
	private static Browser browser;
	private int studioPort = 0;
	private static Composite dndComposite;
	private static Shell dndShell;

	private static boolean browserStarted = false;

	public OutdoorDeploymentView() {
		// stats server
		GatewayHttpServer.getInstance();
	}

	@PostConstruct
	public void createControls(final Composite parent) {
		parent.setLayout(null);
		parent.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, true, true, 1, 1));
		browser = new Browser(parent, SWT.NONE);
		
		// Invisible shell and composite for Drag'n Drop feature
		dndShell = new Shell(Display.getCurrent(), SWT.ON_TOP);
		dndShell.open();
		dndShell.setAlpha(125);
		dndShell.setVisible(false);
		dndComposite = new Composite(dndShell, SWT.NO_BACKGROUND);
		dndComposite.setVisible(false);

		// updates device position on the map
		DeviceLocationManager.getInstance().addDeviceLocationListener(this);

		// swap browserStarted flag to true when browser is ready
		browser.addProgressListener(new BrowserProgressListener());

		// updates dnd elements when browser (more precisely, parent) geometry
		// changes
		parent.addControlListener(new ControlSizePositionListener(parent));

		// drop target configuration
		int operations = DND.DROP_MOVE | DND.DROP_COPY | DND.DROP_DEFAULT;
		Transfer[] transferTypes = new Transfer[] { TextTransfer.getInstance() };
		DropTarget target = new DropTarget(dndComposite, operations);
		target.setTransfer(transferTypes);

		// when a device is dropped, updates its location
		target.addDropListener(new DropListenerForDevices());

		// when the server parameters are updated, the browser URL also
		ServerUpdatedManager.getInstance().addServerUpdatedListener(this);
		serverUpdated(null);
	}

	@PreDestroy
	public void dispose() {
		ServerUpdatedManager.getInstance().removeServerUpdatedListener(this);
	}

	public static void beginDrag() {
		if (browserStarted) {
			dndShell.setVisible(true);
			dndComposite.setVisible(true);
			updateDndInvisibleElementsGeometry();
		}
	}

	public static void endDrag() {
		dndShell.setVisible(false);
		dndComposite.setVisible(false);
	}

	private static void updateDndInvisibleElementsGeometry() {
		Point absolutePos = browser.toDisplay(0, 0);
		dndShell.setBounds(absolutePos.x, absolutePos.y, browser.getBounds().width, browser.getBounds().height);
		dndComposite.setBounds(0, 0, browser.getBounds().width, browser.getBounds().height);
	}

	/* ============== */
	/* DeviceLocation */
	/* ============== */

	@Override
	public void deviceLocationUpdated(final GPScoordinates coordinate, final DeviceDescriptor descriptor) {	
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				String dev = "'" + descriptor.toString() + "'";
				String cmd = "updateDeviceLocation(" + coordinate.getLat() + "," + coordinate.getLng() + "," + dev + ");";
				browser.execute(cmd);
			}
		});	
	}

	@Override
	public void deviceRemoved(final DeviceDescriptor descriptor) {
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				String dev = "'" + descriptor.toString() + "'";
				browser.execute("deleteMarker(" + dev + ");");
			}
		});
	}

	/* =========================== */
	/* Gateway HTTP ServerListener */
	/* =========================== */

	@Override
	public void serverUpdated(UpdateDescriptor descriptor) {
		if (isUpdateNeeded(descriptor)) {
			studioPort = ConfigurationManager.getStudioPort();
			if (studioPort != 0) {
				Display.getDefault().asyncExec(new Runnable() {
					public void run() {
						logger.debug("refresh browser");
						browser.setUrl("http://localhost:" + studioPort + "/webapp/outdoor/static/outdoor.html");
					}
				});
			}
		}
	}

	private boolean isUpdateNeeded(UpdateDescriptor descriptor) {

		if (descriptor == null) {
			// server just started
			return true;
		} else {
			switch (descriptor.getType()) {
			case PORT_UPDATE:
				PortUpdate pu = (PortUpdate) descriptor;
				if (pu.getPort() != 0)
					return true;
				else
					return false;
			case RESOURCE_ADDED:
				ResourceAddedUpdate ra = (ResourceAddedUpdate) descriptor;
				List<String> paths = ra.getRegisteredPath();

				if (! Arrays.asList(Startup.BUNDLE_PATHS).contains(ra.getCurPath()))
					return false;
				
				for (String bundlePath : Startup.BUNDLE_PATHS) {
					if (!paths.contains(bundlePath))
						return false;
				}
				return true;
			default:
				throw new RuntimeException("Should never happend (" + descriptor.getType() + ")");
			}
		}
	}

	/* ================= */
	/* Control listeners */
	/* ================= */

	private final class BrowserProgressListener implements ProgressListener {
		public void changed(ProgressEvent event) {
		}

		public void completed(ProgressEvent event) {
			browserStarted = true;
		}
	}

	private final class ControlSizePositionListener implements ControlListener {
		private final Composite parent;

		private ControlSizePositionListener(Composite parent) {
			this.parent = parent;
		}

		private void update(ControlEvent e) {
			browser.setBounds(0, 0, parent.getBounds().width, parent.getBounds().height);
			if (e.widget instanceof Control) {
				updateDndInvisibleElementsGeometry();
			}
		}

		@Override
		public void controlResized(ControlEvent e) {
			update(e);
		}

		@Override
		public void controlMoved(ControlEvent e) {
			update(e);
		}
	}

	private final class DropListenerForDevices implements DropTargetListener {
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

			endDrag();

			if (TextTransfer.getInstance().isSupportedType(event.currentDataType)) {
				String dropText = (String) event.data;

				if (event.widget instanceof DropTarget) {					
					// Retrieve lat and lng
					Point relativePos = ((DropTarget) event.widget).getControl().toControl(event.x, event.y);
					String cmd1 = "return computeCoordinates(" + relativePos.x + "," + relativePos.y + ");";
					Object[] coordinates = (Object[]) browser.evaluate(cmd1);
					Double lat = (Double) coordinates[0];
					Double lng = (Double) coordinates[1];

					// Retrieve gateway and device
					String[] tab = dropText.split("/");
					String gateway = tab[0];
					if (gateway.startsWith("["))
						gateway = gateway.substring(1);
					String device = tab[1];
					
					// try to update on server
					boolean locationUpdated = DeviceLocationManager.getInstance().updateLocationInServer(new DeviceDescriptor(gateway, device), new GPScoordinates(lat, lng));
					
					if (locationUpdated) {
						String dev = "'" + gateway + "/" + device + "'";
						String cmd = "return updateDeviceLocation(" + lat + "," + lng + "," + dev + ");";
						browser.evaluate(cmd);
					} else {
						Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();						
						MessageDialog.openWarning(shell, "Error", "The location of " + device + " device is NOT updatable");
					}
				}
			}
		}

		@Override
		public void dropAccept(DropTargetEvent event) {
		}
	}
}
