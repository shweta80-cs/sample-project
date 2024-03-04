package com.example.api.controller;


import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.service.excelservice;

import jakarta.annotation.Resource;

@RestController
@RequestMapping("/categories")
public class excelcontroller {
	
	@Autowired
	private excelservice Excelservice;
	
	
	@RequestMapping("/excel")
	public ResponseEntity<InputStreamResource> download() throws IOException{
		String filename = "Applicanttabledata.xlsx";
		ByteArrayInputStream  actualdata = Excelservice.getActualData();
		InputStreamResource file = new InputStreamResource(actualdata);
		
		/*ResponseEntity<Resource> body =ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION , "attachment ; filename= "+filename).contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
				.body(file);
		
		return body;*/
		
		return ResponseEntity.ok()
		        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
		        .contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(file);
				
				
	}
	
	
	@RequestMapping("/pdf")
	public ResponseEntity<InputStreamResource> downloadpdf() throws IOException{
		String filename = "Applicanttabledata.pdf";
		ByteArrayInputStream  actualdata = Excelservice.getActualData();
		InputStreamResource file = new InputStreamResource(actualdata);
		
		/*ResponseEntity<Resource> body =ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION , "attachment ; filename= "+filename).contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
				.body(file);
		
		return body;*/
		
		return ResponseEntity.ok()
		        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
		        .contentType(MediaType.parseMediaType("application/pdf")).body(file);
				
				
	}
}
