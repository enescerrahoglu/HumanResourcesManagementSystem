  
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
@Table(name = "system_personnel")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class SystemPersonnel extends User implements Entities {
	
	@Column(name = "department_id")
	private int department_id;
	
	@Column(name = "first_name")
	private String first_name;
	
	@Column(name = "last_name")
	private String last_name;

	public SystemPersonnel(int department_id, String email, String password, String firstName, String lastName) {
		super(email, password);
		this.department_id = department_id;
		this.first_name = firstName;
		this.last_name = lastName;
	}
}