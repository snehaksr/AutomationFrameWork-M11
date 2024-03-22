package vendorTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.CreateNewVendorPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.VendorInfoPage;
import objectRepository.vendorPage;

public class CreateNewVendorTest extends BaseClass {
	@Test
	public void createNewVendor() throws EncryptedDocumentException, IOException, InterruptedException
	{
        ExcelFileUtility ef = new ExcelFileUtility();
        
        String vendername = ef.readDataFromExcelFile("Venders", 1, 2);

		HomePage hp = new HomePage(driver);
		
		WebElement more = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
		su.mouseOverAction(driver, more);

		hp.clickvendorBtn();

		vendorPage vp = new vendorPage(driver);

		vp.clickcreateNewVendorLookUpimg();

		CreateNewVendorPage cnvp = new CreateNewVendorPage(driver);

		cnvp.createNewVendor(vendername);

		VendorInfoPage vip = new VendorInfoPage(driver);

		String vendorText = vip.captureVendorHeader();

		Assert.assertTrue(vendorText.contains(vendername));
		
		System.out.println(vendorText);

	}
}
