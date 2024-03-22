package genericUtilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtilities {

	public void drawBorder(WebElement element,WebDriver driver)
	{
		JavascriptExecutor je = (JavascriptExecutor) driver;
		
		je.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	public String getTitleByJS(WebDriver driver)
	{
		JavascriptExecutor je = (JavascriptExecutor) driver;
		
		String title=je.executeScript("return document.title;").toString();
		
		return title;
	}
	
	public void clickElementByJe(WebElement element,WebDriver driver)
	{
		JavascriptExecutor je = (JavascriptExecutor)driver;
		
		je.executeScript("arguments[0].click();", element);
	}
	public void alertpopupByje(WebDriver driver,String message)
	{
		JavascriptExecutor je = (JavascriptExecutor)driver;
		
		je.executeScript("alert('"+message+"')");
	}
	public void refreshpageByje(WebDriver driver)
	{
		JavascriptExecutor je = (JavascriptExecutor)driver;
		
		je.executeScript("history.go(0)");
	}
	
	public void pageDown(WebDriver driver)
	{
		JavascriptExecutor je = (JavascriptExecutor)driver;
		
		je.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
	//	je.executeScript("window.ScrollBy(0,500);","");
	}
	public void pageUp(WebDriver driver)
	{
		JavascriptExecutor je = (JavascriptExecutor)driver;
		
		je.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
		
		//je.executeScript("window.ScrollBy(0,-500);","");
	}
	public void zoomByje(WebDriver driver)
	{
		JavascriptExecutor je = (JavascriptExecutor)driver;
		
		je.executeScript("document.body.style.zoom='100%'");
	}
	public void flash(WebElement element  ,WebDriver driver)
	{
		JavascriptExecutor je = (JavascriptExecutor)driver;
		
		String bgcolor=element.getCssValue("backgroundColour");
		
		for(int i=1;i<10;i++)
		{
			changecolor("#000000",element,driver);
			changecolor(bgcolor,element,driver);
			
		}
		
	}
	public void changecolor(String colour, WebElement element, WebDriver driver)
	{
		JavascriptExecutor je = (JavascriptExecutor)driver;
		
		je.executeScript("arguments[0].style.backgroundColour = '"+colour+"'",element);
		
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			
		}
	}
}
