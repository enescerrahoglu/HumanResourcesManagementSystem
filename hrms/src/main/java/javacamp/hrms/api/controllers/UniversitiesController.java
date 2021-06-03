package javacamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.UniversityService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.entities.concretes.University;

@RestController
@RequestMapping("/api/universities")
public class UniversitiesController {
	private UniversityService universityService;

	@Autowired
	public UniversitiesController(UniversityService universityService) {
		super();
		this.universityService = universityService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<University>> getAll() {
		return this.universityService.getAll();
	}
}
