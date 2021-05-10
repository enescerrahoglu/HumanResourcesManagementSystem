package javacamp.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.SystemPersonnelService;
import javacamp.hrms.entities.concretes.SystemPersonnel;

@RestController
@RequestMapping("/api/systempersonnel")
public class SystemPersonnelController {

	private SystemPersonnelService systemPersonnelService;

	@Autowired
	public SystemPersonnelController(SystemPersonnelService systemPersonnelService) {
		super();
		this.systemPersonnelService = systemPersonnelService;
	}
	
	@GetMapping("/getall")
	public List<SystemPersonnel> getAll(){
		return this.systemPersonnelService.getAll();
	}
}
