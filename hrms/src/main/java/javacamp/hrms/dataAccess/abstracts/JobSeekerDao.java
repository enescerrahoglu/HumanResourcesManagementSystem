package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javacamp.hrms.entities.concretes.JobSeeker;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {
	@Query("Select email From User")
	List<String> getByEmail();
	
	@Query("Select identificationNumber From JobSeeker")
	List<String> getByIdentificationNumber();
}
