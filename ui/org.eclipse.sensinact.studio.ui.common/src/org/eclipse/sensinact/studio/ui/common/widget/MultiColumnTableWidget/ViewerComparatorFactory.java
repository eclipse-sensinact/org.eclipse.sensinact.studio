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
package org.eclipse.sensinact.studio.ui.common.widget.MultiColumnTableWidget;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;

/**
 * @author Etienne Gandrille
 */
public class ViewerComparatorFactory {

	public static ViewerComparator getAlphanumericalComparator() {
		return new ViewerComparator() {
			@Override
			public int compare(Viewer viewer, Object e1, Object e2) {
				String key1 = ((String[]) e1)[0];				
				String key2 = ((String[]) e2)[0];
				return key1.compareTo(key2);
			}
		};
	}
	
	public static ViewerComparator getFullOrderComparator(final String[] keyList) {
		return new ViewerComparator() {
						
			@Override
			public int compare(Viewer viewer, Object e1, Object e2) {
				String key1 = ((String[]) e1)[0];				
				String key2 = ((String[]) e2)[0];
				return getIndex(key1) - getIndex(key2);
			}
			
			int getIndex(String key) {
				for (int i=0; i<keyList.length; i++)
					if (keyList[i].equals(key))
						return i;
				return -1;
			}
		};
	}
}
