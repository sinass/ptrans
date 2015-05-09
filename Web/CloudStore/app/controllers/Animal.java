package controllers;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import com.cloudview.dao.AnimalRepository;


public class Animal extends Controller {
	
	public static Result findStudies(int idVeterinary,int idAnimal) {
        return ok(Json.toJson(AnimalRepository.findStudies(idVeterinary,idAnimal)));
    }

}
