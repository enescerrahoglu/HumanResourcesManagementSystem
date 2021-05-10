package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.entities.concretes.Employer;

public interface EmployerService {
	List<Employer> getAll();
}
