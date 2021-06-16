package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.CvSocialMedia;
import javacamp.hrms.entities.dtos.CvSocialMediaWithSocialMediaDto;

public interface CvSocialMediaService {
	public DataResult<List<CvSocialMedia>> getAll();
	public Result add(CvSocialMedia cvSocialMedia);
	public DataResult<List<CvSocialMediaWithSocialMediaDto>> getCvSocialMediaWithSocialMediaDetails(int cvId);
}
