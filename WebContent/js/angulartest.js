(function(){
	var pirateApp = angular.module("pirateApp",[]);
	
	var pirateCtrl = function($scope, $http) {
		$scope.message = "Iuliia";
	
		var complete = function(response) {
			$scope.pirate = response.data;
		}
		
		$http.get("http://localhost:8080/RestExample/api/getpirates")
			.then(complete);
	}
	
	pirateApp.controller("pirateCtrl",pirateCtrl);
}());