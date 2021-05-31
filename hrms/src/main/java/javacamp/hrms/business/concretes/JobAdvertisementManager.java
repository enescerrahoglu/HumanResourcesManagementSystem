package javacamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import javacamp.hrms.business.abstracts.JobAdvertisementService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.ErrorResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessDataResult;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.JobAdvertisementDao;
import javacamp.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}
	
	@Override
	public List<JobAdvertisement> getAll() {
		return this.jobAdvertisementDao.findAll();
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllSorted() {
		Sort sort = Sort.by(Direction.ASC, "applicationDeadline");
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(sort), "İş İlanları Listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByEmployer_id(int userId) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByEmployer_id(userId), "Firmanın İş İlanları Listelendi.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByAdvertisementStatus(boolean status) {
		String message = "Aktif ";
		if (status == false) {
			message = "Pasif ";
		}
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByAdvertisementStatus(status), message + " İş İlanları Listelendi.");
	}

	@Override
	public Result addJobAdvertisement(JobAdvertisement jobAdvertisement) {
		Result result = new ErrorResult("Ekleme Başarısız!");
		if (!jobAdvertisement.getJobDescription().isEmpty()) {
			this.jobAdvertisementDao.save(jobAdvertisement);
			result = new SuccessResult("Ekleme Başarılı!");
		}
		return result;
	}

	@Override
	public Result updateJobAdvertisementSetJobAdvertisementStatusForEmployer_id(int jobAdvertisementId, int employerId) {
		this.jobAdvertisementDao.updateJobAdvertisementSetJobAdvertisementStatusForEmployer_id(jobAdvertisementId, employerId);
		return new SuccessResult("İlan Kapatıldı!");
	}

}
