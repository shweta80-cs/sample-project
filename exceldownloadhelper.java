package com.example.api.excelformat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.example.api.model.TableToImportInExcel;

public class exceldownloadhelper {
	
	public static String[] HEADERS= {
			"id",
			"applicanttype",
			"city",
			"address"
	};
	
	public static String  sheet_name="applicant_data";
	
	public static ByteArrayInputStream datatoexcel (List<TableToImportInExcel> list) throws IOException {
		
		
		//create excel workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		//create sheet
		Sheet sheet =  (Sheet) workbook.createSheet(sheet_name);
		
		//create row
		
		int i=0;
		Row row= sheet.createRow(i);
		for(i=0; i<HEADERS.length ;i++) {
			Cell cell= row.createCell(i);
			cell.setCellValue(HEADERS[i]);
			}
		
		//set row values
		int Rowindex=1;
		for(TableToImportInExcel tabledata:list) {
			
			Row datarow =sheet.createRow(Rowindex);
			Rowindex++;
			datarow.createCell(0).setCellValue(tabledata.getApplicantId());
			datarow.createCell(1).setCellValue(tabledata.getApplicanttypeid());
			datarow.createCell(1).setCellValue(tabledata.getCity());
			datarow.createCell(1).setCellValue(tabledata.getAddress());
			
		}
        workbook.write(out);
		
        
        
        
		return new ByteArrayInputStream(out.toByteArray());
		
		
	
	}

}
