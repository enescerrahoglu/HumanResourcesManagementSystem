package javacamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.concretes.CvForeignLanguage;

public interface CvForeignLanguageDao extends JpaRepository<CvForeignLanguage, Integer> {

}
