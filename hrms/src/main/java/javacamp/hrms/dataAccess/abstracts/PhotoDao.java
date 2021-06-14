package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javacamp.hrms.entities.concretes.Photo;

public interface PhotoDao extends JpaRepository<Photo, Integer> {
	
	@Modifying
	@Query("Update Photo set photoUrl=:url Where cv.cvId=:cvId")
	int updatePhotoSetPhotoUrlForCv_cvId(@Param("url") String url, @Param("cvId") int cvId);
	
	@Query("Select cv.cvId From Photo")
	List<Integer> getAllCvId();

}
