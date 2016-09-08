//calls the functions on load of the document
$(document).ready(setHello);

//method to set text of label with class hello to "Hello World!"
function setHello(){
	
	$("label.hello").text("Hello world!");
}