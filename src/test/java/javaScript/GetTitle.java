package javaScript;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtilities.JavaScriptUtilities;
import genericUtilities.SeleniumUtility;

public class GetTitle {
	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		
		SeleniumUtility sc= new SeleniumUtility();
		
		sc.maximizeWindow(driver);
		
		sc.addimplicitWait(driver);
		
		driver.get("https://demo.nopcommerce.com/");
		
		JavaScriptUtilities js = new JavaScriptUtilities();
		
		String title=js.getTitleByJS(driver);
		
		System.out.println(title);
		
		driver.close();
}
}
