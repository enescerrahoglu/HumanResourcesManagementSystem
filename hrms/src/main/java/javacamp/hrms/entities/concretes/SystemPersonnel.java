package javacamp.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "system_personnel")
public class SystemPersonnel {
	
	@Id
	@Column(name = "user_id")
	private int user_id;
	
	@Column(name = "department_id")
	private int department_id;
	
	@Column(name = "first_name")
	private String first_name;
	
	@Column(name = "last_name")
	private String last_name;

	public SystemPersonnel() {
		
	}
	
	public SystemPersonnel(int user_id, int department_id, String first_name, String last_name) {
		super();
		this.user_id = user_id;
		this.department_id = department_id;
		this.first_name = first_name;
		this.last_name = last_name;
	}
	
	
}
