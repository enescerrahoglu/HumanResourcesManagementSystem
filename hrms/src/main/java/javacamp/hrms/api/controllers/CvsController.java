package javacamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.CvService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Cv;

@RestController
@RequestMapping("/api/cvs")
public class CvsController {
	private CvService cvService;

	@Autowired
	public CvsController(CvService cvService) {
		super();
		this.cvService = cvService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Cv>> getAll(){
		return this.cvService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Cv cv) {
		return this.cvService.add(cv);
	}
	
	@PostMapping("/getByCvIdForJobSeeker_UserId")
	public DataResult<List<Cv>> getByCvIdForJobSeeker_UserId(@RequestParam int userId){
		return this.cvService.getByCvIdForJobSeeker_UserId(userId);
	}
}
