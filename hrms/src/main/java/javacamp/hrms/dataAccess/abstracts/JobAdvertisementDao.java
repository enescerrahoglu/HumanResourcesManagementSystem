package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javacamp.hrms.entities.concretes.JobAdvertisement;
import javacamp.hrms.entities.dtos.JobAdvertisementWithEmployerWithJobPositionDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	
	@Query("From JobAdvertisement where advertisementStatus=true ORDER BY applicationDeadline DESC")
	List<JobAdvertisement> getAllActiveSorted();
	
	List<JobAdvertisement> getByAdvertisementStatus(boolean status);
	
	JobAdvertisement getByJobAdvertisementIdAndEmployer_id(int jobAdvertisementId, int userId);
	
	List<JobAdvertisement> getByEmployer_id(int userId);
	
	@Modifying
	@Query("UPDATE JobAdvertisement SET advertisementStatus = false WHERE jobAdvertisementId=:jobAdvertisementId AND employer.id=:employerId")
	int updateJobAdvertisementSetJobAdvertisementStatusForEmployer_id(@Param("jobAdvertisementId") int jobAdvertisementId, @Param("employerId") int employerId);
	
	@Query("Select new javacamp.hrms.entities.dtos.JobAdvertisementWithEmployerWithJobPositionDto(ja.id, e.companyName , p.jobPositionName , ja.positionAmount, ja.releaseDate, ja.applicationDeadline) From JobAdvertisement ja Inner Join ja.employer e Inner Join ja.position p")
	List<JobAdvertisementWithEmployerWithJobPositionDto> getJobAdvertisementWithEmployerWithJobPositionDetails();
}
