package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.CvTechnologyService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.CvTechnologyDao;
import javacamp.hrms.entities.concretes.CvTechnology;

@Service
public class CvTechnologyManager implements CvTechnologyService {

	private CvTechnologyDao cvTechnologyDao;
	
	@Autowired
	public CvTechnologyManager(CvTechnologyDao cvTechnologyDao) {
		super();
		this.cvTechnologyDao = cvTechnologyDao;
	}

	@Override
	public DataResult<List<CvTechnology>> getAll() {
		return new SuccessDataResult<List<CvTechnology>>(this.cvTechnologyDao.findAll());
	}

	@Override
	public Result add(CvTechnology cvTechnology) {
		this.cvTechnologyDao.save(cvTechnology);
		return new SuccessResult("CV'ye teknoloji eklendi.");
	}

}
