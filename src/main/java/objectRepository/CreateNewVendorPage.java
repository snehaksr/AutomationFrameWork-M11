package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewVendorPage {
	@FindBy(name = "vendorname")
	private WebElement venderNameField;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement saveBtn;

	public CreateNewVendorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getvenderNameField()
	{
		return venderNameField;
	}
	public WebElement getsaveBtn()
	{
		return saveBtn;
	}
	
	public void createNewVendor(String VENDERNAME)
	{
		venderNameField.sendKeys(VENDERNAME);
		
		saveBtn.click();
	}
}
