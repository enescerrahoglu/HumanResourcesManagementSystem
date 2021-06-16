package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.WorkTimeTypeService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.dataAccess.abstracts.WorkTimeTypeDao;
import javacamp.hrms.entities.concretes.WorkTimeType;

@Service
public class WorkTimeTypeManager implements WorkTimeTypeService {

	private WorkTimeTypeDao workTimeTypeDao;
	
	@Autowired
	public WorkTimeTypeManager(WorkTimeTypeDao workTimeTypeDao) {
		super();
		this.workTimeTypeDao = workTimeTypeDao;
	}

	@Override
	public DataResult<List<WorkTimeType>> getAll() {
		return new SuccessDataResult<List<WorkTimeType>>(this.workTimeTypeDao.findAll());
	}
	
}
