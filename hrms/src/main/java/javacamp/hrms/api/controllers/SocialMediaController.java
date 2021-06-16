package javacamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.SocialMediaService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.entities.concretes.SocialMedia;

@RestController
@RequestMapping("/api/socialMedia")
@CrossOrigin
public class SocialMediaController {

	private SocialMediaService socialMediaService;

	@Autowired
	public SocialMediaController(SocialMediaService socialMediaService) {
		super();
		this.socialMediaService = socialMediaService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<SocialMedia>> getAll() {
		return this.socialMediaService.getAll();
	}
}
