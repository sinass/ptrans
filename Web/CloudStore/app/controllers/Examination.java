package controllers;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import com.cloudview.dao.ExaminationRepository;

public class Examination extends Controller {
	
	public static Result findImages(int idExamination) {
        return ok(Json.toJson(ExaminationRepository.findImages(idExamination)));
    }
	
}
