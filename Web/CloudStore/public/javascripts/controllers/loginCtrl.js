angular.module("cloudView")
.controller("loginCtrl",['$scope','$window','loginService',function($scope,$window,loginService){
	$scope.login = function(user){
		var u = loginService.login(user);
		u.$promise.then(function (res) {
			if(res.id == undefined || res.id==0) $window.location.href= "#/login";
			else $window.location.href= "#/index";
		}
		)
	}
}]);