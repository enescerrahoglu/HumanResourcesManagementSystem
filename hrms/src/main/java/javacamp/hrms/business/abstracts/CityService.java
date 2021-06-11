package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.entities.concretes.City;

public interface CityService {
	public DataResult<List<City>> getAll();
}
