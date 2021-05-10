package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.SystemPersonnelService;
import javacamp.hrms.dataAccess.abstracts.SystemPersonnelDao;
import javacamp.hrms.entities.concretes.SystemPersonnel;

@Service
public class SystemPersonnelManager implements SystemPersonnelService {

	private SystemPersonnelDao systemPersonnelDao;
	
	@Autowired
	public SystemPersonnelManager(SystemPersonnelDao systemPersonnelDao) {
		super();
		this.systemPersonnelDao = systemPersonnelDao;
	}

	@Override
	public List<SystemPersonnel> getAll() {
		return this.systemPersonnelDao.findAll();
	}

}
