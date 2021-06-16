package javacamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.UniversityDepartmentService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.entities.concretes.UniversityDepartment;

@RestController
@RequestMapping("/api/universityDepartments")
@CrossOrigin
public class UniversityDepartmentsController {
	private UniversityDepartmentService universityDepartmentService;

	@Autowired
	public UniversityDepartmentsController(UniversityDepartmentService universityDepartmentService) {
		super();
		this.universityDepartmentService = universityDepartmentService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<UniversityDepartment>> getAll() {
		return this.universityDepartmentService.getAll();
	}
}
