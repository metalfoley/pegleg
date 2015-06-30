(function() {
	var pirateApp = angular.module("pirateApp",[]);
	
	var editCtrl = function ($scope, $http, $location) {
		$http.get("http://localhost:8080/RestExample/api/getpirate" + $location.search().id)
			.success(function(response) {
				$scope.pirate = response.pirate;
			});
	}
	
	pirateApp.controller("editCtrl",editCtrl);
});