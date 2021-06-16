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

import javacamp.hrms.business.abstracts.CvTechnologyService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.CvTechnology;
import javacamp.hrms.entities.dtos.CvTechnologyWithTechnologyDto;

@RestController
@RequestMapping("/api/cvTechnologies")
@CrossOrigin
public class CvTechnologiesController {
	private CvTechnologyService cvTechnologyService;

	@Autowired
	public CvTechnologiesController(CvTechnologyService cvTechnologyService) {
		super();
		this.cvTechnologyService = cvTechnologyService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CvTechnology>> getAll(){
		return this.cvTechnologyService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CvTechnology cvTechnology) {
		return this.cvTechnologyService.add(cvTechnology);
	}
	
	@GetMapping("/getCvTechnologyWithTechnologydetails")
	public DataResult<List<CvTechnologyWithTechnologyDto>> getCvTechnologyWithTechnologydetails(@RequestParam int cvId){
		return this.cvTechnologyService.getCvTechnologyWithTechnologydetails(cvId);
	}
}
