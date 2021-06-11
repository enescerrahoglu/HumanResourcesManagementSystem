package javacamp.hrms.business.abstracts;

import java.util.List;

import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.entities.concretes.SocialMedia;

public interface SocialMediaService {
	public DataResult<List<SocialMedia>> getAll();
}
