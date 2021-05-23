package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.entities.concretes.User;

public interface UserService {
	List<User> getAll();
}
