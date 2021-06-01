  
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
	private int departmentId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;

	public SystemPersonnel(int departmentId, String email, String password, String firstName, String lastName) {
		super(email, password);
		this.departmentId = departmentId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
}