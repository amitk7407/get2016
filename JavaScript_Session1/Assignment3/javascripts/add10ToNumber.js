function add10ToNumber() {
	
	var demo = document.getElementById("demo");
	var a;
	
	do {
		a = prompt("Please enter a number:");
		
	}while(isNaN(a) || a===null || a==='')
	
	a = parseInt(a);
	demo.innerHTML = "Input number is : "+a+"<br />The number after adding 10 is : "+(a+10);
}