package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.entities.concretes.ForeignLanguage;

public interface ForeignLanguageService {
	public DataResult<List<ForeignLanguage>> getAll();
}
