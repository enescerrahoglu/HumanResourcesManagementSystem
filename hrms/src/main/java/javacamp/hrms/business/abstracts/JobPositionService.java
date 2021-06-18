package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	public DataResult<List<JobPosition>> getAll();
	public Result add(JobPosition jobPosition);
}