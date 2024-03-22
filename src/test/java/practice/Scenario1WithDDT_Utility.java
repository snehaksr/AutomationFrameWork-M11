package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtilities.SeleniumUtility;
import objectRepository.LoginPage;

public class Scenario1WithDDT_Utility {
public static void main(String[] args) throws IOException {
	FileInputStream fil = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	
	Properties p = new Properties();
	
	p.load(fil);
	
	String URL=p.getProperty("url");
	
	String USERNAME = p.getProperty("username");
	
	String PASSWORD = p.getProperty("password");
	
	FileInputStream file = new FileInputStream(".\\src\\test\\resources\\Data.xlsx");
	
	Workbook wb = WorkbookFactory.create(file);
	
	String lastname = wb.getSheet("Contacts").getRow(1).getCell(2).getStringCellValue();
	
	WebDriver driver = new ChromeDriver();
	
	SeleniumUtility su= new SeleniumUtility();
	
	su.maximizeWindow(driver);
	su.addimplicitWait(driver);
	
	driver.get(URL);
	
	//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	
	//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	
    //driver.findElement(By.id("submitButton")).click();
	
	LoginPage lp = new LoginPage(driver);
	
	lp.loginToApp(USERNAME, PASSWORD);
	
	//lp.getUserNameEdt().sendKeys(USERNAME);
	
	//lp.getPasswordEdt().sendKeys(PASSWORD);
	
	//lp.getLoginBtn().click();
	
	driver.findElement(By.linkText("Contacts")).click();
	
	driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	
	driver.findElement(By.name("lastname")).sendKeys(lastname);
	
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	
	String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	
	if(contactHeader.contains(lastname))
	{
		System.out.println("PASS");
	}
	else
	{
		System.out.println("FAIL");
	}
	WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	su.mouseOverAction(driver, ele);
    
	driver.findElement(By.linkText("Sign Out")).click();
	
	driver.quit();

	
}
}
