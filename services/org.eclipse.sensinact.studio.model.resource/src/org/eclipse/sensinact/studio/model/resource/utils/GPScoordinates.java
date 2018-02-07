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
package org.eclipse.sensinact.studio.model.resource.utils;

import javax.naming.directory.InvalidAttributesException;

/**
 * @author Etienne Gandrille
 */
public class GPScoordinates {

	private final double lat;
	private final double lng;
	
	public GPScoordinates(double lat, double lng) {
		this.lat = lat;
		this.lng = lng;
	}
	
	/**
	 * 
	 * @param coords expected format is two flots separated by a ','. ie "3.1245,4.365212"
	 * @throws InvalidAttributesException 
	 */
	public GPScoordinates(String coords) throws InvalidAttributesException {
		try {
			coords = coords.replace(':', ',');
			final String[] coordinates = coords.split(",");
			lat = Double.valueOf(coordinates[0].trim());
			lng = Double.valueOf(coordinates[1].trim());
		} catch (Exception e) {
			throw new InvalidAttributesException("Can't convert " + coords + " into gps coordinates");
		}
	}
	
	public double getLat() {
		return lat;
	}
	
	public double getLng() {
		return lng;
	}
	
	@Override
	public String toString() {
		return "[" + lat + "," + lng + "]";
	}
	
	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (!(other instanceof GPScoordinates))
			return false;
		final GPScoordinates that = (GPScoordinates) other;
		return this.getLat() == that.getLat() && this.getLng() == that.getLng();
	}

	public int hashCode() {
		// basic hash, only with lat
		return new Double(lat).hashCode();
	}	
}
