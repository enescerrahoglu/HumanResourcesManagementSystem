package javacamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.CvSocialMediaService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.CvSocialMedia;

@RestController
@RequestMapping("/api/cvSocialMedia")
public class CvSocialMediaController {
	private CvSocialMediaService cvSocialMediaService;

	@Autowired
	public CvSocialMediaController(CvSocialMediaService cvSocialMediaService) {
		super();
		this.cvSocialMediaService = cvSocialMediaService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<CvSocialMedia>> getAll() {
		return this.cvSocialMediaService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CvSocialMedia cvSocialMedia) {
		return this.cvSocialMediaService.add(cvSocialMedia);
	}
}
