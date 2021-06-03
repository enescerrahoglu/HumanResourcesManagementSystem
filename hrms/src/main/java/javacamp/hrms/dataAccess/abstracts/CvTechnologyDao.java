package javacamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.concretes.CvTechnology;

public interface CvTechnologyDao extends JpaRepository<CvTechnology, Integer> {

}
