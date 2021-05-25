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
@Table(name = "employers")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Employer extends User implements Entities {
	
	@Column(name = "company_name")
	private String company_name;
	
	@Column(name = "website")
	private String website;
	
	@Column(name = "phone_number")
	private String phone_number;
	
	@Column(name="verification_status")
	private boolean verificationStatus;

	public Employer(String email, String password, String company_name, String website, String phone_number, boolean verificationStatus) {
		super(email, password);
		this.company_name = company_name;
		this.website = website;
		this.phone_number = phone_number;
		this.verificationStatus = verificationStatus;
	}
	
}