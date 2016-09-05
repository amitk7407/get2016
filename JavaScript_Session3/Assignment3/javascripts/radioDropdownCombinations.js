function radioDropdownCombinations() {

	var group = document.getElementsByName("group");
	var msg = document.getElementById("msg");
	var result;
	
	for(var i = 0 ; i < group.length ; i++) {

		if(group[i].checked){
		
			var value = document.getElementsByTagName("select");
			result = value[i].options[value[i].selectedIndex].value;
			msg.innerHTML = ""+result;
		}
	}
}