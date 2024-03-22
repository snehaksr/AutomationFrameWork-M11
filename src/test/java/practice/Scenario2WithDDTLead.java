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

public class Scenario2WithDDTLead {
	public static void main(String[] args) throws IOException {
		FileInputStream fil = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");

		Properties p = new Properties();

		p.load(fil);

		String URL = p.getProperty("url");

		String USERNAME = p.getProperty("username");

		String PASSWORD = p.getProperty("password");

		FileInputStream file = new FileInputStream(".\\src\\test\\resources\\Data.xlsx");

		Workbook wb = WorkbookFactory.create(file);

		String lastname = wb.getSheet("Lead").getRow(1).getCell(2).getStringCellValue();

		String company = wb.getSheet("Lead").getRow(1).getCell(3).getStringCellValue();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get(URL);
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Leads")).click();
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		
		driver.findElement(By.name("company")).sendKeys(company);
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String verify = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(verify.contains(lastname))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
		
		Actions a = new Actions(driver);
		
		WebElement signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		a.moveToElement(signout).build().perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		
		driver.quit();

	}
}
