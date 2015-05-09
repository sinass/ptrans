package controllers;


import com.cloudview.dao.UserRepository;

import play.libs.Json;
import play.mvc.*;


public class User extends Controller {
	
	public static Result authenticate(String login,String password) {
        return ok(Json.toJson(UserRepository.findByLoginAndPassword(login, password)));
    }
	
}
