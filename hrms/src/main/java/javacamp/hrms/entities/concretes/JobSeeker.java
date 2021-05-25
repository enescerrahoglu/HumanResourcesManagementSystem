package javacamp.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

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
	
	@Column(name = "first_name")
	private String first_name;
	
	@Column(name = "last_name")
	private String last_name;
	
	@Column(name = "identification_number")
	private String identification_number;
	
	@Column(name = "birth_year")
	private int birth_year;

	public JobSeeker(String email, String password,String first_name, String last_name, String identification_number, int birth_year) {
		super(email, password);
		this.first_name = first_name;
		this.last_name = last_name;
		this.identification_number = identification_number;
		this.birth_year = birth_year;
	}
	
}