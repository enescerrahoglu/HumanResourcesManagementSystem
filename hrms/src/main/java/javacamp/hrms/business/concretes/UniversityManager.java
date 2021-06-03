package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.UniversityService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.dataAccess.abstracts.UniversityDao;
import javacamp.hrms.entities.concretes.University;

@Service
public class UniversityManager implements UniversityService {
	private UniversityDao universityDao;

	@Autowired
	public UniversityManager(UniversityDao universityDao) {
		super();
		this.universityDao = universityDao;
	}

	@Override
	public DataResult<List<University>> getAll() {
		return new SuccessDataResult<List<University>>(this.universityDao.findAll());
	}
	
}
