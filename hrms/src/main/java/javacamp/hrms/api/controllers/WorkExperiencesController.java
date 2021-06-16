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

import javacamp.hrms.business.abstracts.WorkExperienceService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.WorkExperience;
import javacamp.hrms.entities.dtos.WorkExperienceWithCvWithJobPositionDto;
import javacamp.hrms.entities.dtos.WorkExperienceWithCvWithJobSeekerDto;

@RestController
@RequestMapping("/api/workExperiences")
@CrossOrigin
public class WorkExperiencesController {
	private WorkExperienceService workExperienceService;

	@Autowired
	public WorkExperiencesController(WorkExperienceService workExperienceService) {
		super();
		this.workExperienceService = workExperienceService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<WorkExperience>> getAll(){
		return this.workExperienceService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody WorkExperience workExperience) {
		return this.workExperienceService.add(workExperience);
	}
	
	@PostMapping("/getWorkExperienceWithCvWithJobSeekerDetails")
	public DataResult<List<WorkExperienceWithCvWithJobSeekerDto>> getWorkExperienceWithCvWithJobSeekerDetails(@RequestParam int userId){
		return this.workExperienceService.getWorkExperienceWithCvWithJobSeekerDetails(userId);
	}
	
	@GetMapping("/getWorkExperienceWithCvWithJobPositionDetails")
	public DataResult<List<WorkExperienceWithCvWithJobPositionDto>> getWorkExperienceWithCvWithJobPositionDetails(@RequestParam int cvId){
		return this.workExperienceService.getWorkExperienceWithCvWithJobPositionDetails(cvId);
	}
}
