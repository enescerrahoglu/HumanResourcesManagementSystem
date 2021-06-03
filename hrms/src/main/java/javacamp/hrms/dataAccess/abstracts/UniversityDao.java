package javacamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.concretes.University;

public interface UniversityDao extends JpaRepository<University, Integer> {

}
