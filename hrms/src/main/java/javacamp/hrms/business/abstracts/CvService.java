package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Cv;
import javacamp.hrms.entities.dtos.CvWithJobSeekerDto;

public interface CvService {
	public DataResult<List<Cv>> getAll();
	public Result add(Cv cv);
	public DataResult<List<Cv>> getByCvIdForJobSeeker_UserId(int userId);
	public DataResult<List<CvWithJobSeekerDto>> getCvWithJobSeekerDetails(int cvId);
}
