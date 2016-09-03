function greatestAmongThreeNumbersWithParameterizedFunction() {

	var demo = document.getElementById("demo");
	var a, b, c;
	
	do {
		a = prompt("Enter the value of A (Integers only):");
		
	}while(isNaN(a) || a===null || a==='')

	do {
		b = prompt("Enter the value of B (Integers only):");
		
	}while(isNaN(b) || b===null || b==='')
		
	do {
		c = prompt("Enter the value of C (Integers only):");
		
	}while(isNaN(c) || c===null || c==='')
	
	a = parseFloat(a);
	b = parseFloat(b);
	c = parseFloat(c);

	parameterizedFunction(a, b, c);
}
	
function parameterizedFunction() {
	
	var a = arguments[0];
	var b = arguments[1];
	var c = arguments[2];
	if (a>b && a>c) {
			
		demo.innerHTML = "A = "+a+"<br />B = "+b+"<br />C = "+c+"<br /><b>A is greatest</b>";	
	} else if (b>a && b>c) {
		
		demo.innerHTML = "A = "+a+"<br />B = "+b+"<br />C = "+c+"<br /><b>B is greatest</b>";
	} else if (c>a && c>b) {
		
		demo.innerHTML = "A = "+a+"<br />B = "+b+"<br />C = "+c+"<br /><b>C is greatest</b>";
	} else {
		
		demo.innerHTML = "A = "+a+"<br />B = "+b+"<br />C = "+c+"<br /><b>All are equal.</b>";
	}
}