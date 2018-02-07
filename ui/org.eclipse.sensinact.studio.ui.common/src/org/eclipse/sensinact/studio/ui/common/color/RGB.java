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

/**
 * @author Etienne Gandrille
 */
public class RGB {

	public final int r;
	public final int g;
	public final int b;
	
	public RGB(int r, int g, int b) {
		if (r < 0 || r > 255)
			throw new IllegalArgumentException("r should be between 1 and 255");
		if (g < 0 || g > 255)
			throw new IllegalArgumentException("g should be between 1 and 255");
		if (b < 0 || b > 255)
			throw new IllegalArgumentException("b should be between 1 and 255");
		this.r = r;
		this.g = g;
		this.b = b;
	}
	
	@Override
	public String toString() {
		return r + "/" + g + "/" + b;
	}
	
	@Override
	public int hashCode() {
		return toString().hashCode();	
	}
	
	@Override
	public boolean equals(Object obj) {
        if (obj == null)
        	return false;

		if (obj == this)
            return true;
         
        if (obj instanceof RGB) {
        	RGB other = (RGB) obj;
 
            if (this.r != other.r || this.g != other.g || this.b != other.b) {
                return false; 
            }
 
            return true;
        }
        return false;
	}
}
