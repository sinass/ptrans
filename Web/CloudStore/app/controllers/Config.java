package controllers;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import com.cloudview.dao.ConfigRepository;

public class Config extends Controller {
	
	public static Result find() {
        return ok(Json.toJson(ConfigRepository.find()));
    }

}
