package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorInfoPage {
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement vendorHeaderText;

	public VendorInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getvendorHeaderText() {
		return vendorHeaderText;
	}

	public String captureVendorHeader() {
		return vendorHeaderText.getText();

	}
}
