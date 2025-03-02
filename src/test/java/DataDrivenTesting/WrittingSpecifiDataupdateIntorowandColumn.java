package DataDrivenTesting;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WrittingSpecifiDataupdateIntorowandColumn {

		public static void main(String[] args) throws IOException {
			//Excel file-> workbook->sheet->rows->cells
			
			FileOutputStream file =new FileOutputStream(System.getProperty("user.dir")
					+"\\testData\\MyfileDynamicRandom.xlsx");
			XSSFWorkbook workbook =new XSSFWorkbook();
			XSSFSheet sheet =workbook.createSheet("DynamicData");
			
			XSSFRow row=sheet.createRow(2);
			XSSFCell cell =row.createCell(5);
			cell.setCellValue("Welcome");

			workbook.write(file);
			workbook.close();
			file.close();
		System.out.println("file created....");
			

	}

}
