package javacamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import javacamp.hrms.entities.concretes.WorkTimeType;

public interface WorkTimeTypeDao extends JpaRepository<WorkTimeType, Integer> {

}
