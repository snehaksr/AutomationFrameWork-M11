package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class HomePage extends  SeleniumUtility {//Rule1: Create separae class for every page
	
	//Rule 2: Identify the web element using @FindBy
	//Declaration
	@FindBy(linkText = "Contacts")
	private WebElement contactsBtn;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement signoutImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutBtn;
	
	@FindBy (linkText = "Leads")
	private WebElement leadBtn;
	
	@FindBy (linkText = "Vendors")
	private WebElement vendorBtn;
	
	@FindBy (linkText = "Campaigns")
	private WebElement campaignsBtn;
	
	
	//Rule 3 Create parametarized constructor
	//Initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule4: Provide getter
	//Utilization
	public WebElement getContactsBtn() {
		return contactsBtn;
	}

	public WebElement getSignoutImg() {
		return signoutImg;
	}

	public WebElement getSignoutBtn() {
		return signoutBtn;
	}
	
	public WebElement getleadBtn() {
		return leadBtn;
	}
		public WebElement getvendorBtn() {
			return vendorBtn;
		
	}
		public WebElement getcampaignsBtn()
		{
			return campaignsBtn;
			
		}
	/**
	 * This method will click on contact link
	 */
		public void clickContactsBtn()
		{
			contactsBtn.click();
		}
		/**
		 * This method will perform logout application
		 * @param driver
		 * @throws InterruptedException
		 */
		public void logOutApp(WebDriver driver) throws InterruptedException
		{
			mouseOverAction(driver,signoutImg );
			
			Thread.sleep(1000);
			
			signoutBtn.click();
		}
		
		public void clickLeadBtn()
		{
			leadBtn.click();
		}
		
		public void clickvendorBtn()
		{
			vendorBtn.click();
		}
		
		public void clickcampaignsBtn()
		{
			campaignsBtn.click();
		}
	
 
}
