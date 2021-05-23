package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.entities.concretes.Department;

public interface DepartmentService {
	List<Department> getAll();
}
