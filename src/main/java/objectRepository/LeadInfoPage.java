package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadInfoPage {
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement leadHeaderText;

	public LeadInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getleadHeaderText() {
		return leadHeaderText;

	}

	public String captureLeadHeaderText() {
		return leadHeaderText.getText();

	}
}
