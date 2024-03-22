package javaScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtilities.JavaScriptUtilities;
import genericUtilities.SeleniumUtility;

public class Flash {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		SeleniumUtility sc= new SeleniumUtility();
		
		sc.maximizeWindow(driver);
		
		sc.addimplicitWait(driver);
		
		driver.get("https://demo.nopcommerce.com/");
		
		JavaScriptUtilities js = new JavaScriptUtilities();
		
		WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));

		js.flash(logo, driver);
		
		
	}
}
