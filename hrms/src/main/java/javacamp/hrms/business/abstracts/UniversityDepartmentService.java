package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.entities.concretes.UniversityDepartment;

public interface UniversityDepartmentService {
	public DataResult<List<UniversityDepartment>> getAll();
}
