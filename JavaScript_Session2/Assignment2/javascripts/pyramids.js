function pyramids() {
		
	var a;
	
	do {
		a = prompt("Enter the length of the pyramid (Integers only):");
		
	}while(isNaN(a) || a===null || a==='')
		
	a = parseInt(a);
	pyramidByForLoop(a);
	pyramidByWhileLoop(a);
	pyramidByDoWhileLoop(a);
}

function pyramidByForLoop() {
	
	var forLoop = document.getElementById("forLoop");
	var count = arguments[0];
	var str = "";
	
	for(var index = 0 ; index < count ; index++) {
		
		for(var space = (count-1) ; space > index ; space--) {
			
			str = str + "&nbsp;&nbsp;";
		}
		
		for(var star = 0 ; star < (index*2)+1 ; star++) {
			
			str = str + "*";
		}
		
		str = str + "<br />";
	}
	
	forLoop.innerHTML = ""+str;
}

function pyramidByWhileLoop() {
	
	var whileLoop = document.getElementById("whileLoop");
	var count = arguments[0];
	var str = "";
	var index = 0;
	
	while(index < count) {
		
		var space = (count-1);
		while(space > index) {
			
			str = str + "&nbsp;&nbsp;";
			space--;
		}
		
		var star = 0;
		while(star < (index*2)+1) {
			
			str = str + "*";
			star++;
		}
		
		str = str + "<br />";
		index++;
	}
	
	whileLoop.innerHTML = ""+str;
}

function pyramidByDoWhileLoop() {
	
	var doWhileLoop = document.getElementById("doWhileLoop");
	var count = arguments[0];
	var str = "";
	var index = 0;
	
	if(count > 0) {

		do {
			var space = (count-1);
			
			if(space !== index) {
				
				do {
					str = str + "&nbsp;&nbsp;";
					space--;
				
				}while(space > index)
			}
		
			var star = 0;
			
			do {
				str = str + "*";
				star++;
				
			}while(star < (index*2)+1)
		
			str = str + "<br />";
			index++;
			
		}while(index < count)
	}
	
	doWhileLoop.innerHTML = ""+str;
}