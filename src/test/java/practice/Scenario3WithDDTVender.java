package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import genericUtilities.SeleniumUtility;

public class Scenario3WithDDTVender {
public static void main(String[] args) throws IOException {
	FileInputStream fil = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	
	Properties p = new Properties();
	
	p.load(fil);
	
	String URL = p.getProperty("url");
	
	String USERNAME = p.getProperty("username");
	
	String PASSWORD = p.getProperty("password");
	
	FileInputStream file = new FileInputStream(".\\src\\test\\resources\\Data.xlsx");
	
	Workbook wb = WorkbookFactory.create(file);
	
	String vendername = wb.getSheet("Venders").getRow(1).getCell(2).getStringCellValue();
	
	SeleniumUtility su= new SeleniumUtility();
	
	WebDriver driver = new ChromeDriver();
	
	su.maximizeWindow(driver);
	
	su.addimplicitWait(driver);
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
	driver.get(URL);
	
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	
	driver.findElement(By.id("submitButton")).click();
	
	WebElement more = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
	
	su.mouseOverAction(driver, more);
	
	driver.findElement(By.linkText("Vendors")).click();
	
	driver.findElement(By.xpath("//img[@alt='Create Vendor...']")).click();
	
	driver.findElement(By.name("vendorname")).sendKeys(vendername);
	
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	
	 String names = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
	
	if (names.contains(vendername)) {
		System.out.println("PASS");
	} else {
      System.out.println("FAIL");
	}
	
	WebElement signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	
	su.mouseOverAction(driver, signout);
	
	driver.findElement(By.linkText("Sign Out")).click();
	
	driver.quit();
	
}
}
