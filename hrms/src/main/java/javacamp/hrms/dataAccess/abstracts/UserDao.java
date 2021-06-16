package javacamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javacamp.hrms.entities.abstracts.User;

public interface UserDao extends JpaRepository<User, Integer>{
	@Query("Select u.password From User u where u.email=?1")
	String getPasswordByEmail(String email);
}
