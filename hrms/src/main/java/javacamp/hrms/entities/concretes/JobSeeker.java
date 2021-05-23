package javacamp.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "job_seekers")
public class JobSeeker {
	
	@Id
	@Column(name = "user_id")
	private int user_id;
	
	@Column(name = "first_name")
	private String first_name;
	
	@Column(name = "last_name")
	private String last_name;
	
	@Column(name = "identification_number")
	private String identification_number;
	
	@Column(name = "birth_year")
	private int birth_year;
	
	public JobSeeker() {
		
	}
	
	public JobSeeker(int user_id, String first_name, String last_name, String identification_number, int birth_year) {
		super();
		this.user_id = user_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.identification_number = identification_number;
		this.birth_year = birth_year;
	}
}
