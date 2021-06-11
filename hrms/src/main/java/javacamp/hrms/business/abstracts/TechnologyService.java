package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.entities.concretes.Technology;

public interface TechnologyService {
	public DataResult<List<Technology>> getAll();
}
