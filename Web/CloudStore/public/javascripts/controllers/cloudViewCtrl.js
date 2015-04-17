angular.module("cloudView")
.controller("cloudViewCtrl",function($scope){
    
//****************************
var menuView = new MenuView();
var animalView = new AnimalView();
var studiesView = new StudiesView();
var radiosView = new RadiosView();
var singleRadioView = new SingleRadioView();
var viewManager = new ViewManager(menuView,animalView,studiesView,radiosView,singleRadioView);
//****************************
menuView.SetViewManager(viewManager);
animalView.SetViewManager(viewManager);
studiesView.SetViewManager(viewManager);
radiosView.SetViewManager(viewManager);
singleRadioView.SetViewManager(viewManager);

//****************************
$scope.menuView = menuView;
$scope.animalView = animalView;
$scope.studiesView = studiesView;
$scope.radiosView = radiosView;
$scope.singleRadioView = singleRadioView;
   
   /*************** selectedRadioCtrl ******/
    
$scope.data = {
    menu:{
        user:{Lastname:"Sinayoko",FirstName:"Mahamadou",email:"sinayoko.mahamadou@yahoo.fr",type:"user"},
        content:[{name:"Personal Folder",link:"#"},{name:"Personal Folder",link:"#"}]
    },
    animals:[
        {name:"Skubidoo-Chien",newStudy:"oui",doctor:"Dr-Paula"},
        {name:"Jack-Chat",newStudy:"oui",doctor:"Dr-Paula"},
        {name:"Paul-Peroquet",newStudy:"oui",doctor:"Dr-X"},
        ],
    studies:[
        {animal:"Skubidoo-Chien",name:"Etude du 09/02/2015",date:"09/02/2015",accessReport:"oui",doctor:"Dr-Paula"},
        {animal:"Skubidoo-Chien",name:"Etude du 22/06/2014",date:"22/06/2014",accessReport:"oui",doctor:"Dr-Paula"},
        {animal:"Jack-Chat",name:"Etude du 19/11/2013",date:"19/11/2013",accessReport:"non",doctor:"Dr-X"},
        {animal:"Jack-Chat",name:"Etude du 09/02/2015",date:"09/02/2015",accessReport:"oui",doctor:"Dr-X"},
        {animal:"Paul-Peroquet",name:"Etude du 15/01/2014",date:"15/01/2014",accessReport:"non",doctor:"Dr-Paula"},
        {animal:"Paul-Peroquet",name:"Etude du 07/03/2013",date:"07/03/2013",accessReport:"oui",doctor:"Dr-Y"},
        {animal:"Paul-Peroquet",name:"Etude du 08/02/2011",date:"08/02/2011",accessReport:"non",doctor:"Dr-Y"},
        {animal:"Paul-Peroquet",name:"Etude du 10/02/2012",date:"10/02/2012",accessReport:"oui",doctor:"Dr-Y"},
        ],
   radios:[
        {animal:"Skubidoo-Chien",study:"Etude du 09/02/2015",date:"09/02/2015",accessReport:"oui",doctor:"Dr-Paula",name:"radio1"},
        {animal:"Skubidoo-Chien",study:"Etude du 22/06/2014",date:"22/06/2014",accessReport:"oui",doctor:"Dr-Paula",name:"radio2"},
        {animal:"Jack-Chat",study:"Etude du 19/11/2013",date:"19/11/2013",accessReport:"non",doctor:"Dr-X",name:"radio3"},
        {animal:"Jack-Chat",study:"Etude du 09/02/2015",date:"09/02/2015",accessReport:"oui",doctor:"Dr-X",name:"radio4"},
        {animal:"Paul-Peroquet",study:"Etude du 15/01/2014",date:"15/01/2014",accessReport:"non",doctor:"Dr-Paula",name:"radio5"},
        {animal:"Paul-Peroquet",study:"Etude du 07/03/2013",date:"07/03/2013",accessReport:"oui",doctor:"Dr-Y",name:"radio6"},
        {animal:"Paul-Peroquet",study:"Etude du 08/02/2011",date:"08/02/2011",accessReport:"non",doctor:"Dr-Y",name:"radio7"},
        {animal:"Paul-Peroquet",study:"Etude du 10/02/2012",date:"10/02/2012",accessReport:"oui",doctor:"Dr-Y",name:"radio8"},
        ],
};
      
});
