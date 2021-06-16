package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.entities.concretes.WorkType;

public interface WorkTypeService {
	public DataResult<List<WorkType>> getAll();
}
