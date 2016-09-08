//calls the functions on load of the document
$(document).ready(printEmployeeData);

//method to print employee details
function printEmployeeData() {

	//runs on the change in the value of the dropdown options
	$("select#employee").change(function() {

		var employee  = $("select#employee").val().trim();
		//checks for the default value of the dropdown menu
		if(employee != "default") {
			
			//ajax to load employee details dynamically
			$.ajax({
			
				url: "assignment2.json",
				dataType: "text",
				//function to run on ajax file loading
				success: function(data) {
					
					//parsing of JSON file
					var json = $.parseJSON(data);
					
					//loop to find the employee details from the JSON file
					$.each(json, function(index) {

						if(json[index].firstName+" "+json[index].lastName === employee) {
							
							$("#result").html("<br />Name : "+json[index].firstName+" "+json[index].lastName+"<br />Email : "+json[index].email+"<br />D.O.B. : "+json[index].dob+"<br />Address : "+json[index].address.streetAddress+", "+json[index].address.city+", "+json[index].address.state+", "+json[index].address.postalCode+"<br />");
						}
					});
				},
				//reuns when error comes
				error: function() {
				
					alert("error");
				}
			});
		} else {
			
			$("#result").html("");
		}
	});
}