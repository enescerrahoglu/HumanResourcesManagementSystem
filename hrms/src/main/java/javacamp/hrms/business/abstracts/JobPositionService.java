package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	List<JobPosition> getAll();
}
