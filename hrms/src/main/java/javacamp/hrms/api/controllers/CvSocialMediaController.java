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

import javacamp.hrms.business.abstracts.CvSocialMediaService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.CvSocialMedia;
import javacamp.hrms.entities.dtos.CvSocialMediaWithSocialMediaDto;

@RestController
@RequestMapping("/api/cvSocialMedia")
@CrossOrigin
public class CvSocialMediaController {
	private CvSocialMediaService cvSocialMediaService;

	@Autowired
	public CvSocialMediaController(CvSocialMediaService cvSocialMediaService) {
		super();
		this.cvSocialMediaService = cvSocialMediaService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CvSocialMedia>> getAll() {
		return this.cvSocialMediaService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CvSocialMedia cvSocialMedia) {
		return this.cvSocialMediaService.add(cvSocialMedia);
	}
	
	@GetMapping("/getCvSocialMediaWithSocialMediaDetails")
	public DataResult<List<CvSocialMediaWithSocialMediaDto>> getCvSocialMediaWithSocialMediaDetails(@RequestParam int cvId){
		return this.cvSocialMediaService.getCvSocialMediaWithSocialMediaDetails(cvId);
	}
}
