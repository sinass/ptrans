angular.module("cloudView")
.config(['$routeProvider','visorProvider',
  function($routeProvider,visorProvider,$cookieStore,$q,$rootScope) {
	
	visorProvider.authenticate = function($cookieStore,$q,$rootScope){
		var user = $cookieStore.get("user");
		if (user) {
			$rootScope.user = user;
			return $q.when(user);
		} else {
			return $q.reject(null);
		}
	};
	
	visorProvider.doOnNotAuthorized = function($location,restrictedUrl){
		$location.url("/access_denied?prevUrl=" + encodeURIComponent(restrictedUrl));
	};
	
	
    $routeProvider.
      when('/login', {
        templateUrl: '/assets/javascripts/views/login.html',
        controller: 'loginCtrl'
        /*restrict:function(user){return user === undefined;}*/
      }).
      when('/index', {
        templateUrl: '/assets/javascripts/views/index.html',
        controller: 'cloudViewCtrl',
        restrict:function(user){
        	console.log(user);
        	return user && user.id!=undefined && user.id!=0 && user.id!=null;
        	}
      }).
      when('/codiagnostics', {
    	  templateUrl: '/assets/javascripts/views/index.html',
          controller: 'cloudViewCtrl',
          restrict:function(user){
          	console.log(user);
          	return user && user.id!=undefined && user.id!=0 && user.id!=null;
          	}
        }).
      when('/sharedwithme', {
    	  templateUrl: '/assets/javascripts/views/index.html',
          controller: 'cloudViewCtrl',
          restrict:function(user){
          	console.log(user);
          	return user && user.id!=undefined && user.id!=0 && user.id!=null;
          	}
        }).
      when('/home', {
          templateUrl: '/assets/javascripts/views/login.html'
        }).
      when('/access_denied', {
          templateUrl: '/assets/javascripts/views/login.html'
        }).
      otherwise({
        redirectTo: '/home'
      });
}]);