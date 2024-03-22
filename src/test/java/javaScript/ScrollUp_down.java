package javaScript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtilities.JavaScriptUtilities;
import genericUtilities.SeleniumUtility;

public class ScrollUp_down {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		SeleniumUtility sc= new SeleniumUtility();
		
		sc.maximizeWindow(driver);
		
		sc.addimplicitWait(driver);
		
		driver.get("https://demo.nopcommerce.com/");
		
		JavaScriptUtilities js = new JavaScriptUtilities();
		
		js.pageDown(driver);
		
		Thread.sleep(4000);
		
		js.pageUp(driver);
	}
}
