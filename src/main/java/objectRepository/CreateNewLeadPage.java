package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewLeadPage {
	@FindBy(name = "lastname")
	private WebElement lastnameField;

	@FindBy(name = "company")
	private WebElement companyNameField;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement saveBtn;

	public CreateNewLeadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getlastnameField() {
		return lastnameField;
	}

	public WebElement getcompanyNameField() {
		return companyNameField;
	}

	public WebElement getsaveBtn() {
		return saveBtn;
	}

	public void createNewLead(String LASTNAME, String COMPANYNAME) {
		lastnameField.sendKeys(LASTNAME);

		companyNameField.sendKeys(COMPANYNAME);
		
		saveBtn.click();
	}
}
