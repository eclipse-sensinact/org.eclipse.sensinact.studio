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


// For debug purpose, for the eclipse webview...
function toStr(obj) {
  var output="";
  for(var i in obj) {
    var v = obj[i];
    output += i + ":" + v + "\n"
  }
  return output;
}

var init = eval('(' + synchronusGET("/webapp/outdoor/init") + ')');

var map = L.map('map',{maxZoom:23}).setView([init.lat, init.lng], init.zoom);
L.tileLayer('http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
	maxZoom: 23,attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors - <a href="#" onclick="window.location.reload()">reload</a>'
}).addTo(map);


var icons = {};

var defaultIcon = L.icon({
    iconUrl: 'css/images/marker-icon.png',
    iconSize: [25, 41],
    iconAnchor: [13, 41],
    popupAnchor: [0, -40],
    shadowUrl: 'css/images/marker-shadow.png',
    shadowSize: [41, 41],
    shadowAnchor: [13, 41]
});
icons['default']=defaultIcon;

var busStopIcon = L.icon({
    iconUrl: 'css/images/bus-icon.png',
    iconSize: [39, 39],
    iconAnchor: [20, 41],
    popupAnchor: [0, -40],
    shadowUrl: 'css/images/marker-shadow.png',
    shadowSize: [41, 41],
    shadowAnchor: [20, 41]
});
icons['busStop']=busStopIcon;


imageBounds4022 = [[45.19317,5.70630],[45.19350,5.70675]];
imageBoundsPTL = [[45.19591,5.70564],[45.19555,5.70617]];
var bat4022=L.imageOverlay('/webapp/outdoor/static/images/cea4022etage2.png', imageBounds4022);
var batPTL=L.imageOverlay('/webapp/outdoor/static/images/ceaptl.png', imageBoundsPTL);
bat4022.addTo(map);
bat4022.setOpacity(0.0);
batPTL.addTo(map);
batPTL.setOpacity(0.0);
map.on('zoomend', function(e) {
    console.log(e.target._zoom);
  if(e.target._zoom >= 20) {
	bat4022.setOpacity(0.5);
	batPTL.setOpacity(0.5);
  }else {
	bat4022.setOpacity(0.0);
	batPTL.setOpacity(0.0);
  }
});


var markers = {};

function synchronusGET(url){
    return $.ajax({
        type: "GET",
        url: url,
        cache: false,
        async: false
    }).responseText;
}

function computeCoordinates(x, y) {
    var point = L.point(x, y);
    var latlng = map.containerPointToLatLng(point);
    var lat = latlng.lat;
    var lng = latlng.lng;
    var latlngArray = new Array();
    latlngArray[0] = lat;
    latlngArray[1] = lng;
    return latlngArray;
}

function updateDeviceLocation(lat, lng, deviceName, iconName) {

	var markerCache = markers[deviceName]; 

    if (markerCache === undefined) {
        var iconObject = getIcon(deviceName, iconName)
		var content = "<p><b>" + deviceName + "</b></p><p> please wait during information refresh...</p>";
		var marker = L.marker([lat, lng], {draggable:true, title:deviceName, icon:iconObject}).bindPopup(content,{maxWidth:600}).addTo(map);
		marker.on('dragend', markerDrag);
		marker.on('click',function(e) {updatePopupAtInit(e,deviceName);} );
		markers[deviceName] = marker;
    } else {
    	markerCache.setLatLng(new L.latLng(lat, lng));
    	markerCache.update();
    }
    return Boolean("true");
}

function getIcon(deviceName, iconName) {
   // if (icons[iconName] !== undefined) iconObject=icons['iconName'];
   if (deviceName.startsWith('SEM_'))
     return icons['busStop'];
   else
     return icons['default'];         
}

function deleteMarker(deviceName) {
    var marker = markers[deviceName]; 
    if (marker != undefined) {
      map.removeLayer(marker);
      markers[deviceName] = undefined;
    }
    return Boolean("true");
}


function markerDrag(e) {
  var text = e.target._popup._content;
  var latlng = e.target._latlng;  
  var deviceName = e.target.options.title;
    
  var marker = markers[deviceName];

  $.ajax
  ({
      contentType : 'application/json',
      type: "POST",
      url: "/webapp/updatelocation/" + deviceName,
      async: false,
      data: JSON.stringify({"lat": latlng.lat, "lng": latlng.lng }),
      error : function(resultat, statut, erreur) {
          var oldLatLng = JSON.parse(resultat.responseText);
          var oldLat = oldLatLng.lat;
          var oldLng = oldLatLng.lng;
          updateDeviceLocation(oldLat, oldLng, deviceName);
          alert("The location of " + deviceName + " device is not updatable");
      }
  });
  
}

function updatePopupAtInit(e, deviceName) {
  updatePopup(markers[deviceName].getPopup(), deviceName);
}

function updatePopupOnClick(deviceName) {
  var popup = markers[deviceName].getPopup();
  updatePopup(popup, deviceName);
}

function updatePopup(popup, deviceName) {
  $.get("/webapp/deviceinfo/" + deviceName, function(data) {
    popup.setContent(data);
    popup.update();
  });
}

function updatePopupOnClick(deviceName, serviceName) {
   $.get("/webapp/deviceinfo/" + deviceName + "/" + serviceName, function(data) {
    markers[deviceName].closePopup();
    markers[deviceName].setPopupContent(data);
    markers[deviceName].getPopup().update();
    markers[deviceName].openPopup();
  });
}

function performAction(gatewayName, deviceName, serviceName, resourceName) {
  $.get("/webapp/performAction/" + gatewayName + "/" + deviceName + "/" + serviceName + "/" + resourceName, function(data) {
    var result = JSON.parse(data);
    var title = result.title
    var message = result.message;
    var status = result.status;
    
	if (status != "SUCCESS") {    
    	var msg = '[' + status + ']' + ' ' + title + '\n\n' + message;
    	alert(msg);
    } else {
      document.getElementById("notif").style.visibility = "visible";
      window.setTimeout(function() {document.getElementById("notif").style.visibility = "hidden";}, 1000);
    }
  });
}

function showImage(imageUrl) {
  var content = '<a href="#" onclick="closeImage();"><img src="' + imageUrl + '" /></a>';
  document.getElementById("image").innerHTML = content;
  document.getElementById("image").style.visibility = "visible";
}

function closeImage(imageUrl) {
  document.getElementById("image").style.visibility = "hidden";
}
