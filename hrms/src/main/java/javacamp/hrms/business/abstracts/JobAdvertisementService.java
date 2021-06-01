package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.JobAdvertisement;
import javacamp.hrms.entities.dtos.JobAdvertisementWithEmployerWithJobPositionDto;

public interface JobAdvertisementService {
	
	public List<JobAdvertisement> getAll();
	
	public DataResult<List<JobAdvertisement>> getAllSorted();
	
	public DataResult<List<JobAdvertisement>> getAllActiveSorted();
	
	public DataResult<List<JobAdvertisement>> getByEmployer_id(int userId);
	
	public DataResult<List<JobAdvertisement>> getByAdvertisementStatus(boolean status);	
	
	public Result addJobAdvertisement(JobAdvertisement jobAdvertisement);
	
	public Result updateJobAdvertisementSetJobAdvertisementStatusForEmployer_id(int jobAdvertisementId, int employerId);

	DataResult<List<JobAdvertisementWithEmployerWithJobPositionDto>> getJobAdvertisementWithEmployerWithJobPositionDetails();
}
