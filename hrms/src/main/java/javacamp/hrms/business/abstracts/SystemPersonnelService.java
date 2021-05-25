package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.SystemPersonnel;

public interface SystemPersonnelService {
	public DataResult<List<SystemPersonnel>> getAll();
	public Result register(SystemPersonnel systemPersonnel);
}