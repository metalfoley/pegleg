$(document).ready(function(){
	
	/*************************************************************
	    	Gets the dollar value of the doubloons entered 
	 *************************************************************/
	$("form").on('click', '#getConversion', function(e) {
		var resultText, input, dtod, doubloons;
		e.preventDefault();
		doubloons = $("#totalDoubloons").text();
		dtod = $("#dtod");
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
		
		else if(input.toString().indexOf(".") != -1) {
			resultText.text("You must insert a whole number.");
		}
		
		else if(parseInt(input) > parseInt(doubloons) || doubloons <= 0) {
			resultText.text("You don't have enough doubloons. You must add " + Math.abs(input - doubloons) + " more");
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
					var totalDoubloons = doubloons - input;
					var totalCurrency = parseFloat(amount) + parseFloat($('#totalCurrency').text().replace("$",""));
					$("#totalDoubloons").text(totalDoubloons);
					$('#totalCurrency').text("$" + totalCurrency.toFixed(2));
					dtod.attr("value", amount);
					resultText.text("$" + amount);
					
					updateCurrency(totalCurrency, totalDoubloons);
				}
			});

		}
		
		function updateCurrency(totalCurrency, totalDoubloons) {
			$.ajax({
				method: "POST",
				data: {'dtod': totalCurrency, 'totalDoubloons': totalDoubloons},
				url: "http://localhost:8080/RestExample/updatecurrency"
			})
		}
		
		
	});
	
});