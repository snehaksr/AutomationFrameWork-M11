package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")

	private WebElement createLeadLookupimg;

	public LeadsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateLeadLookupimg() {
		return createLeadLookupimg;
	}

	public void clickoncreateLeadLookupimg() {
		createLeadLookupimg.click();
	}
}
