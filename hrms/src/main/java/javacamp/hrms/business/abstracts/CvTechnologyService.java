package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.CvTechnology;
import javacamp.hrms.entities.dtos.CvTechnologyWithTechnologyDto;

public interface CvTechnologyService {
	public DataResult<List<CvTechnology>> getAll();
	public Result add(CvTechnology cvTechnology);
	public DataResult<List<CvTechnologyWithTechnologyDto>> getCvTechnologyWithTechnologydetails(int cvId);
}
