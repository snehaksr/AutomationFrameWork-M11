package javaScript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtilities.JavaScriptUtilities;
import genericUtilities.SeleniumUtility;

public class Refresh {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		SeleniumUtility sc= new SeleniumUtility();
		
		sc.maximizeWindow(driver);
		
		sc.addimplicitWait(driver);
		
		driver.get("https://demo.nopcommerce.com/");
		
		JavaScriptUtilities js = new JavaScriptUtilities();
		
		js.refreshpageByje(driver);
	}
}
