$(document).ready(function(){
	
	if($(".allPirates").length > 0) {
		$(".allPirates").hide();
		
			$.ajax({
				
				url: "http://localhost:8080/RestExample/api/getpirates",
				success: function(data) {
					var table;
					$.each(data.pirates, function(key, value) {
						table += "<tr>";
						table += "<td>"+ value.ID +"</td>";
						table += "<td>"+ value.firstName +"</td>";
						table += "<td>"+ value.lastName +"</td>";
						table += "<td>"+ value.shipName +"</td>";
						table += "<td>"+ value.pirateName +"</td>";
						table += "<td><a href='edit?id="+value.ID+"'<button class='btn btn-danger btn-sm'>Edit</button></td>";
						table += "</tr>";
					});
					$(".allPirates tbody").html(table);
					$('.progress').fadeOut();
					$(".allPirates").fadeIn();	
				},
			});
		}

	
	/*************************************************************
	    	Gets the dollar value of the doubloons entered 
	 *************************************************************/
	$("form").on('click', '#getConversion', function(e) {
		var resultText, input;
		e.preventDefault();
		resultText = $("#conversion");
		input = $("#dtod").val();
		
		// Check to make sure only numbers are used
		if (isNaN(input)) {
			resultText.text("Numbers only.");
		}
		
		// Check to make sure input is not left blank
		else if(input === "" || input === null){
			resultText.text("You must insert a number.");
		}
		
		// Make AJAX call
		else {
			$.ajax({
				url: "http://localhost:8080/RestExample/api/doubloonconvert/json/" + input,
				statusCode: {
				    405: function() {
				    	resultText.text("You must insert a number.");
				    }
				  },
				success: function(data) {
					resultText.text("$" + data.dollar.toFixed(2));
				}
			});
		}
		
	});
});