package com.example.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.api.repository.TableToImportExcelRepo;

@SpringBootTest
class ExcelApiApplicationTests {
	
	@Autowired
	private TableToImportExcelRepo tableToImportExcelRepo;
	
	
	@Test
	public void testTableToImportExcelRepo(){
		System.out.println("Test Started");
		tableToImportExcelRepo.findAll().forEach(tabletoimport->System.out.println(tabletoimport.getCity()));
	}

	@Test
	void contextLoads() {
	}

}
