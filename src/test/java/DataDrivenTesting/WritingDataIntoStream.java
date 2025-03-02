package DataDrivenTesting;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataIntoStream {

	public static void main(String[] args) throws IOException {
		//Excel file-> workbook->sheet->rows->cells
		
		FileOutputStream file =new FileOutputStream(System.getProperty("user.dir")
				+"\\testData\\Myfile.xlsx");
		XSSFWorkbook workbook =new XSSFWorkbook();
		XSSFSheet sheet =workbook.createSheet("Data1");
		
		XSSFRow row1=sheet.createRow(0);
		row1.createCell(0).setCellValue("Java");
		row1.createCell(1).setCellValue("19");
		row1.createCell(2).setCellValue("Automation");
		
		XSSFRow row2 =sheet.createRow(1);
		row2.createCell(0).setCellValue("python");
		row2.createCell(1).setCellValue("20");
		row2.createCell(2).setCellValue("Automation");
		
		XSSFRow row3 =sheet.createRow(2);
		row3.createCell(0).setCellValue("C++");
		row3.createCell(1).setCellValue("32");
		row3.createCell(2).setCellValue("Automation");
		
		workbook.write(file);
		workbook.close();
		file.close();
		System.out.println("file created....");
		
		
		
		
		
	}

}
