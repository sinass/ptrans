angular.module("cloudView")
.controller("loginCtrl",['$scope','$location','$cookieStore','$rootScope','loginService','visor',function($scope,$location,$cookieStore,$rootScope,loginService,visor){
	$scope.login = function(user){
		var u = loginService.login(user);
		u.$promise.then(function (res) {
			$cookieStore.put("user",res);
			$rootScope.user = res;
			visor.setAuthenticated(res);
			switch (res.type){
			case "veterinary": 
				/*$scope.data = {
					animal:
			};*/
				break;
			case "owner": break;
			case "user": break;
			}
			$location.url("/index");
			
			/*if(res.id == undefined || res.id==0) $window.location.href= "#/login";
			else $window.location.href= "#/index";*/
		}
		)
	}
}]);