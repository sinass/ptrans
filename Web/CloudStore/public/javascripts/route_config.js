angular.module("cloudView")
.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/login', {
        templateUrl: '/assets/javascripts/views/login.html',
        controller: 'loginCtrl'
      }).
      when('/index', {
        templateUrl: '/assets/javascripts/views/index.html',
        controller: 'cloudViewCtrl'
      }).
      otherwise({
        redirectTo: '/index'
      });
}]);