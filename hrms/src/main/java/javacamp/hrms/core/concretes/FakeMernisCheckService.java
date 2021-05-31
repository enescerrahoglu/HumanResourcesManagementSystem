package javacamp.hrms.core.concretes;

import org.springframework.stereotype.Component;

import javacamp.hrms.core.abstracts.MernisCheckService;
import javacamp.hrms.entities.concretes.JobSeeker;


@Component
public class FakeMernisCheckService implements MernisCheckService {

	@Override
	public boolean checkIfRealPerson(JobSeeker jobSeeker) {
		return true;
	}

}
