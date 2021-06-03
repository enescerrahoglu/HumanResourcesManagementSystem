package javacamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.concretes.CvSocialMedia;

public interface CvSocialMediaDao extends JpaRepository<CvSocialMedia, Integer> {

}
