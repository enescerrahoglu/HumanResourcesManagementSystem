package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {
	public Result login(String email, String password);
	public Result register(JobSeeker jobSeeker);
	
	public List<JobSeeker> getAll();
	public List<String> getAllEmails();
	public List<String> getAllIdentificationNumber();
}