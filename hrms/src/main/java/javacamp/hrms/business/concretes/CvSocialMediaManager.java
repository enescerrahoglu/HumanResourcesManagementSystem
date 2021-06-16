package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.CvSocialMediaService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.CvSocialMediaDao;
import javacamp.hrms.entities.concretes.CvSocialMedia;
import javacamp.hrms.entities.dtos.CvSocialMediaWithSocialMediaDto;

@Service
public class CvSocialMediaManager implements CvSocialMediaService {

	private CvSocialMediaDao cvSocialMediaDao;
	
	@Autowired
	public CvSocialMediaManager(CvSocialMediaDao cvSocialMediaDao) {
		super();
		this.cvSocialMediaDao = cvSocialMediaDao;
	}

	@Override
	public DataResult<List<CvSocialMedia>> getAll() {
		return new SuccessDataResult<List<CvSocialMedia>>(this.cvSocialMediaDao.findAll());
	}

	@Override
	public Result add(CvSocialMedia cvSocialMedia) {
		this.cvSocialMediaDao.save(cvSocialMedia);
		return new SuccessResult("CV'ye sosyal medya bilgileri eklendi.");
	}

	@Override
	public DataResult<List<CvSocialMediaWithSocialMediaDto>> getCvSocialMediaWithSocialMediaDetails(int cvId) {
		return new SuccessDataResult<List<CvSocialMediaWithSocialMediaDto>>(this.cvSocialMediaDao.getCvSocialMediaWithSocialMediaDetails(cvId), "Sosyal medya platformları listelendi");
	}
	
}
