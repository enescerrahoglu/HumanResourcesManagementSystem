package javacamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.CvForeignLanguageService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.CvForeignLanguage;
import javacamp.hrms.entities.dtos.CvForeignLanguageWithForeignLanguageDto;

@RestController
@RequestMapping("/api/cvForeignLanguages")
@CrossOrigin
public class CvForeignLanguagesController {
	private CvForeignLanguageService cvForeignLanguageService;

	@Autowired
	public CvForeignLanguagesController(CvForeignLanguageService cvForeignLanguageService) {
		super();
		this.cvForeignLanguageService = cvForeignLanguageService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CvForeignLanguage>> getAll() {
		return this.cvForeignLanguageService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CvForeignLanguage cvForeignLanguage) {
		return this.cvForeignLanguageService.add(cvForeignLanguage);
	}
	
	@GetMapping("/getCvForeignLanguageWithForeignLanguageDetails")
	public DataResult<List<CvForeignLanguageWithForeignLanguageDto>> getCvForeignLanguageWithForeignLanguageDetails(@RequestParam int cvId){
		return this.cvForeignLanguageService.getCvForeignLanguageWithForeignLanguageDetails(cvId);
	}
	
}
