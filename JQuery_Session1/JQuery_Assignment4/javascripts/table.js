//color table with different background color for alternate rows on load of the document
$(document).ready(function() {
	
	$("tr:even").css("backgroundColor","pink");		//color even rows
	$("tr:odd").css("backgroundColor","orange");		//color odd rows
});