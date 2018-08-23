package BasicEx;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtil  {

	
	//C:\Geetha(selenium)\eclipse-workspace\JAVA_Examples\src\Com\qa\transfora//TestData.xlsx
	
	public void GetDatafromExcel(){
		try{
		File src=new File("C:\\Geetha(selenium)\\eclipse-workspace\\JAVA_Examples\\src\\Com\\qa\\transfora\\TestData.xlsx");
		 
		   // load file
		   FileInputStream fis=new FileInputStream(src);
		 
		   // Load workbook
		   XSSFWorkbook wb=new XSSFWorkbook(fis);
		   
		   // Load sheet- Here we are loading first sheetonly
		      XSSFSheet sh1= wb.getSheetAt(0);
		 
		  // getRow() specify which row we want to read.		 
		  // and getCell() specify which column to read.
		  // getStringCellValue() specify that we are reading String data.
		      
		 for (int i = 0; i <sh1.getLastRowNum() ; i++) {
			 Row r=sh1.getRow(i);
			for (int j = 0; j <r.getLastCellNum() ; j++) {
				String uname=r.getCell(j).getStringCellValue();
				String password=r.getCell(j+1).getStringCellValue();
			}	 
			
		 }		 
		
	wb.close();
		 
	}catch (Exception e) {
		// TODO: handle exception
		System.out.println(e.getMessage());
	}
	}
	
	
}
