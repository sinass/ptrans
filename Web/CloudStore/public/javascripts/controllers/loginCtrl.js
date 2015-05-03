angular.module("cloudView")
.controller("loginCtrl",['$scope','$window','loginService',function($scope,$window,loginService){
	$scope.login = function(user){
		var loginStatus = loginService.login(user);
		if(loginStatus==true) $window.location.href= "#/index";
		else $window.location.href= "#/login";
		console.log(loginStatus);
	}
}]);