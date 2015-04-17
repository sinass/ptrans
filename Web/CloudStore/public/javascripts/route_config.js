angular.module("cloudView",[])
.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/login', {
        templateUrl: 'views/login.html',
        controller: 'loginCtrl'
      }).
      when('/index', {
        templateUrl: 'views/index.html',
        controller: 'cloudViewCtrl'
      }).
      otherwise({
        redirectTo: '/login'
      });
}]);