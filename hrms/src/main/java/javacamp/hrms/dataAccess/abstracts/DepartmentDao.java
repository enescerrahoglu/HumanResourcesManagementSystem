package javacamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.concretes.Department;

public interface DepartmentDao extends JpaRepository<Department, Integer> {

}
