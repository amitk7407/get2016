var x = document.getElementById("location");
		
function getlocation() {
		
	if(navigator.geolocation) {
		navigator.geolocation.getCurrentPosition(showPosition, showError);
	} else {
		x.innerHTML = "Geolocation is not supported";
	}	
}

function showPosition(position) {
	x.innerHTML = "Latitude : "+position.coords.latitude+"<br />Longitude : "+position.coords.longitude;
	
	var latlon = position.coords.latitude+","+position.coords.longitude;
	var img_url = "https://maps.googleapis.com/maps/api/staticmap?center="+latlon+"&zoom=14&size=800x600&sensor=false";
	document.getElementById("mapholder").innerHTML = "<img src='"+img_url+"'>";
}

function showError(error) {
	switch(error.code) {
		case error.PERMISSION_DENIED :
			x.innerHTML = "User denied the request for Geolocation";
			break;
		case error.POSITION_UNAVAILABLE :
			x.innerHTML = "Location information is unavailable";
			break;
		case error.TIMEOUT :
			x.innerHTML = "The request to get user location timed out";
			break;
		case error.UNKNOWN_ERROR :
			x.innerHTML = "An unknown error occurred";
			break;
	}
}