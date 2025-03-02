package DataDrivenTesting;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WrittingDynamicFormat {

		public static void main(String[] args) throws IOException {
			//Excel file-> workbook->sheet->rows->cells
			
			FileOutputStream file =new FileOutputStream(System.getProperty("user.dir")
					+"\\testData\\MyfileDynamic.xlsx");
			XSSFWorkbook workbook =new XSSFWorkbook();
			XSSFSheet sheet =workbook.createSheet("DynamicData");
			
			// if dynamic format data we want we can used scanner method 
			
			Scanner sc= new Scanner(System.in);
			
			System.out.println("Enter how many rows?");
			int NumberOfRows=sc.nextInt();
			System.out.println("Enter how many cell?");
			int NumberOfCells=sc.nextInt();
			
			for(int i=0;i<=NumberOfRows;i++) {
				XSSFRow currentRow=sheet.createRow(i);
				for(int j=0;j<NumberOfCells;j++) {
					XSSFCell cell =currentRow.createCell(j);
					cell.setCellValue(sc.next());
				}
			}
					workbook.write(file);
					workbook.close();
					file.close();
				System.out.println("file created....");
			}
			

	}


