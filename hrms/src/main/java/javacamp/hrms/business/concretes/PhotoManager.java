package javacamp.hrms.business.concretes;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javacamp.hrms.business.abstracts.PhotoService;
import javacamp.hrms.core.abstracts.CloudinaryService;
import javacamp.hrms.core.utilities.results.ErrorResult;
import javacamp.hrms.core.utilities.results.Result;
import javacamp.hrms.core.utilities.results.SuccessResult;
import javacamp.hrms.dataAccess.abstracts.PhotoDao;
import javacamp.hrms.entities.concretes.Photo;

@Service
public class PhotoManager implements PhotoService {

	private PhotoDao photoDao;
	private CloudinaryService cloudinaryService;
	
	@Autowired
	public PhotoManager(PhotoDao photoDao) {
		super();
		this.photoDao = photoDao;
	}

	@Override
	public Result add(Photo photo, MultipartFile multipartFile) throws IOException {
		Result result= new ErrorResult("Fotoğraf eklenemedi!");
		Map photoMap = cloudinaryService.photoUpload(multipartFile);
		photo.setPhotoUrl(photoMap.get("url").toString());
		if(!this.photoDao.getAllCvId().contains(photo.getCv().getCvId())) {
			result = new SuccessResult("Fotoğraf eklendi.");
			this.photoDao.save(photo);
		}
		return result;
	}

	@Override
	public Result update(int cvId, MultipartFile multipartFile) throws IOException {
		Map photoMap = cloudinaryService.photoUpload(multipartFile);
		this.photoDao.updatePhotoSetPhotoUrlForCv_cvId(photoMap.get("url").toString(), cvId);
		return new SuccessResult("Fotoğraf güncellendi.");
	}

	@Override
	public Result delete(String id) throws IOException {
		this.cloudinaryService.photoDelete(id);
		return new SuccessResult("Fotoğraf silindi.");
	}

}
