//calls the functions on load of the document
$(document).ready(question1);
$(document).ready(question2);
$(document).ready(question3);
$(document).ready(question4);
$(document).ready(question5);
$(document).ready(question6);
$(document).ready(question7);
$(document).ready(question8);
$(document).ready(question9);
$(document).ready(question10);

//method to select all SPAN with class name: “message”
function question1(){
	$('#button1').click(function () {
		$("span.message").css("fontSize", "25px");
	});
}

//method to selects first DIV in a document that has class: “box”
function question2(){
	$('#button2').click(function () {
		$("div.box:first").css("background", "green");
	});
}

//method to selects all BUTTONS in a document
function question3(){
	$('#button3').click(function () {
		$(":button").css("color", "blue");
	});
}

//method to selects all IMAGES having alternate text as: “hello”
function question4(){
	$('#button4').click(function () {
		$("img[alt='hello']").css("width", "200px");
	});
}

//method to selects all TEXT BOXES under a div having Id = “myDiv”
function question5(){
	$('#button5').click(function () {
		$("#myDiv").find("input[type='text']").css("background", "orange");
	});
}

//method to selects all TEXT BOXES with name starting by: “txt”
function question6(){
	$('#button6').click(function () {
		$("input[name^='txt']" ).css("background", "yellow");
	});
}

//method to selects all PARAGRAPHS element, not having class “box”
function question7(){
	$('#button7').click(function () {
		$("p").not(".box").css("background", "red");
	});
}

//method to selects all the DIVS having either “box” or “error” class
function question8(){
	$('#button8').click(function () {
		$(".box, .error" ).css("background", "lime");
	});
}

//method to selects all the DIVS having both “box” and “error” class
function question9(){
	$('#button9').click(function () {
		$(".box.error" ).css("background", "pink");
	});
}

//method to find all the SPAN having “info” class in a DIV with id = “myDiv”
function question10(){
	$('#button10').click(function () {
		$("div#myDiv span.info" ).css("color", "red");
	});
}