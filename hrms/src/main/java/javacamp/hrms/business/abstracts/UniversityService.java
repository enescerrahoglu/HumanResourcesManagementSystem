package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.entities.concretes.University;

public interface UniversityService {
	public DataResult<List<University>> getAll();
}
