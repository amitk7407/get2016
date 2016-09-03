function radioDropdownCombinations() {

	var group = document.getElementsByName("group");
	var para = document.getElementById("para");
	var result;
	
	for(var i = 0 ; i < group.length ; i++) {

		if(group[i].checked){
		
			var value = document.getElementsByTagName("select");
			result = value[i].options[value[i].selectedIndex].value;
			para.innerHTML = ""+result;
		}
	}
}