package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.CvForeignLanguage;
import javacamp.hrms.entities.dtos.CvForeignLanguageWithForeignLanguageDto;

public interface CvForeignLanguageService {
	public DataResult<List<CvForeignLanguage>> getAll();
	public Result add(CvForeignLanguage cvForeignLanguage);
	DataResult<List<CvForeignLanguageWithForeignLanguageDto>> getCvForeignLanguageWithForeignLanguageDetails(int cvId);
}
