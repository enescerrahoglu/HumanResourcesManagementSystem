package javacamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.concretes.LanguageLevel;

public interface LanguageLevelDao extends JpaRepository<LanguageLevel, Integer> {

}
