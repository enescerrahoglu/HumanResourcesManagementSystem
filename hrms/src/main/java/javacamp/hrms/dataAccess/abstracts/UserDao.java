package javacamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.abstracts.User;

public interface UserDao extends JpaRepository<User, Integer>{
	
}
