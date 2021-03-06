package javacamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javacamp.hrms.entities.concretes.EducationInformation;
import javacamp.hrms.entities.dtos.EducationInformationWithCvWithUniversityWithUniversityDepartmentDto;

public interface EducationInformationDao extends JpaRepository<EducationInformation, Integer> {
	@Query("Select new javacamp.hrms.entities.dtos.EducationInformationWithCvWithUniversityWithUniversityDepartmentDto("
			+ "e.educationInformationId, j.firstName, j.lastName, c.cvId, u.universityId, "
			+ "u.universityName, d.universityDepartmentId, d.universityDepartmentName, e.startingDate, e.graduationDate) "
			+ "From EducationInformation e Inner Join University u ON e.university.universityId = u.universityId"
			+ " Inner Join UniversityDepartment d ON e.universityDepartment.universityDepartmentId = d.universityDepartmentId"
			+ " Inner Join e.cv c "
			+ " Inner Join JobSeeker j ON e.cv.jobSeeker.id = j.id"
			+ " where j.id=?1 ORDER BY e.graduationDate DESC")
	List<EducationInformationWithCvWithUniversityWithUniversityDepartmentDto>
	getEducationInformationWithCvWithUniversityWithUniversityDepartmentDetails(int cvId);
}
