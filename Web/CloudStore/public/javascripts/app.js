/**
 * App file
 */

function AbstractView(){
    this.tab = true;
	this.list = false;
};

AbstractView.prototype.SetViewManager = function(viewManager){
	this.viewManager = viewManager;
};

AbstractView.prototype.SetShow = function(show){
	this.show = show;
};

AbstractView.prototype.ShowList = function(){
	this.list = true;
	this.tab = false;
};

AbstractView.prototype.ShowTab = function(){
	this.list = false;
	this.tab = true;
};

function MenuView(){
	this.show = true;
};

function AnimalView(){
	this.show = true;
	this.AnimalSelected = function(animal){
		this.animal = animal;
		this.viewManager.AnimalSelected();
		//alert('animal '+this.tab+' '+this.list+' '+this.animal);
	};
};

function StudiesView(){
	this.show = false;
	this.StudySelected = function(study){
		this.study = study;
		this.viewManager.StudySelected();
		//alert('studies '+this.tab+' '+this.list);
	}
};

function RadiosView(){
	this.show = false;
	this.RadioSelected = function(radio){
		this.radio = radio;
		this.viewManager.RadioSelected();
		//alert('radio '+this.tab+' '+this.list);
	}
};

function SingleRadioView(viewManager){
	this.show = false;
};

MenuView.prototype = new AbstractView();
AnimalView.prototype = new AbstractView();
StudiesView.prototype = new AbstractView();
RadiosView.prototype = new AbstractView();
SingleRadioView.prototype = new AbstractView();

//this class manages views
function ViewManager(menuView,animalView,studiesView,radiosView,singleRadioView){
	this.menuView = menuView;
	this.animalView = animalView;
	this.studiesView = studiesView;
	this.radiosView = radiosView;
	this.singleRadioView = singleRadioView;
};

ViewManager.prototype.SetAnimalView = function(animalView){
	this.animalView = animalView;
};

ViewManager.prototype.SetMenuView = function(menuView){
	this.menuView = menuView;
};

ViewManager.prototype.SetStudiesView = function(studiesView){
	this.studiesView = studiesView;
};

ViewManager.prototype.SetRadiosView = function(radiosView){
	this.radiosView = radiosView;
};

ViewManager.prototype.SetSingleRadioView = function(singleRadioView){
	this.singleRadioView = singleRadioView;
};

ViewManager.prototype.AnimalSelected = function(){
	this.menuView.SetShow(true);
	this.studiesView.SetShow(true);
	this.radiosView.SetShow(false);
	this.singleRadioView.SetShow(false);
	this.studiesView.ShowTab();
	this.animalView.ShowList();
};

ViewManager.prototype.StudySelected = function(){
	this.menuView.SetShow(false);
	this.singleRadioView.SetShow(false);
	this.animalView.SetShow(true);
	this.radiosView.SetShow(true);
	this.radiosView.ShowTab();
	this.studiesView.ShowList();
};

ViewManager.prototype.RadioSelected = function(){
	this.menuView.SetShow(false);
	this.singleRadioView.SetShow(true);
	this.animalView.SetShow(false);
	this.radiosView.ShowList();
};