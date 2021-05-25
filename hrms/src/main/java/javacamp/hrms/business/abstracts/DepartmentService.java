package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Department;

public interface DepartmentService {
	public DataResult<List<Department>> getAll();
	public Result add(Department department);
}