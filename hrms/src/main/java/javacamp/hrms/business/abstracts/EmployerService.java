package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Employer;

public interface EmployerService {
	public Result login(String email, String password);
	public Result register(Employer employer);
	
	public List<Employer> getAll();
	public List<String> getAllEmails();
}