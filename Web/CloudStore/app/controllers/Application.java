package controllers;



import play.*;
import play.data.Form;
import play.libs.Json;
import play.mvc.*;
import views.html.*;
import play.api.libs.json.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    public static Result addVeterinary(String surgeryMail) {
    	
        return ok("addVeto");
    }
    public static Result deleteVeterinary(int id) {
    	
    	return ok("deleteVeto");
    }
    public static Result findVeterinary(int id) {
    	return ok("JsonValue");
    }
    public static Result addSurgery() {
    	
    	return ok("addSurgery");
    }
    public static Result deleteSurgery(int id) {
    	
    	return ok("deleteSurgery");
    }
    public static Result findSurgery(int id) {
    	return ok("Json value");
    }
    public static Result authenticate(String login,String password){
    	return ok("JsonValue");
    }
}
