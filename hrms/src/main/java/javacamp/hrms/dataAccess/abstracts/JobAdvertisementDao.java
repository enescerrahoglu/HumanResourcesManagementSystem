package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javacamp.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	List<JobAdvertisement> getByAdvertisementStatus(boolean status);
	
	JobAdvertisement getByJobAdvertisementIdAndEmployer_id(int jobAdvertisementId, int userId);
	
	List<JobAdvertisement> getByEmployer_id(int userId);
	
	@Modifying
	@Query("UPDATE JobAdvertisement SET advertisementStatus = false WHERE jobAdvertisementId=:jobAdvertisementId AND employer.id=:employerId")
	int updateJobAdvertisementSetJobAdvertisementStatusForEmployer_id(@Param("jobAdvertisementId") int jobAdvertisementId, @Param("employerId") int employerId);
}
