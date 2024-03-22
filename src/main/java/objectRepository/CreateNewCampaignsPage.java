package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewCampaignsPage {
	@FindBy(name = "campaignname")
	WebElement campaignNameField;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement saveBtn;
	
	public CreateNewCampaignsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getcampaignNameField()
	{
		return campaignNameField;
	}
	public WebElement getsaveBtn()
	{
		return saveBtn;
	}
	
	public void CreateNewCampaigns(String CAMPAIGNNAME)
	{
		campaignNameField.sendKeys(CAMPAIGNNAME);
		saveBtn.click();
	}
}
