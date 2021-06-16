package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.WorkExperience;
import javacamp.hrms.entities.dtos.WorkExperienceWithCvWithJobPositionDto;
import javacamp.hrms.entities.dtos.WorkExperienceWithCvWithJobSeekerDto;

public interface WorkExperienceService {
	public DataResult<List<WorkExperience>> getAll();
	public Result add(WorkExperience workExperience);
	public DataResult<List<WorkExperienceWithCvWithJobSeekerDto>> getWorkExperienceWithCvWithJobSeekerDetails(int userId);
	DataResult<List<WorkExperienceWithCvWithJobPositionDto>> getWorkExperienceWithCvWithJobPositionDetails(int cvId);
}
