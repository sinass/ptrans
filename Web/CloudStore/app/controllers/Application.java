package controllers;

import com.cloudview.dao.AppUserRepository;
import com.cloudview.lib.RandomPasswordGene;
import com.cloudview.model.AppUser;

import play.*;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

    public static Result index() {
        AppUserRepository.deleteById(3);
        return ok(index.render("Your new application is ready."));
    }

}
