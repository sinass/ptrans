angular.module("cloudView")
.constant("animalURL","animal/")
.constant("veterinaryURL","veterinary/")
.service("appService",['$resource','animalURL','veterinaryURL',
   function($resource,animalURL,veterinaryURL){
	this.veterinary = {
			animals: function(idVeto){
				var vetoRS = $resource(veterinaryURL+"animals/:idVeto");
				var u = vetoRS.query({idVeto:idVeto},function(){
					console.log(" get veto animals ok");
				},function(){
					console.log("get veto animals non ok:erreur");
				});
				return u;
			}
	};
	this.animal = {
			studies: function(idVeto,idAnimal){
				var animalRS = $resource(animalURL+"studies/:idVeto/:idAnimal");
				var u = animalRS.query({idVeto:idVeto,idAnimal:idAnimal},function(){
					console.log(" get animal studies ok");
				},function(){
					console.log("get animal studies non ok:erreur");
				});
				return u;
			}
	};
}]);