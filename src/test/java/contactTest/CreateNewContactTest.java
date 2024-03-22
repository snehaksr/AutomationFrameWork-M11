package contactTest;

import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class CreateNewContactTest extends BaseClass   {
@Test(groups = "Smokesuite")
public void createNewContactWithMandatoryFields() throws EncryptedDocumentException, IOException, InterruptedException
{
	
    
    String lastname = ef.readDataFromExcelFile("Contacts", 1, 2);
	
	HomePage hp = new HomePage(driver);
	
	hp.clickContactsBtn();
	
	ContactsPage cp = new ContactsPage(driver);
	
	cp.clickoncreateContactLookUpimg();
	
	CreateNewContactPage cncp = new CreateNewContactPage(driver);
	
	cncp.CreateNewContact(lastname);
	
	ContactInfoPage ci = new ContactInfoPage(driver);
	
	String contactHeader =ci.captureContactHeader();
	
	Assert.assertTrue(contactHeader.contains(lastname));
	
	System.out.println(contactHeader);
	
	
	
}
}
