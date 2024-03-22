package assignment;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.HomePage;

public class Delete6thContact extends BaseClass{
	
	@Test
	
	public void delete()
	{
		HomePage hp = new HomePage(driver);
		hp.clickContactsBtn();
		
		driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[8]/td[10]/a[text()='del']")).click();
	}
	
	
}
