package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.entities.concretes.SystemPersonnel;

public interface SystemPersonnelService {
	List<SystemPersonnel> getAll();
}
