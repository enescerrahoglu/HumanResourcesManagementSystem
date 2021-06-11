package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.UniversityDepartmentService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.dataAccess.abstracts.UniversityDepartmentDao;
import javacamp.hrms.entities.concretes.UniversityDepartment;

@Service
public class UniversityDepartmentManager implements UniversityDepartmentService {

	private UniversityDepartmentDao universityDepartmentDao;
	
	@Autowired
	public UniversityDepartmentManager(UniversityDepartmentDao universityDepartmentDao) {
		super();
		this.universityDepartmentDao = universityDepartmentDao;
	}

	@Override
	public DataResult<List<UniversityDepartment>> getAll() {
		return new SuccessDataResult<List<UniversityDepartment>>(this.universityDepartmentDao.findAll());
	}

}
