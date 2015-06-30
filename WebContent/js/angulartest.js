(function(){
	var pirateApp = angular.module("pirateApp",[]);
	
	// Get pirates controller
	var pirateCtrl = function($scope, $http, $timeout) {
		$scope.tableHide = true;
		
		var complete = function(response) {
			$scope.pirates = response.pirates;
			$scope.startFade = true;
			$timeout(function() {
				$scope.tableHide = false;
				$scope.progress = true;
			}, 1500);
		}
		
		var onError = function(){
			$scope.error = "Yarr...could not retrieve me matey's!";
		}
		
		if(localStorage.getItem("pirates") === null) {
			$http.get("http://localhost:8080/RestExample/api/getpirates")
				.success(complete)
				.error(onError);
		}
	}
	
//	// editController
//	var editCtrl = function ($scope, $http, $location) {
//		$http.get("http://localhost:8080/RestExample/api/getpirate/" + $location.search().id)
//			.success(function(response) {
//				$scope.pirate = response.pirate;
//			});
//	}
//	
	pirateApp.controller("pirateCtrl",pirateCtrl);
	pirateApp.controller("editCtrl",editCtrl);
}());