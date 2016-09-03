function chartDisplay() {
	
	var demo = document.getElementById("demo");
	var a;
	var arr = new Array();
	
	do {
		a = prompt("Enter the number of elements of the array. (Integers only):");
		
	}while(isNaN(a) || a===null || a==='')
		
	a = parseInt(a);
	for(var index = 0 ; index < a ; index++) {
		
		var temp;
		do {
			temp = prompt("Enter the element "+(index+1)+" of array. (Integers only):");
		
		}while(isNaN(temp) || temp===null || temp==='')
			
		temp = parseInt(temp);
		arr.push(temp);
	}
	
	var largest = 0;
	
	for(var index = 0 ; index < arr.length ; index++) {
		
		if(largest < arr[index]) {
			
			largest = arr[index];
		}
	}
	
	var str = "";
	
	for(var rowIndex = largest ; rowIndex > 0 ; rowIndex--) {
		
		for(var columnIndex = 0 ; columnIndex < arr.length ; columnIndex++) {
			
			if(arr[columnIndex] >= rowIndex) {
				
				str = str+"*&nbsp;&nbsp;";

			} else {
				
				str = str+"&nbsp;&nbsp;&nbsp;&nbsp;"
			}
		}
		str = str+"<br />";
	}
	
	for(var index = 0 ; index < arr.length ; index++) {
		
		str = str + "" + String.fromCharCode(index+65) + "&nbsp;";
	}
	demo.innerHTML = ""+str;
}