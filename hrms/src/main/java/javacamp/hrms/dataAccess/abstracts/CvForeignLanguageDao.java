package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javacamp.hrms.entities.concretes.CvForeignLanguage;
import javacamp.hrms.entities.dtos.CvForeignLanguageWithForeignLanguageDto;

public interface CvForeignLanguageDao extends JpaRepository<CvForeignLanguage, Integer> {
	
	@Query("Select new javacamp.hrms.entities.dtos.CvForeignLanguageWithForeignLanguageDto(c.cvForeignLanguageId, "
			+ " f.foreignLanguageName, l.languageLevelName) "
			+ "From CvForeignLanguage c INNER JOIN c.foreignLanguage f INNER JOIN c.languageLevel l "
			+ " where c.cv.cvId = ?1")
	List<CvForeignLanguageWithForeignLanguageDto> getCvForeignLanguageWithForeignLanguageDetails(int cvId);
}
