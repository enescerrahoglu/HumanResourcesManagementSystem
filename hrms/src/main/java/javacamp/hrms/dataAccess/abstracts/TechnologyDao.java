package javacamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.concretes.Technology;

public interface TechnologyDao extends JpaRepository<Technology, Integer> {

}
