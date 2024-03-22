package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consist of generic method to use Excel file
 * @author Sneha
 */
public class ExcelFileUtility {
/**
 * This method will read data from excelfile and return the value to caller
 * @param sheetName
 * @param rownum
 * @param cellnum
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	public String readDataFromExcelFile(String sheetName,int rownum,int cellnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream(".\\src\\test\\resources\\Data.xlsx");
		
		Workbook wb = WorkbookFactory.create(file);
		
		String value=wb.getSheet(sheetName).getRow(rownum).getCell(cellnum).getStringCellValue();
		
		return value;
		
	}
}
