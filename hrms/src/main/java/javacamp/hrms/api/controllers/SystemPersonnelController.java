package javacamp.hrms.api.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javacamp.hrms.business.abstracts.SystemPersonnelService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.SystemPersonnel;

@RestController
@RequestMapping("/api/systemPersonnel")
@CrossOrigin
public class SystemPersonnelController {

	private SystemPersonnelService systemPersonnelService;

	@Autowired
	public SystemPersonnelController(SystemPersonnelService systemPersonnelService) {
		super();
		this.systemPersonnelService = systemPersonnelService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<SystemPersonnel>> getAll(){
		return this.systemPersonnelService.getAll();
	}
	
	@PostMapping("/register")
	public Result add(@RequestBody SystemPersonnel systemPersonnel) {
		return this.systemPersonnelService.register(systemPersonnel);
	}
	
	@Transactional
	@PostMapping("/employerVerification")
	public Result updateEmployerSetVerificationStatusForUserId(@RequestParam("employerId") int employerId) {
		return this.systemPersonnelService.updateEmployerSetVerificationStatusForUserId(employerId);
	}
}