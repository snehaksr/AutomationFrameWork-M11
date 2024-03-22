package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	//Step 1 : Open the document in java 
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Data.xlsx");
	//Step 2 : Create a workbook
	
	Workbook wb = WorkbookFactory.create(fis);
	//Step 3 : Navigate to Required sheet
	
	Sheet sh=wb.getSheet("Contacts");
	//Step 4 : Navigate to Required row
	
	Row r=sh.getRow(4);
	//Step 5 : Navigate to Required cell
	
	Cell cl=r.getCell(3);
	//Step 6 : Capture the data inside the cell
	
	String value=cl.getStringCellValue();
	
	System.out.println(value);
	
}
}
