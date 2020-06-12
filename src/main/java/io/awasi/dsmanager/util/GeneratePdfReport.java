package io.awasi.dsmanager.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import io.awasi.dsmanager.entities.Student;

public class GeneratePdfReport {
	
	private static final Logger logger = LoggerFactory.getLogger(GeneratePdfReport.class);
	
	public static ByteArrayInputStream StudentReport(List<Student> students) throws DocumentException, MalformedURLException, IOException {

		Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        
        Font f=new Font(FontFamily.TIMES_ROMAN,30.0f,Font.BOLD,BaseColor.BLUE);
         
     // Creating an Area Break    
        Paragraph para = new Paragraph("LIST OF STUDENTS", f); 
        para.setSpacingAfter(22f);
        para.setAlignment(Element.ALIGN_CENTER);
        Paragraph para2 = new Paragraph(""); 
        
        String filename = "C:\\Users\\User\\Desktop\\project\\back end\\school.jpg";
        Image image = Image.getInstance(filename);
        image.setAlignment(Element.ALIGN_CENTER);
        
        
		try {
			 PdfPTable table = new PdfPTable(5);
	         table.setWidthPercentage(95);
	         table.setWidths(new int[]{1, 2, 2, 4, 2});
	         
	         Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	         
	         PdfPCell hcell;
	         hcell = new PdfPCell(new Phrase("Id", headFont));
	         hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	         table.addCell(hcell);
	         
	         hcell = new PdfPCell(new Phrase("First Name", headFont));
	         hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	         table.addCell(hcell);

	         hcell = new PdfPCell(new Phrase("Last Name", headFont));
	         hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	         table.addCell(hcell);
	         
	         hcell = new PdfPCell(new Phrase("Email", headFont));
	         hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	         table.addCell(hcell);
	         
	         hcell = new PdfPCell(new Phrase("Fee Paid", headFont));
	         hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
	         table.addCell(hcell);
	         
	         int i = 1;
	         
	         for (Student student : students) {
	        	
	        	 PdfPCell cell;
	        	 cell = new PdfPCell(new Phrase("" + i));
	             cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	             cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	             table.addCell(cell);
	             
	             cell = new PdfPCell(new Phrase(student.getUsers1().getFirstname()));
	             cell.setPaddingLeft(5);
	             cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	             cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	             table.addCell(cell);
	             
	             cell = new PdfPCell(new Phrase(student.getUsers1().getLastname()));
	             cell.setPaddingLeft(5);
	             cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	             cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	             table.addCell(cell);
	             
	             cell = new PdfPCell(new Phrase(student.getUsers1().getEmail()));
	             cell.setPaddingLeft(5);
	             cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	             cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	             table.addCell(cell);
	             if(student.getFeepaid() == null) {
	            	 student.setFeepaid(0.0);
	             }
	             cell = new PdfPCell(new Phrase(student.getFeepaid().toString()));
	             cell.setPaddingLeft(5);
	             cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	             cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	             table.addCell(cell);
	            
	             i++;
	         }
	         
	            PdfWriter.getInstance(document, out);
	            document.open();
	            document.add(image);
	            document.add(para);
	            document.add(para2);
	            document.add(para2);
	            document.add(para2);
	            document.add(para2);
	            document.add(table);

	            document.close();
		}catch (DocumentException ex) {
			logger.error("Error occurred", ex);
		}
		
		 return new ByteArrayInputStream(out.toByteArray());
	}

}
