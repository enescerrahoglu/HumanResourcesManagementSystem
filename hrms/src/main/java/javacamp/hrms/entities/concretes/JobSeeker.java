package javacamp.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javacamp.hrms.entities.abstracts.Entities;
import javacamp.hrms.entities.abstracts.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@PrimaryKeyJoinColumn(name="user_id")
@Data
@Entity
@Table(name = "job_seekers")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class JobSeeker extends User implements Entities {
	
	@NotEmpty(message = "İsim boş bırakılamaz!")
	@Column(name = "first_name")
	private String firstName;
	
	@NotEmpty(message = "Soyisim boş bırakılamaz!")
	@Column(name = "last_name")
	private String lastName;
	
	@NotEmpty(message = "TC Kimlik Numarası boş bırakılamaz!")
	@Column(name = "identification_number")
	private String identificationNumber;
	
	@NotEmpty(message = "Doğum yılı boş bırakılamaz!")
	@Column(name = "birth_year")
	private int birthYear;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeeker")
	private List<Cv> cvs;

	public JobSeeker(String email, String password,String firstName, String lastName, String identificationNumber, int birthYear) {
		super(email, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.identificationNumber = identificationNumber;
		this.birthYear = birthYear;
	}
	
}