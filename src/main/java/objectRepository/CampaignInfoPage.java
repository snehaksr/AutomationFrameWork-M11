package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInfoPage {
@FindBy(xpath = "//span[@class='dvHeaderText']")
WebElement CampaignHeaderText;

public CampaignInfoPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);

}

public WebElement getCampaignHeaderTex()
{
	return CampaignHeaderText;
}
public String captureCampaignHeader()
{
	return CampaignHeaderText.getText();
}
}
