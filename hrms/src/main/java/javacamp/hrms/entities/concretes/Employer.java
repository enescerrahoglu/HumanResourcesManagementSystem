package javacamp.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobAdvertisement"})
public class Employer extends User implements Entities {
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "website")
	private String website;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name="verification_status")
	private boolean verificationStatus;
	
	@OneToMany(mappedBy = "employer")
	private List<JobAdvertisement> jobAdvertisement;

	public Employer(String email, String password, String company_name, String website, String phone_number, boolean verificationStatus) {
		super(email, password);
		this.companyName = company_name;
		this.website = website;
		this.phoneNumber = phone_number;
		this.verificationStatus = verificationStatus;
	}
	
}