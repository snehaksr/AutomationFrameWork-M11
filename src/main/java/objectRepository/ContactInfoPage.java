package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	@FindBy(xpath = "//span[@class='dvHeaderText']")

	private WebElement contactHeaderText;

	public ContactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement gettitleName() {
		return contactHeaderText;
	}
	
	//business library
	/**
	 * This method will capture header text and return it to caller
	 * @return
	 */
	public String captureContactHeader()
	{
		return contactHeaderText.getText();
		
	}
}
