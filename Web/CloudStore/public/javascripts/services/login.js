angular.module("cloudView")
.constant("loginURL","authenticate/")
.service("loginService",['$resource','loginURL',function($resource,loginURL){
	
	this.login = function(user){
		var userRS = $resource(loginURL+":login/:password");
		var u = userRS.get({login:user.login,password:user.password},function(){
			console.log(u.login+" get ok");
		},function(){
			console.log("get non ok:erreur");
		});
		return u;
	}
}]);