//calls the functions on load of the document
$(document).ready(question1);
$(document).ready(question2);
$(document).ready(question3);
$(document).ready(question4);
$(document).ready(question5);
$(document).ready(question6);
$(document).ready(question7);
$(document).ready(question8);

//method to print all siblings of span tag
function question1() {
	
	$("#button1").click(function() {
		$("#div1 h4").siblings().css({"border": "solid red 1px", "color": "red"})
	});
}

//method to print a sibling of span tag with specified tag p
function question2() {
	
	$("#button2").click(function() {
		$("#div2 h4").siblings("p").css({"border": "solid red 1px", "color": "red"})
	});
}

//method to print next sibling of span tag
function question3() {
	
	$("#button3").click(function() {
		$("#div3 h4").next().css({"border": "solid red 1px", "color": "red"})
	});
}

//method to print all next siblings of span tag
function question4() {
	
	$("#button4").click(function() {
		$("#div4 h4").nextAll().css({"border": "solid red 1px", "color": "red"})
	});
}

//method to print all siblings of span tag between span tag ang h6 tag
function question5() {
	
	$("#button5").click(function() {
		$("#div5 h4").nextUntil("h6").css({"border": "solid red 1px", "color": "red"})
	});
}

//method to print previous sibling of span tag
function question6() {
	
	$("#button6").click(function() {
		$("#div6 h4").prev().css({"border": "solid red 1px", "color": "red"})
	});
}

//method to print all previous siblings of span tag
function question7() {
	
	$("#button7").click(function() {
		$("#div7 h4").prevAll().css({"border": "solid red 1px", "color": "red"})
	});
}

//method to print all siblings of span tag between h2 tag and span tag
function question8() {
	
	$("#button8").click(function() {
		$("#div8 h4").prevUntil("h2").css({"border": "solid red 1px", "color": "red"})
	});
}