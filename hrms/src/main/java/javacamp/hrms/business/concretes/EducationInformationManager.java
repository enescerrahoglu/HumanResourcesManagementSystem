package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.EducationInformationService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.EducationInformationDao;
import javacamp.hrms.entities.concretes.EducationInformation;
import javacamp.hrms.entities.dtos.EducationInformationWithCvWithUniversityWithUniversityDepartmentDto;

@Service
public class EducationInformationManager implements EducationInformationService {

	private EducationInformationDao educationInformationDao;
	
	@Autowired
	public EducationInformationManager(EducationInformationDao educationInformationDao) {
		super();
		this.educationInformationDao = educationInformationDao;
	}

	@Override
	public DataResult<List<EducationInformation>> getAll() {
		return new SuccessDataResult<List<EducationInformation>>(this.educationInformationDao.findAll());
	}

	@Override
	public Result add(EducationInformation educationInformation) {
		this.educationInformationDao.save(educationInformation);
		return new SuccessResult("CV'ye eğitim bilgisi eklendi.");
	}

	@Override
	public DataResult<List<EducationInformationWithCvWithUniversityWithUniversityDepartmentDto>> getEducationInformationWithCvWithUniversityWithUniversityDepartmentDetails(int userId) {
		return new SuccessDataResult<List<EducationInformationWithCvWithUniversityWithUniversityDepartmentDto>>(this.educationInformationDao.getEducationInformationWithCvWithUniversityWithUniversityDepartmentDetails(userId));
	}

}
