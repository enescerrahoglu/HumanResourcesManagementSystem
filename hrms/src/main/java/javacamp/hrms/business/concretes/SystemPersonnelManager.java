package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.SystemPersonnelService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.EmployerDao;
import javacamp.hrms.dataAccess.abstracts.SystemPersonnelDao;
import javacamp.hrms.entities.concretes.SystemPersonnel;

@Service
public class SystemPersonnelManager implements SystemPersonnelService {

	private SystemPersonnelDao systemPersonnelDao;
	private EmployerDao employerDao;
	
	@Autowired
	public SystemPersonnelManager(SystemPersonnelDao systemPersonnelDao, EmployerDao employerDao) {
		super();
		this.systemPersonnelDao = systemPersonnelDao;
		this.employerDao = employerDao;
	}
	
	@Override
	public DataResult<List<SystemPersonnel>> getAll() {
		return new SuccessDataResult<List<SystemPersonnel>>(this.systemPersonnelDao.findAll(), "Çalışan datası listelendi.");
	}

	@Override
	public Result register(SystemPersonnel systemPersonnel) {
		this.systemPersonnelDao.save(systemPersonnel);
		return new SuccessResult("Sistem personeli eklendi.");
	}

	@Override
	public Result updateEmployerSetVerificationStatusForUserId(int employerId) {
		this.employerDao.updateEmployerSetVerificationStatusForUserId(employerId);
		return new SuccessResult("İş veren onaylandı!");
	}

}