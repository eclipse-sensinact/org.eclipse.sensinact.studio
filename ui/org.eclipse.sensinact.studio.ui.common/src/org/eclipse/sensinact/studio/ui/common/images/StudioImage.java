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
package org.eclipse.sensinact.studio.ui.common.images;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * @author Etienne Gandrille
 */
public enum StudioImage {

	OK("images/greenCheck-wikipedia.png"), LOAD("images/loader.gif"), LOCK("images/lock.gif");
	
	private final Image image;
	
	private StudioImage(String path) {
		Bundle bundle = FrameworkUtil.getBundle(this.getClass());
		URL url = FileLocator.find(bundle, new Path(path), null);
		ImageDescriptor imageDescriptor = ImageDescriptor.createFromURL(url);
		image = imageDescriptor.createImage();		
	}
	
	public Image getImage() {
		return image;
	}
}
