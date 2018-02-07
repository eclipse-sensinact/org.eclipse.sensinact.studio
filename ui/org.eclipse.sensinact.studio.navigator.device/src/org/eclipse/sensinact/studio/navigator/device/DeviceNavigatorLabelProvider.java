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

import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.sensinact.studio.ui.common.images.StudioImage;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.IDescriptionProvider;

import org.eclipse.sensinact.studio.resource.Action;
import org.eclipse.sensinact.studio.resource.Device;
import org.eclipse.sensinact.studio.resource.Gateway;
import org.eclipse.sensinact.studio.resource.Property;
import org.eclipse.sensinact.studio.resource.Resource;
import org.eclipse.sensinact.studio.resource.SensorData;
import org.eclipse.sensinact.studio.resource.Service;
import org.eclipse.sensinact.studio.resource.StateVariable;
import org.eclipse.sensinact.studio.resource.Studio;

/**
 * @author Nicolas Hili, Etienne Gandrille
 *
 */
public class DeviceNavigatorLabelProvider extends LabelProvider implements ILabelProvider, IDescriptionProvider,IBaseLabelProvider {

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object element) {
		
		if (element instanceof Studio) {
			return getText((Studio) element);
		} else if (element instanceof Gateway) {
			return getText((Gateway) element);
		} else if (element instanceof Device) {
			return getText((Device) element);
		} else if (element instanceof Service) {
			return getText((Service) element);
		} else if (element instanceof Resource) {
			return getText((Resource) element);
		}
		return null;
	}
	
	public String getText(Studio studio) {
		return "Root";
	}
	
	public String getText(Gateway gateway) {
		return gateway.getName();
	}
	
	public String getText(Device device) {	
		if (device.getService().size() == 0) {
			return device.getName();// + " [loading...]";
		}
		
		return device.getName();
	}
	
	public String getText(Service service) {
		if (service.getResource().size() == 0) {
			return service.getName();// + " [loading...]";
		}
		return service.getName();
	}
	
	public String getText(Resource resource) {
		return resource.getName();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.LabelProvider#getImage(java.lang.Object)
	 */
	@Override
	public Image getImage(Object element) {
		
		if (element instanceof Studio) {
			return getImage((Studio) element);
		} else if (element instanceof Gateway) {
			return getImage((Gateway) element);
		} else if (element instanceof Device) {
			return getImage((Device)element);
        } else if (element instanceof Service) {
        	return getImage((Service)element);
        } else if (element instanceof Resource) {
        	return getImage((Resource)element);
        }
        return null;
	}
	
	public Image getImage(Studio studio) {
		return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FOLDER);
	}
	
	public Image getImage(Gateway gateway) {
		return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT);
	}
	
	public Image getImage(Device device) {
		//if (device.getService().size() == 0) {
		//	return StudioImage.LOAD.getImage();
		//}
		return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FOLDER);
	}
	
	public Image getImage(Service service) {
		if (service.getResource().size() == 0) {
			return StudioImage.LOAD.getImage();
		}
        return PlatformUI.getWorkbench().getSharedImages()
                .getImage(ISharedImages.IMG_OBJ_FILE);
	}
	
	public Image getImage(Resource resource) {
		
		String img = ISharedImages.IMG_OBJ_ADD;
		
		if (resource instanceof StateVariable) {
			img = ISharedImages.IMG_OBJS_INFO_TSK;
		} else if (resource instanceof Action) {
			img = ISharedImages.IMG_OBJ_ADD;
		} else if (resource instanceof Property) {
			img = ISharedImages.IMG_LCL_LINKTO_HELP;
		} else if (resource instanceof SensorData) {
			img = ISharedImages.IMG_ETOOL_HOME_NAV;
		}
        return PlatformUI.getWorkbench().getSharedImages()
                .getImage(img);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.navigator.IDescriptionProvider#getDescription(java.lang.Object)
	 */
	@Override
	public String getDescription(Object element) {
		String text = getText(element);
        return "This is a description of " + text;
	}
}
