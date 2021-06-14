package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.CvForeignLanguageService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.CvForeignLanguageDao;
import javacamp.hrms.entities.concretes.CvForeignLanguage;
import javacamp.hrms.entities.dtos.CvForeignLanguageWithForeignLanguageDto;

@Service
public class CvForeignLanguageManager implements CvForeignLanguageService {
	
	private CvForeignLanguageDao cvForeignLanguageDao;
	
	@Autowired
	public CvForeignLanguageManager(CvForeignLanguageDao cvForeignLanguageDao) {
		super();
		this.cvForeignLanguageDao = cvForeignLanguageDao;
	}

	@Override
	public DataResult<List<CvForeignLanguage>> getAll() {
		return new SuccessDataResult<List<CvForeignLanguage>>(this.cvForeignLanguageDao.findAll());
	}

	@Override
	public Result add(CvForeignLanguage cvForeignLanguage) {
		this.cvForeignLanguageDao.save(cvForeignLanguage);
		return new SuccessResult("CV'ye yabancı dil bilgisi eklendi.");
	}

	@Override
	public DataResult<List<CvForeignLanguageWithForeignLanguageDto>> getCvForeignLanguageWithForeignLanguageDetails(int cvId) {
		return new SuccessDataResult<>(this.cvForeignLanguageDao.getCvForeignLanguageWithForeignLanguageDetails(cvId), "Yabancı dil bilgileri listelendi.");
	}
	
}
