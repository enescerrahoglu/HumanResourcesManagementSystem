package javacamp.hrms.api.controllers;

import java.io.IOException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javacamp.hrms.business.abstracts.PhotoService;
import javacamp.hrms.core.utilities.results.DataResult;
import javacamp.hrms.entities.concretes.Photo;

@RestController
@RequestMapping("/api/photos")
@CrossOrigin
public class PhotosController {
	private PhotoService photoService;

	@Autowired
	public PhotosController(PhotoService photoService) {
		super();
		this.photoService = photoService;
	}
	
	@GetMapping("/getAll")
	public DataResult<Photo> getAll(){
		return null;
	}
	
	@PostMapping("/photoAdd")
	public ResponseEntity<?> upload(@ModelAttribute("photo") Photo photo,@RequestParam("multipartFile") MultipartFile multipartFile) throws IOException{
		return new ResponseEntity<>(this.photoService.add(photo, multipartFile), HttpStatus.OK);
	}
	
	@PostMapping("/photoUpdate")
	@Transactional
	public ResponseEntity<?> update(int cvId, MultipartFile multipartFile) throws IOException{
		return new ResponseEntity<>(this.photoService.update(cvId, multipartFile), HttpStatus.OK);
	}
	
	@DeleteMapping("/photoDelete")
	public ResponseEntity<?> delete(@PathVariable("id") String id) throws IOException{
		return new ResponseEntity<>(this.photoService.delete(id), HttpStatus.OK);
	}
	
}
