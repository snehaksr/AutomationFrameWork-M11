package campaignTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.CampaignInfoPage;
import objectRepository.CampaignsPage;
import objectRepository.CreateNewCampaignsPage;
import objectRepository.HomePage;

public class CreateNewCampaignTest extends BaseClass{
	
@Test
public void createNewCampaign() throws EncryptedDocumentException, IOException
{
	HomePage hp = new HomePage(driver);
	
	hp.clickcampaignsBtn();
	
	CampaignsPage cp =new CampaignsPage(driver);
	
	cp.clickoncreateCampaignsLookUpimg();
	
	CreateNewCampaignsPage cncp = new CreateNewCampaignsPage(driver);
	
	String campaignname = ef.readDataFromExcelFile("Campaigns", 1, 2);
	
	cncp.CreateNewCampaigns(campaignname);
	
	CampaignInfoPage cip = new CampaignInfoPage(driver);
	
	String camaignHeader=cip.captureCampaignHeader();
	
	Assert.assertTrue(camaignHeader.contains(campaignname));
	
	System.out.println(camaignHeader);
}
}
