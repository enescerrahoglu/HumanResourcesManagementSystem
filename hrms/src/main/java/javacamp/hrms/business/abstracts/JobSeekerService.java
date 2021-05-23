package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {
	List<JobSeeker> getAll();
}
