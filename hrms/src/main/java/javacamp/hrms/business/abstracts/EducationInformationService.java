package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.EducationInformation;
import javacamp.hrms.entities.dtos.EducationInformationWithCvWithUniversityWithUniversityDepartmentDto;

public interface EducationInformationService {
	public DataResult<List<EducationInformation>> getAll();
	public Result add(EducationInformation educationInformation);
	public DataResult<List<EducationInformationWithCvWithUniversityWithUniversityDepartmentDto>> getEducationInformationWithCvWithUniversityWithUniversityDepartmentDetails(int userId);
}
