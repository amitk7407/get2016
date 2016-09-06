//method to show or hide the text using jQuery functions on load of the document
$(document).ready(function() {
					$("#hide").click(function() {
										$("span").hide();		//hides the text
										$('#toggle').val('Show');
			});
					$("#show").click(function() {
										$("span").show();		//shows the text
										$('#toggle').val('Hide');
			});
					$("#toggle").click(function() {
										
										if($('#toggle').val() === "Show") {
											
											$('#toggle').val('Hide');
										} else {
											
											$('#toggle').val('Show');
										}
										$("span").toggle();		//toggles between show and hide on click of button
			});
});