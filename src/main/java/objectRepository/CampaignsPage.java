package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsPage {
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createCampaignsLookupimg;

	public CampaignsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateCampaignsLookupimg() {
		return createCampaignsLookupimg;
	}
	/**
	 * This method will click on create Campaigns look up image
	 */
	public void clickoncreateCampaignsLookUpimg()
	{
		createCampaignsLookupimg.click();
	}

}
