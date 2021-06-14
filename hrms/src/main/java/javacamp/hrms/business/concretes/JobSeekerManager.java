package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Objects;

import javacamp.hrms.business.abstracts.JobSeekerService;
import javacamp.hrms.core.abstracts.EmailCheckService;
import javacamp.hrms.core.abstracts.EmailSendService;
import javacamp.hrms.core.abstracts.MernisCheckService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.ErrorResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.JobSeekerDao;
import javacamp.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private EmailCheckService emailCheckService;
	private EmailSendService emailSendService;
	private MernisCheckService mernisCheckService;
	
	@Autowired
	public JobSeekerManager(EmailCheckService emailCheckService, JobSeekerDao jobSeekerDao, EmailSendService emailSendService, MernisCheckService mernisCheckService) {
		super();
		this.emailCheckService = emailCheckService;
		this.jobSeekerDao = jobSeekerDao;
		this.emailSendService = emailSendService;
		this.mernisCheckService = mernisCheckService;
	}
	
	@Override
	public Result register(JobSeeker jobSeeker, String passwordAgain) {
		Result result = new ErrorResult("Kayıt Başarısız!");
		if (emailCheckService.emailCheck(jobSeeker.getEmail())
				&& emailIsItUsed(jobSeeker.getEmail())
				&& identificationNumberIsItUsed(jobSeeker.getIdentificationNumber())
				&& mernisCheckService.checkIfRealPerson(jobSeeker)
				&& Objects.equal(passwordAgain, jobSeeker.getPassword())) {
			emailSendService.emailSend(jobSeeker.getEmail());
			this.jobSeekerDao.save(jobSeeker);
			result = new SuccessResult("Kayıt Başarılı.");
		}
		return result;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<>(this.jobSeekerDao.findAll(), "Data Listelendi");
	}

	@Override
	public List<String> getAllEmails() {
		return this.jobSeekerDao.getByEmail();
	}

	@Override
	public List<String> getAllIdentificationNumber() {
		return this.jobSeekerDao.getByIdentificationNumber();
	}
	
	public boolean emailIsItUsed(String email) {
		boolean result = true;
		if (getAllEmails().contains(email)) {
			result = false;
		}
		return result;
	}

	public boolean identificationNumberIsItUsed(String identificationNumber) {
		boolean result = true;
		if (getAllIdentificationNumber().contains(identificationNumber)) {
			result = false;
		}
		return result;
	}

}