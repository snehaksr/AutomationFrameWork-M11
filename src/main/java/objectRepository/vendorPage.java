package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class vendorPage {
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createNewVendorLookUpimg;

	public vendorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getcreateNewVendorLookUpimg() {
		return createNewVendorLookUpimg;

	}

	public void clickcreateNewVendorLookUpimg() {
		createNewVendorLookUpimg.click();
	}

}
