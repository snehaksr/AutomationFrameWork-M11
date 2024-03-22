package javaScript;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import genericUtilities.JavaScriptUtilities;
import genericUtilities.SeleniumUtility;

public class DrawBorders {
public static void main(String[] args) throws IOException {
	WebDriver driver = new ChromeDriver();
	
	SeleniumUtility sc= new SeleniumUtility();
	
	sc.maximizeWindow(driver);
	
	sc.addimplicitWait(driver);
	
	driver.get("https://demo.nopcommerce.com/");
	
	WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
	
	JavaScriptUtilities js = new JavaScriptUtilities();
	
	js.drawBorder(logo,driver);
	
	TakesScreenshot ts = (TakesScreenshot)driver;
	
	File src=ts.getScreenshotAs(OutputType.FILE);
	
	File tgr = new File(".\\screenshot\\logo.png");
	
	FileHandler.copy(src, tgr);

	
	
}
}
