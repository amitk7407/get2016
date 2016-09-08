//calls the function on load of the document
$(document).ready(keyPress);

//method to call the methods to change color when a key is pressed
function keyPress() {
	
	$(".input#name").keyup(changeColorForNameField);
	$(".input#age").keyup(validateAge);
	$(".input#address").keyup(changeColorForAddressField);
}	

//method to change the color for a time period
function changeColor(inputTag) {
	
	inputTag.css("background", "pink");
	setTimeout(function() {
		
		inputTag.css("background", "white");
	}, 100);
}

//method to change color for name input tag and print the changed value
function changeColorForNameField() {
	
	var name = $(".input#name");
	var currentValue = "";
	currentValue = name.val();
	if(currentValue != "") {
		
		changeColor(name);
		$(".result #updatedName").html("Name: "+currentValue);
	} else {
		
		$("div #updatedName").html("");
	}
}

//method to change color for age input tag and print the changed value
function changeColorForAgeField() {
	
	var age = $(".input#age");
	var currentValue = "";
	currentValue = age.val();
	if(currentValue != "") {
		
		changeColor(age);
		$(".result #updatedAge").text("Age: "+currentValue);
	} else {
		
		$(".result #updatedAge").html("");
	}
}

//method to change color for address input tag and print the changed value
function changeColorForAddressField() {
	
	var address = $(".input#address");
	var currentValue = "";
	currentValue = address.val();
	if(currentValue != "") {
		
		changeColor(address);
		$(".result #updatedAddress").html("Address: "+currentValue);
	} else {
		
		$(".result #updatedAddress").html("");
	}
}

//method to validate age and call change color on correct input
function validateAge() {
	
	var value = $(".input#age").val();
	
	if(value>=0 && value<150) {
	
	} else {
	
		$(".input#age").css("borderColor", "red")
		$(".input#age").val("");
	}
	changeColorForAgeField();
}