package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {//Rule:1 Create a Separate POM class for every WebPage
	
	//Rule:2 Find webelement using @FindBy
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	
	private WebElement createContactLookUpimg;
	
	//Rule: 3 Create parameterized constructor
	
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Rule 4 Provide getter
	
	public WebElement getcreateContactBtn()
	{
		return createContactLookUpimg;
		
	}
	/**
	 * This method will click on create contact look up image
	 */
	public void clickoncreateContactLookUpimg()
	{
		createContactLookUpimg.click();
	}
	
	
}
