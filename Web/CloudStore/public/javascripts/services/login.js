angular.module("cloudView")
.constant("loginURL","authenticate/")
.service("loginService",['$resource','loginURL',function($resource,loginURL){
	
	this.login = function(user){
		var status = false;
		var userRS = $resource(loginURL+":login/:password");
		var u = userRS.get({login:user.login,password:user.password},function(){
			console.log("get ok");
		},function(){
			console.log("get non ok");
		});
		if(u.id!==undefined) status = true;
		else status = false;
		console.log("status:"+this.status);
		return this.status;
	}
}]);