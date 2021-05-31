package javacamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer> {

}
