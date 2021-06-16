package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.TechnologyService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.TechnologyDao;
import javacamp.hrms.entities.concretes.Technology;

@Service
public class TechnologyManager implements TechnologyService {

	private TechnologyDao technologyDao;
	
	@Autowired
	public TechnologyManager(TechnologyDao technologyDao) {
		super();
		this.technologyDao = technologyDao;
	}
	
	@Override
	public Result add(Technology technology) {
		this.technologyDao.save(technology);
		return new SuccessResult("Teknoloji eklendi.");
	}

	@Override
	public DataResult<List<Technology>> getAll() {
		return new SuccessDataResult<List<Technology>>(this.technologyDao.findAll(), "Teknolojiler listelendi.");
	}

}
