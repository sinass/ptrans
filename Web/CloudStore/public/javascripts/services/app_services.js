angular.module("cloudView")
.constant("animalURL","animal/")
.constant("veterinaryURL","veterinary/")
.constant("studyURL","study/")
.constant("examinationURL","examination/")
.constant("configURL","config")
.service("appService",['$resource','animalURL','veterinaryURL','studyURL','examinationURL','configURL',
   function($resource,animalURL,veterinaryURL,studyURL,examinationURL,configURL){
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
	this.study = {
			examinations: function(idStudy){
				var examinationRS = $resource(studyURL+"examinations/:idStudy");
				var u = examinationRS.query({idStudy:idStudy},function(){
					console.log(" get study examinations ok");
				},function(){
					console.log("get study examinations non ok:erreur");
				});
				return u;
			}
	};
	this.examination = {
			images: function(id){
				var imageRS = $resource(examinationURL+"images/:idExamination");
				var u = imageRS.query({idExamination:id},function(){
					console.log(" get examination images ok");
				},function(){
					console.log("get examination images non ok:erreur");
				});
				return u;
			}
	};
	this.config = {
			find: function(){
				var configRS = $resource(configURL);
				var u = configRS.get(function(){
					console.log(" get config ok");
				},function(){
					console.log("get config non ok:erreur");
				});
				return u;
			}
	};
}]);