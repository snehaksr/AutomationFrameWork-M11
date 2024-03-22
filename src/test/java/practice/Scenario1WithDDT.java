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

public class Scenario1WithDDT {
public static void main(String[] args) throws IOException {
	//Read data from property file
	
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	
	Properties p = new Properties();
	
	p.load(fis);
	
	String value1 =p.getProperty("url");
	
	String value2 = p.getProperty("username");
	
	String value3 = p.getProperty("password");
	
	//Read data from excel
	
	FileInputStream file = new FileInputStream(".\\src\\test\\resources\\Data.xlsx");
	
	Workbook wb = WorkbookFactory.create(file);
	
	String lastname=wb.getSheet("Contacts").getRow(1).getCell(2).getStringCellValue();
	
	//launch the browser
	
	WebDriver driver = new ChromeDriver();

	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
	driver.get(value1);
	
	driver.findElement(By.name("user_name")).sendKeys(value2);
	
	driver.findElement(By.name("user_password")).sendKeys(value3);
	
	driver.findElement(By.id("submitButton")).click();
	
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
	
	Actions a = new Actions(driver);
	
	WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	
	a.moveToElement(ele).build().perform();
	
	driver.findElement(By.linkText("Sign Out")).click();
	
	driver.quit();


	
}

}

