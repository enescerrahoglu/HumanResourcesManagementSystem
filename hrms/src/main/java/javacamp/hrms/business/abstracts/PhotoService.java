package javacamp.hrms.business.abstracts;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.entities.concretes.Photo;

public interface PhotoService {
	public Result add(Photo photo, MultipartFile multipartFile) throws IOException;
	public Result update(int cvId, MultipartFile multipartFile) throws IOException;
	public Result delete(String id) throws IOException;
}
