package javacamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.WorkTimeTypeService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.entities.concretes.WorkTimeType;

@RestController
@RequestMapping("/api/workTimeTypes")
@CrossOrigin
public class WorkTimeTypesController {
	
	private WorkTimeTypeService workTimeTypeService;
	
	@Autowired
	public WorkTimeTypesController(WorkTimeTypeService workTimeTypeService) {
		super();
		this.workTimeTypeService = workTimeTypeService;
	}

	@GetMapping("/getAll")
	public DataResult<List<WorkTimeType>> getAll(){
		return this.workTimeTypeService.getAll();
	}
}
