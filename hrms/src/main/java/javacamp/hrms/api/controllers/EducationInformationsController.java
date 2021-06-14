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

import javacamp.hrms.business.abstracts.EducationInformationService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.EducationInformation;
import javacamp.hrms.entities.dtos.EducationInformationWithCvWithUniversityWithUniversityDepartmentDto;

@RestController
@RequestMapping("/api/educationInformations")
@CrossOrigin
public class EducationInformationsController {
	private EducationInformationService educationInformationService;

	@Autowired
	public EducationInformationsController(EducationInformationService educationInformationService) {
		super();
		this.educationInformationService = educationInformationService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<EducationInformation>> getAll(){
		return this.educationInformationService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody EducationInformation educationInformation) {
		return this.educationInformationService.add(educationInformation);
	}
	
	@GetMapping("/getEducationInformationWithCvWithUniversityWithUniversityDepartmentDetails")
	public DataResult<List<EducationInformationWithCvWithUniversityWithUniversityDepartmentDto>> getEducationInformationWithCvWithUniversityWithUniversityDepartmentDetails(@RequestParam int userId){
		return this.educationInformationService.getEducationInformationWithCvWithUniversityWithUniversityDepartmentDetails(userId);
	}
}
