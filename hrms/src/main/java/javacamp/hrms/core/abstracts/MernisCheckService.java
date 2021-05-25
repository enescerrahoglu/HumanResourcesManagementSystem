package javacamp.hrms.core.abstracts;

import org.springframework.stereotype.Service;

import javacamp.hrms.entities.concretes.JobSeeker;

@Service
public interface MernisCheckService {
	public boolean checkIfRealPerson(JobSeeker jobSeeker);
}
