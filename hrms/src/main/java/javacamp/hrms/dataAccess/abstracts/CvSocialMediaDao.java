package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javacamp.hrms.entities.concretes.CvSocialMedia;
import javacamp.hrms.entities.dtos.CvSocialMediaWithSocialMediaDto;

public interface CvSocialMediaDao extends JpaRepository<CvSocialMedia, Integer> {
	@Query("Select new javacamp.hrms.entities.dtos.CvSocialMediaWithSocialMediaDto(s.socialMediaName, "
			+ " c.link) "
			+ "From CvSocialMedia c INNER JOIN c.socialMedia s "
			+ " where c.cv.cvId = ?1")
	List<CvSocialMediaWithSocialMediaDto> getCvSocialMediaWithSocialMediaDetails(int cvId);
}
