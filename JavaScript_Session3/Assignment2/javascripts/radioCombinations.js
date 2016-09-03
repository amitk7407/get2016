function radioCombinations() {

	var grp1 = document.getElementsByName("group1");
	var grp2 = document.getElementsByName("group2");
	var para = document.getElementById("para");
	var i = 0;
	var j = 0;
	
	for(i = 0 ; i < grp1.length ; i++) {
	
		if(grp1[i].checked){
	
			break;
		}
	}

	for(j = 0 ; j < grp2.length ; j++) {
	
		if(grp2[j].checked){
			
			break;
		}
	}
	
		para.innerHTML = grp1[i].value + " " + grp2[j].value;
}