package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.JobPositionService;
import javacamp.hrms.core.utilities.results.ErrorResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.JobPositionDao;
import javacamp.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}
	
	@Override
	public List<JobPosition> getAll() {
		return jobPositionDao.findAll();
	}

	@Override
	public Result add(JobPosition jobPosition) {
		Result result = new ErrorResult("İş Pozisyonu Eklenemedi!");
		if (positionIsItUsed(jobPosition.getJobPositionName())) {
			this.jobPositionDao.save(jobPosition);
			result = new SuccessResult("İş Pozisyonu Başarıyla Eklendi!");
		}
		return result;
	}
	
	public boolean positionIsItUsed(String positionName) {
		boolean result = true;
		if(this.jobPositionDao.getAllPositionName().contains(positionName)) {
			result = false;
		}
		return result;
	}

}