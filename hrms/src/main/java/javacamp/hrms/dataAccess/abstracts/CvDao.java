package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javacamp.hrms.entities.concretes.Cv;
import javacamp.hrms.entities.dtos.CvWithJobSeekerDto;

public interface CvDao extends JpaRepository<Cv, Integer> {
	@Query("From Cv c where c.jobSeeker.id=?1")
	List<Cv> getByCvIdForJobSeekerId(int userId);
	
	@Query("Select new javacamp.hrms.entities.dtos.CvWithJobSeekerDto(c.objective, j.firstName, j.lastName, "
			+ "j.email, j.birthYear) "
			+ "From Cv c INNER JOIN c.jobSeeker j "
			+ " where c.cvId = ?1")
	List<CvWithJobSeekerDto> getCvWithJobSeekerDetails(int cvId);
}
