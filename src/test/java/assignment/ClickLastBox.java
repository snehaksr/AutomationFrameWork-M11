package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.HomePage;

public class ClickLastBox extends BaseClass{
@Test 

public void lastBox()
{
	HomePage hp = new HomePage(driver);
	hp.clickContactsBtn();
	
	WebElement lastCheckBox = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[22]/td/input[@type='checkbox']"));
	
	lastCheckBox.click();
}
}
