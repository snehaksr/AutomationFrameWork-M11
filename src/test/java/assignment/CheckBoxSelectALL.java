package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.HomePage;

public class CheckBoxSelectALL extends BaseClass{
	
	
@Test 

public void selectAll()
{
	HomePage hp = new HomePage(driver);
	hp.clickContactsBtn();
	
	WebElement checkbox = driver.findElement(By.xpath("//table[@class='lvt small']//td[1]//input[@name='selectall']"));
	
	checkbox.click();
	
	System.out.println(checkbox);
	
	if(checkbox.isSelected())
	{
		System.out.println("All CheckBox Selected");
	}
	else
	{
		System.out.println("CheckBox not selected");
	}
}
}
