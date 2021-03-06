package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javacamp.hrms.entities.concretes.WorkExperience;
import javacamp.hrms.entities.dtos.WorkExperienceWithCvWithJobPositionDto;
import javacamp.hrms.entities.dtos.WorkExperienceWithCvWithJobSeekerDto;

public interface WorkExperienceDao extends JpaRepository<WorkExperience, Integer> {
	@Query("Select new javacamp.hrms.entities.dtos.WorkExperienceWithCvWithJobSeekerDto("
			+ "w.workExperienceId, w.workplaceName, w.startingDate, w.endingDate, p.jobPositionName, j.firstName, j.lastName) "
			+ "From WorkExperience w Inner Join Cv c ON w.cv.cvId = c.cvId "
			+ "Inner Join JobSeeker j ON w.cv.jobSeeker.id = j.id "
			+ "Inner Join JobPosition p ON w.jobPosition.jobPositionId = p.jobPositionId "
			+ "where w.cv.jobSeeker.id=?1 ORDER BY w.endingDate DESC")
	List<WorkExperienceWithCvWithJobSeekerDto> getWorkExperienceWithCvWithJobSeekerDetails(int userId);
	
	@Query("Select new javacamp.hrms.entities.dtos.WorkExperienceWithCvWithJobPositionDto("
			+ "w.workplaceName, w.startingDate, w.endingDate, p.jobPositionName) "
			+ "From WorkExperience w Inner Join Cv c ON w.cv.cvId=c.cvId "
			+ "Inner Join JobPosition p ON w.jobPosition.jobPositionId=p.jobPositionId "
			+ "where w.cv.cvId=?1 ORDER BY w.endingDate DESC")
	List<WorkExperienceWithCvWithJobPositionDto> getWorkExperienceWithCvWithJobPositionDetails(int cvId);
}
