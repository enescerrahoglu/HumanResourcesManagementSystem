package javacamp.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employers")
public class Employer {
	
	@Id
	@Column(name = "user_id")
	private int user_id;
	
	@Column(name = "company_name")
	private String company_name;
	
	@Column(name = "website")
	private String website;
	
	@Column(name = "phone_number")
	private String phone_number;
	
	public Employer() {
		
	}
	
	public Employer(int user_id, String company_name, String website, String phone_number) {
		super();
		this.user_id = user_id;
		this.company_name = company_name;
		this.website = website;
		this.phone_number = phone_number;
	}
}
