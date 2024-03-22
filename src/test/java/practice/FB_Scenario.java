package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FB_Scenario {
public static void main(String[] args) throws IOException {
	
	FileInputStream fil = new FileInputStream(".\\src\\test\\resources\\CommonData1");
	
	Properties p = new Properties();
	
	p.load(fil);
	
	String value=p.getProperty("url");
	
	FileInputStream file = new FileInputStream(".\\src\\test\\resources\\FB_data.xlsx");
	
	Workbook wb = WorkbookFactory.create(file);
	
	String name = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
	
	String pass = wb.getSheet("Sheet1").getRow(2).getCell(1).getStringCellValue();
	
	WebDriver driver = new ChromeDriver();
	
	driver.manage().window().maximize();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
	driver.get(value);
	
	driver.findElement(By.xpath("//input[@aria-label='Email address or phone number']")).sendKeys(name);
	
	driver.findElement(By.id("pass")).sendKeys(pass);
	
	driver.findElement(By.name("login")).click();
}
}
