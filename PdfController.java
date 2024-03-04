package com.example.api.controller;


import java.io.ByteArrayInputStream;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.api.service.Pdfservice;

@Controller //u can use restcontroller as well 
@RequestMapping("/pdf")
public class PdfController {
	
	
	
	@Autowired
	private Pdfservice pdfservice;
	
	@GetMapping("/createPdf")
	public ResponseEntity<InputStreamResource> createpdf() {
		
		ByteArrayInputStream outpdf = pdfservice.createPdf();
		HttpHeaders httpheaders = new HttpHeaders();
		httpheaders.add("Content-Disposition", "inline;file=sample.pdf");
		return ResponseEntity
				.ok()
				.headers(httpheaders)
				.contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(outpdf));
	}

}
