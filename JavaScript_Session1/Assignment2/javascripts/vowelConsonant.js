function vowelConsonant() {

	var x = document.getElementById("demo");
	var char;
	do {
		char = prompt("Enter a character:");
	
	} while(!isNaN(char) || char.length != 1)
	
	switch(char) {
	
		case "a" :
		case "e" :
		case "i" :
		case "o" :
		case "u" :
		case "A" :
		case "E" :
		case "I" :
		case "O" :
		case "U" :
				x.innerHTML = "<b>"+char+" is a vowel</b>";
				break;
		default :
				x.innerHTML = "<b>"+char+" is a consonant</b>";
				break;
	}
}