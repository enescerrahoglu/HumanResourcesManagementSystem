package javacamp.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cvs")
public class Cv {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int cvId;
	
	@Column(name = "photo_link")
	private String photoLink;
	
	@Column(name = "objective")
	private String objective;
	
	@ManyToOne
	@JoinColumn(name="job_seeker_id")
	private JobSeeker jobSeeker;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cv")
	private List<CvForeignLanguage> cvForeignLanguages;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cv")
	private List<CvSocialMedia> cvSocialMedias;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cv")
	private List<CvTechnology> cvTechnologies;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cv")
	private List<EducationInformation> educationInformations;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cv")
	private List<WorkExperience> workExperiences;
}
