package com.example.api.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;


@Service
public class Pdfservice {

	private Logger logger = LoggerFactory.getLogger(Pdfservice.class);
	public ByteArrayInputStream createPdf() {
		logger.info("PDF creation started.......");
		String title ="Generate PV2";
		String content = "Please enter the name and witness of two person";
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		Document document = new Document();
		
		
		PdfWriter.getInstance(document, out); //whateever the text u will write on document will automatically write into out
		
		document.open();
		
		Font titlefont= FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20);
		 
		Paragraph titleparapgraph = new Paragraph(title , titlefont);
		titleparapgraph.setAlignment(Element.ALIGN_CENTER);
		document.add(titleparapgraph);
		
		Font parafont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10);
		Paragraph contentparagraph = new Paragraph(content ,parafont);
		contentparagraph.setAlignment(Element.ALIGN_LEFT);
		document.add(contentparagraph);
		
		document.close();
		
		
		return new ByteArrayInputStream(out.toByteArray());
		/*try {
			
		}catch(DocumentException e) {
			e.printStackTrace();
			
		} */
		
		
		
	}
}
