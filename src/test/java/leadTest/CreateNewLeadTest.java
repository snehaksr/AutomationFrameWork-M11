package leadTest;

import java.io.FileInputStream;
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
import objectRepository.CreateNewLeadPage;
import objectRepository.HomePage;
import objectRepository.LeadInfoPage;
import objectRepository.LeadsPage;
import objectRepository.LoginPage;

public class CreateNewLeadTest extends BaseClass{
@Test
public void createNewLead() throws EncryptedDocumentException, IOException, InterruptedException
{
	
	String lastname = ef.readDataFromExcelFile("Lead", 1, 2);
	String company = ef.readDataFromExcelFile("Lead", 1, 3);
	
	HomePage hp = new HomePage(driver);
	
	hp.clickLeadBtn();
	
	LeadsPage lep = new LeadsPage(driver);
	
	lep.clickoncreateLeadLookupimg();
	
	CreateNewLeadPage cnlp = new CreateNewLeadPage(driver);
	
	cnlp.createNewLead(lastname, company);
	
	LeadInfoPage lip = new LeadInfoPage(driver);
	
	String leadHeader = lip.captureLeadHeaderText();
	
	Assert.assertTrue(leadHeader.contains(lastname));
	
			
}
}
