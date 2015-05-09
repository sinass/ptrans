package controllers;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import com.cloudview.dao.VeterinaryRepository;

public class Veterinary extends Controller {
	
	public static Result findAnimals(int id) {
        return ok(Json.toJson(VeterinaryRepository.findAnimals(id)));
    }
	

}
