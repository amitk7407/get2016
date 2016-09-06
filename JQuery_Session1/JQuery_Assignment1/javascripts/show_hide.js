//method to hide the text on click of a button
function hide() {
	
	var toggle = document.getElementById("toggle");
	var text = document.getElementById("text");
	text.style.display = "none";		//hides the text
	toggle.value = "Show";
}

//method to show the text on click of a button
function show() {
	
	var toggle = document.getElementById("toggle");
	var text = document.getElementById("text");
	text.style.display = "inline";		//shows the text in inline arrangement
	toggle.value = "Hide";
}

//method to show or hide the text on click of a button
function toggle() {
	
	var text = document.getElementById("text");
	var toggle = document.getElementById("toggle");
	if(toggle.value === "Hide") {
		
		text.style.display = "none";		//hides the text if hide button is clicked
		toggle.value = "Show";
	}
	else if(toggle.value === "Show") {
	
		text.style.display = "inline";		//shows the text in inline arrangement if show button is clicked
		toggle.value = "Hide";
	}
}