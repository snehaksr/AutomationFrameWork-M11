package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.HomePage;

public class Check5thCheckBox extends BaseClass{
@Test

public void checkbox5th()
{
	HomePage hp = new HomePage(driver);
	hp.clickContactsBtn();
	
	WebElement checkbox = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[7]/td/input[@type='checkbox']"));
	
	checkbox.click();
	
	
	if(checkbox.isSelected())
	{
		System.out.println("5th checkBox selected");
	}
	else
	{
		System.out.println("Not selected");
	}
}
}
