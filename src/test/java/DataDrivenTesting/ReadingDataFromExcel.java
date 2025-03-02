package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.apache.poi.xssf.binary.XSSFBUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromExcel {

	public static void main(String[] args) throws IOException {
	
		//Excel file-> workbook->sheet->rows->cells
		
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+
				"\\testData\\Data.xlsx");
		XSSFWorkbook workbook =new XSSFWorkbook(file);
		XSSFSheet Sheet=workbook.getSheet("Sheet1");
		int totalrows=Sheet.getLastRowNum();
		int totalcells=Sheet.getRow(0).getLastCellNum();
		System.out.println("Number of rows:"+totalrows);
		System.out.println("Number of cells:"+totalcells);
		
		for(int i=0;i<=totalrows;i++) {
			XSSFRow currentRow=Sheet.getRow(i);
		
		for (int j=0;j<totalcells;j++) {
			XSSFCell cell=currentRow.getCell(j);
			System.out.println(cell.toString()+"\t");  //to string method is used for give all the xl data
			
		}
		System.out.println();
	}
		workbook.close();
		file.close();

}
}