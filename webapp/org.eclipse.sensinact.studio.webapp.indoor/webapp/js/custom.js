/*
 * Copyright (c) 2018 CEA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *     CEA - initial API and implementation and/or initial documentation
 */
var map = L.map('map').setView([43.464304, -3.810365], 15);

L.tileLayer('http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
	attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
}).addTo(map);

function onMapClick(e) {
   var marker = L.marker([43.464304, -3.810365]).bindPopup("<b>Hello world!</b><br>I am a popup.").addTo(map);
}


map.on('click', onMapClick);
