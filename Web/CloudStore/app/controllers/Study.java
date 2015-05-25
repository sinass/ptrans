package controllers;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import com.cloudview.dao.StudyRepository;

public class Study extends Controller {
	
	public static Result findExaminations(int idStudy) {
        return ok(Json.toJson(StudyRepository.findExaminations(idStudy)));
    }
}
