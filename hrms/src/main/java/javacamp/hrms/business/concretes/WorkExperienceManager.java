package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.WorkExperienceService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.WorkExperienceDao;
import javacamp.hrms.entities.concretes.WorkExperience;
import javacamp.hrms.entities.dtos.WorkExperienceWithCvWithJobSeekerDto;

@Service
public class WorkExperienceManager implements WorkExperienceService {

	private WorkExperienceDao workExperienceDao;
	
	@Autowired
	public WorkExperienceManager(WorkExperienceDao workExperienceDao) {
		super();
		this.workExperienceDao = workExperienceDao;
	}

	@Override
	public DataResult<List<WorkExperience>> getAll() {
		return new SuccessDataResult<List<WorkExperience>>(this.workExperienceDao.findAll());
	}

	@Override
	public Result add(WorkExperience workExperience) {
		if(workExperience.getEndingDate().isEmpty()) {
			workExperience.setEndingDate("Halen devam etmekte.");
		}
		this.workExperienceDao.save(workExperience);
		return new SuccessResult("İş tecrübesi başarıyla eklendi.");
	}

	@Override
	public DataResult<List<WorkExperienceWithCvWithJobSeekerDto>> getWorkExperienceWithCvWithJobSeekerDetails(int userId) {
		return new SuccessDataResult<List<WorkExperienceWithCvWithJobSeekerDto>>(this.workExperienceDao.getWorkExperienceWithCvWithJobSeekerDateils(userId));
	}

}
