package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.entities.concretes.WorkTimeType;

public interface WorkTimeTypeService {
	public DataResult<List<WorkTimeType>> getAll();
}
