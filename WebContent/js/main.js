$(document).ready(function(){
	
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