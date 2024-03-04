package com.example.api.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.excelformat.exceldownloadhelper;
import com.example.api.model.TableToImportInExcel;
import com.example.api.repository.TableToImportExcelRepo;

@Service
public class excelservice {
	
	@Autowired
	private TableToImportExcelRepo tableToImportExcelRepo;
	
	public ByteArrayInputStream getActualData() throws IOException {
		List<TableToImportInExcel> all =tableToImportExcelRepo.findAll();
		ByteArrayInputStream byteArrayInputStream= exceldownloadhelper.datatoexcel(all);
		
		return byteArrayInputStream;
		
	}

}
