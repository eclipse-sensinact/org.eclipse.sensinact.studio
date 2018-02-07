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
package org.eclipse.sensinact.studio.ui.common.color;

import java.util.HashMap;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

/**
 * @author Etienne Gandrille
 */
public class Colors {

	private static Colors INSTANCE = null; 	
	private HashMap<RGB, Color> cache = new HashMap<>();
	
	public final Color RED;
	public final Color GREEN;
	public final Color BLUE;

	private Colors() {
		RED   = getColor(255, 0, 0);
		GREEN = getColor(0, 255, 0);
		BLUE  = getColor(0, 0, 255);
	}
	
	public static Colors getINSTANCE() {
		if (INSTANCE == null)
			INSTANCE = new Colors();
		return INSTANCE;
	}
	
	public Color getColor(int r, int g, int b) {
		return getColor(new RGB(r, g, b));
	}
	
	public Color getColor(RGB rgb) {
		Color color = cache.get(rgb);
		if (color == null) {
			color = new Color(Display.getCurrent(), rgb.r, rgb.g, rgb.b);
			cache.put(rgb, color);
		}
		return color;
	}	
}
