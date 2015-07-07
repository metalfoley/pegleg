(function(){
	var pirateApp = angular.module("pirateApp",[]);
	
	// Get pirates controller
	var pirateCtrl = function($scope, $http, $timeout) {
		$scope.tableHide = true;
		
		var curComplete = function(response) {
			$scope.currency = response.data;
		}
		
		var complete = function(response) {
			$scope.pirates = response.pirates;
			$scope.startFade = true;
			$timeout(function() {
				$scope.tableHide = false;
				$scope.progress = true;
			}, 1500);
		}
		
		var onError = function(reason){
			$scope.error = "Yarr...could not retrieve me matey's!";
		}
		
		$http.get("http://localhost:8080/RestExample/api/getpirates")
			.success(complete)
			.error(onError);
	}

	pirateApp.controller("pirateCtrl",pirateCtrl);
}());