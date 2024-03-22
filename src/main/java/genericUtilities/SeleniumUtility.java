package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consists of generic method related to selenium WebDriver
 * 
 * @author Sneha
 */
public class SeleniumUtility {
	/**
	 * This method will maximize the window
	 * 
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method will minimize the window
	 * 
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}

	/**
	 * This method will add implicitly wait for 10 seconds
	 * 
	 * @param driver
	 * @param times
	 */
	public void addimplicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	/**
	 * This method will wait for 30 sec for web element to be visible
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitforElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method will wait for 30 sec for web element to be clickable
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitforElementToBeclickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method will handle dropdown by index
	 * 
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element, int index) {
		Select s = new Select(element);

		s.selectByIndex(index);
	}

	/**
	 * This method will handle dropdown by Value
	 * 
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element, String value) {
		Select s = new Select(element);

		s.selectByValue(value);
	}

	/**
	 * This method will handle dropdown by text
	 * 
	 * @param text
	 * @param element
	 */
	public void handleDropDown(String text, WebElement element) {
		Select s = new Select(element);

		s.selectByVisibleText(text);
	}

	/**
	 * This method will perform mouse over action on web element
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseOverAction(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);

		a.moveToElement(element).build().perform();
	}

	/**
	 * This method will perform right click action on web element
	 * 
	 * @param driver
	 * @param element
	 */
	public void contextClickAction(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);

		a.contextClick(element).build().perform();
	}

	/**
	 * This method will perform double click action on web element
	 * 
	 * @param driver
	 * @param element
	 */
	public void doubleclickAction(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);

		a.doubleClick(element).build().perform();
	}

	/**
	 * This method will perform drag and drop action on web element
	 * 
	 * @param driver
	 * @param element
	 */
	public void dragAndDrop(WebDriver driver, WebElement src, WebElement tgr) {
		Actions a = new Actions(driver);

		a.dragAndDrop(src, tgr).build().perform();
	}
/**
 * This method will switch to frame based on index
 * @param driver
 * @param index
 */
	public void switchToframe(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * This method will switch to frame based on Frame name or ID
	 * @param driver
	 * @param index
	 */

	public void switchToframe(WebDriver driver, String framenameorID) {
		driver.switchTo().frame(framenameorID);
	}
	/**
	 * This method will switch to frame based on element
	 * @param driver
	 * @param index
	 */
	public void switchToframe(WebDriver driver, WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	/**
	 * This method will accept the alert popup
	 * 
	 * @param driver
	 */
	public void simpleAlertaccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * This method will dismiss the alert popup
	 * 
	 * @param driver
	 */
	public void simpleAlertdismiss(WebDriver driver) {
	 driver.switchTo().alert().dismiss();
	}

	/**
	 * This method will send data into alert popup
	 * 
	 * @param driver
	 */
	public void alertgetText(WebDriver driver,String text) {
		 driver.switchTo().alert().sendKeys(text);	
	}
	/**
	 *  This method will get text from alert popup
	 * @param driver
	 */
	public void alertgetText(WebDriver driver) {
		 driver.switchTo().alert().getText();	
	}
	/**
	 * This method will Scroll up the page by -500 units
	 * @param driver
	 */
	public void scrollup(WebDriver driver)
	{
		JavascriptExecutor je = (JavascriptExecutor)driver;
		
		je.executeScript("window.ScrollBy(0,-500);","");
	}
	/**
	 * This method will Scroll down the page by 500 units
	 * @param driver
	 */
	public void scrollDown(WebDriver driver)
	{
		JavascriptExecutor je = (JavascriptExecutor)driver;
		
		je.executeScript("window.ScrollBy(0,500);","");
	}
	/**
	 * This method used to take screen shot and Store it in required location
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException
	 */
	public String takeScreenshot(WebDriver driver ,String screenShotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File scr=ts.getScreenshotAs(OutputType.FILE);
		
		File des = new File(".\\screenshot\\"+screenShotName+".png");
		
		Files.copy(scr, des);
		
		return des.getAbsolutePath(); //used in Extent reports
				
	}

}
