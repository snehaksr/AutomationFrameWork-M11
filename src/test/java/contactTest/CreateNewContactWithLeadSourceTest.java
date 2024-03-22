package contactTest;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import genericUtilities.BaseClass;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
@Listeners(genericUtilities.ListenersImplementation.class)
public class CreateNewContactWithLeadSourceTest extends BaseClass{
	@Test(groups = "RegressionSuit")
	public void createNewContactWithLeadSource() throws EncryptedDocumentException, IOException, InterruptedException
	
	{
		
		String lastname = ef.readDataFromExcelFile("Contacts", 4, 2);
		
		String leadSource = ef.readDataFromExcelFile("Contacts", 4, 3);

		HomePage hp = new HomePage(driver);

		hp.clickContactsBtn();

		ContactsPage cp = new ContactsPage(driver);

		cp.clickoncreateContactLookUpimg();

		CreateNewContactPage cncp = new CreateNewContactPage(driver);

		cncp.createNewContact(lastname, leadSource);
		
		Thread.sleep(2000);
		
		//Assert.fail();
		
		Thread.sleep(2000);

		ContactInfoPage ci = new ContactInfoPage(driver);

		String contactHeader = ci.captureContactHeader();
		
		Assert.assertTrue(contactHeader.contains(lastname));

		System.out.println(contactHeader);
		System.out.println("Hi all");
		

	}
	
	@Test
	public void Sample()
	{
		System.out.println("Demo");
	}
}
