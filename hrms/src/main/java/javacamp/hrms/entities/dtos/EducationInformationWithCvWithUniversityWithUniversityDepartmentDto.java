package javacamp.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationInformationWithCvWithUniversityWithUniversityDepartmentDto {
	/*private int educationId;
	private int cvId;
	private int universityId;
	private String universityName;
	private int departmentId;
	private String universityDepartmentName;
	private String startingDate;
	private String graduationDate;*/
	
	private int id;
	private String firstName;
	private String lastName;
	private int cvId;
	private int universityId;
	private String universityName;
	private int departmentId;
	private String universityDepartmentName;
	private String startingDate;
	private String graduationDate;
}
