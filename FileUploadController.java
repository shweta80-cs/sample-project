package com.example.api.controller;




// i have imported logger from the below two import and entered content type in postman corresponding to the document i am uploading
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;

import java.util.Arrays;

import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {
	//private LoggerContext context = new LoggerContext();
	//private Logger logger = context.getLogger(FileUploadController.class);
	
	private Logger logger = (Logger) LoggerFactory.getLogger(FileUploadController.class); // with this also its working 
	
	
	@PostMapping("/upload_files")
	public ResponseEntity<?> uploadmultiplefiles(@RequestParam("images") MultipartFile[] files){
		
		//this.logger.info(files.length+"number of files uploaded");
		this.logger.info(files.length +""+ "number of files uploaded");
		Arrays.stream(files).forEach(multipartFile ->{
			logger.info("file name :{}", multipartFile.getOriginalFilename());
			logger.info("file type: {}", multipartFile.getContentType());
			logger.info("file size:{}", multipartFile.getSize());
			System.out.println("you have completed uploading file api");
		});
		return ResponseEntity.ok("file uploaded successfully");
		
		
		
		
		
		
	} 

}
