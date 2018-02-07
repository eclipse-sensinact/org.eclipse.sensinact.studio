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
package org.eclipse.sensinact.studio.navigator.device;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.sensinact.studio.view.outdoor.OutdoorDeploymentView;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.ui.navigator.CommonDragAdapterAssistant;

import org.eclipse.sensinact.studio.resource.Device;
import org.eclipse.sensinact.studio.resource.Gateway;
import org.eclipse.sensinact.studio.resource.NamedElement;
import org.eclipse.sensinact.studio.resource.Resource;
import org.eclipse.sensinact.studio.resource.Service;

/**
 * @author Nicolas Hili
 */
public class SensinactDragAdapterAssistant extends CommonDragAdapterAssistant {

	public SensinactDragAdapterAssistant() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.navigator.CommonDragAdapterAssistant#getSupportedTransferTypes
	 * ()
	 */
	@Override
	public Transfer[] getSupportedTransferTypes() {
		Transfer[] transferTypes = new Transfer[] { TextTransfer.getInstance() };
		return transferTypes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.navigator.CommonDragAdapterAssistant#setDragData(org.eclipse
	 * .swt.dnd.DragSourceEvent, org.eclipse.jface.viewers.IStructuredSelection)
	 */
	@Override
	public boolean setDragData(DragSourceEvent event, IStructuredSelection selection) {
		
		// Gateway
		if (selection.getFirstElement() instanceof Gateway) {
			Gateway gateway = (Gateway) selection.getFirstElement();
			if (TextTransfer.getInstance().isSupportedType(event.dataType)) {
				event.data = "["+gateway.getName()+"/]";
			}
			return true;
		}
		
		// Device
		if (selection.getFirstElement() instanceof Device) {
			Device device = (Device) selection.getFirstElement();
			if (TextTransfer.getInstance().isSupportedType(event.dataType)) {
				String gatewayName = ((NamedElement) device.eContainer()).getName();
				event.data = "["+gatewayName + "/" + device.getName()+"/]";
			}
			return true;
		}
		
		// Service
		if (selection.getFirstElement() instanceof Service) {
			Service service = (Service) selection.getFirstElement();
			if (TextTransfer.getInstance().isSupportedType(event.dataType)) {
				String gatewayName = ((NamedElement) service.eContainer().eContainer()).getName();
				String deviceName  = ((NamedElement) service.eContainer()).getName();
				String serviceName = ((NamedElement) service).getName();
				event.data = "["+gatewayName + "/" + deviceName + "/" + serviceName+"/]";
			}
			return true;
		}
		
		// Resource
		if (selection.getFirstElement() instanceof Resource) {
			Resource resource = (Resource) selection.getFirstElement();
			if (TextTransfer.getInstance().isSupportedType(event.dataType)) {
				String gatewayName  = ((NamedElement) resource.eContainer().eContainer().eContainer()).getName();
				String deviceName   = ((NamedElement) resource.eContainer().eContainer()).getName();
				String serviceName  = ((NamedElement) resource.eContainer()).getName();
				String resourceName = ((NamedElement) resource).getName();		
				event.data = "["+gatewayName + "/" + deviceName + "/" + serviceName + "/" + resourceName+"]";
			}
			return true;
		}
		
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.navigator.CommonDragAdapterAssistant#dragStart(org.eclipse
	 * .swt.dnd.DragSourceEvent, org.eclipse.jface.viewers.IStructuredSelection)
	 */
	@Override
	public void dragStart(DragSourceEvent event, IStructuredSelection selection) {
		super.dragStart(event, selection);
		if (selection.getFirstElement() instanceof Device) {
			OutdoorDeploymentView.beginDrag();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.navigator.CommonDragAdapterAssistant#dragFinished(org.
	 * eclipse.swt.dnd.DragSourceEvent,
	 * org.eclipse.jface.viewers.IStructuredSelection)
	 */
	@Override
	public void dragFinished(DragSourceEvent event, IStructuredSelection selection) {
		super.dragFinished(event, selection);
		if (selection.getFirstElement() instanceof Device) {
			OutdoorDeploymentView.endDrag();
		}
	}
}
