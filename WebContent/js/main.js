$(document).ready(function(){
	
//	$("#dtod").keypress(function() {
//		var total, input;
//		total = $("#totalDoubloons").text();
//		input = $("#dtod").val();
//		if(total >= input) {
//			$('#getConversion').prop("disabled", false);
//		} else {
//			$('#getConversion').prop("disabled", true);
//		}
//	});
	
	/*************************************************************
	    	Gets the dollar value of the doubloons entered 
	 *************************************************************/
	$("form").on('click', '#getConversion', function(e) {
		var resultText, input, dtod;
		e.preventDefault();
		dtod = $("#dtod");
		console.log($("form").serialize());
		resultText = $("#conversion");
		input = dtod.val();
		
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
				method: "GET",
				url: "http://localhost:8080/RestExample/api/doubloonconvert/json/" + input,
				statusCode: {
				    405: function() {
				    	resultText.text("You must insert a number.");
				    }
				  },
				success: function(data) {
					var amount = data.dollar.toFixed(2);
					var totalDoubloons = $("#totalDoubloons").text() - input;
					var totalCurrency = parseFloat(amount) + parseFloat($('#totalCurrency').text().replace("$",""));
					$("#totalDoubloons").text(totalDoubloons);
					$('#totalCurrency').text("$" + (totalCurrency));
					dtod.attr("value", amount);
					resultText.text("$" + amount);
					
					$.ajax({
						method: "POST",
						data: {'dtod': totalCurrency, 'totalDoubloons': totalDoubloons},
						url: "http://localhost:8080/RestExample/updatecurrency"
					})
				}
			});

		}
		
	});
	
});