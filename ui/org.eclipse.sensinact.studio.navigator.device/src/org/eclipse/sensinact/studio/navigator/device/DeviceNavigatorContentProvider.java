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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.sensinact.studio.model.manager.modelupdater.ModelEditor;
import org.eclipse.sensinact.studio.model.manager.modelupdater.ModelUpdater;
import org.eclipse.sensinact.studio.navigator.device.filter.SensinactTreeViewer;
import org.eclipse.sensinact.studio.resource.Device;
import org.eclipse.sensinact.studio.resource.Gateway;
import org.eclipse.sensinact.studio.resource.Resource;
import org.eclipse.sensinact.studio.resource.Service;
import org.eclipse.sensinact.studio.resource.Studio;
import org.eclipse.sensinact.studio.resource.impl.DeviceImpl;
import org.eclipse.sensinact.studio.resource.impl.GatewayImpl;

/**
 * @author Nicolas Hili, Etienne Gandrille
 *
 */
public class DeviceNavigatorContentProvider implements ITreeContentProvider {

	protected SensinactTreeViewer viewer;
	
	public DeviceNavigatorContentProvider() {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	@Override
	public void dispose() {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		this.viewer=(SensinactTreeViewer)viewer;
		this.viewer.setLabelProvider(new DeviceNavigatorLabelProvider());
	}
	

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getElements(java.lang.Object)
	 */
	@Override
	public Object[] getElements(Object inputElement) {
		return getChildren(inputElement);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
	 */
	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof Studio) {
			return ((Studio) parentElement).getGateways().toArray();
		} else if (parentElement instanceof Gateway) {
			return ((Gateway) parentElement).getDevice().toArray();	
		} else if (parentElement instanceof Device) {
			try {
				DeviceImpl device=(DeviceImpl)parentElement;
				GatewayImpl gateway=(GatewayImpl)device.eContainer();
				if(ModelEditor.getInstance().getServicesId(gateway.getName(),device.getName()).size()==0){
					ModelUpdater.getInstance().updateServices(gateway.getName(),device.getName(), true);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return ((Device) parentElement).getService().toArray();
		} else if (parentElement instanceof Service) {
			return ((Service) parentElement).getResource().toArray();
		} 
		
		return new Object[0];
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
	 */
	@Override
	public Object getParent(Object element) {
		return ((EObject) element).eContainer();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
	 */
	@Override
	public boolean hasChildren(Object element) {
		EObject eobject=(EObject)element;
		if(element instanceof Device){
			return true;
		}else if(element instanceof Resource){
			return false;
		}
		return eobject.eContents().size()>0;
	}
}
