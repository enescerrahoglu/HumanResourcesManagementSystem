package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.CvService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.CvDao;
import javacamp.hrms.entities.concretes.Cv;

@Service
public class CvManager implements CvService {
	
	private CvDao cvDao;
	
	@Autowired
	public CvManager(CvDao cvDao) {
		super();
		this.cvDao = cvDao;
	}

	@Override
	public DataResult<List<Cv>> getAll() {
		return new SuccessDataResult<List<Cv>>(this.cvDao.findAll());
	}

	@Override
	public Result add(Cv cv) {
		this.cvDao.save(cv);
		return new SuccessResult("CV sisteme eklendi.");
	}

	@Override
	public DataResult<List<Cv>> getByCvIdForJobSeeker_UserId(int userId) {
		return new SuccessDataResult<List<Cv>>(this.cvDao.getByCvIdForJobSeekerId(userId));
	}
	
}
