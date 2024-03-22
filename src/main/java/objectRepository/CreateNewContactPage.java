package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class CreateNewContactPage extends SeleniumUtility {//Rule1 : Create separate POM class for every page
	
	//Rule 2: Find element by using @findBy
	
	@FindBy(name = "lastname")
	
	private WebElement lastnameField;
	
	@FindBy(xpath = "//input[@type='submit']")
	
	private WebElement saveBtn;
	
	@FindBy (name = "leadsource")
	
	private WebElement leadSourceDropdown;
	
	//Rule 3 : Create parametarized Constructor
	
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Rule 4:create getter
	
	public WebElement getlastnameField()
	{
		return lastnameField;
		
	}
	public WebElement getsaveBtn()
	{
		return saveBtn;
	}
	
	public WebElement getleadSourceDropdown()
	{
		return leadSourceDropdown;
	}
	/**
	 * This method will create new contact and save
	 */
	public void CreateNewContact(String LASTNAME)
	{
		lastnameField.sendKeys(LASTNAME);
		saveBtn.click();
	}
	/**
	 * This method will create new contact with lead source and lastname field
	 * @param LASTNAME
	 */
	
	public void createNewContact(String LASTNAME ,String LEADSOURCE)
	{
		lastnameField.sendKeys(LASTNAME);
		
		handleDropDown(leadSourceDropdown, LEADSOURCE);
		
		saveBtn.click();
	}

}
