package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario3 {
public static void main(String[] args) {
	        //Login to application with valid user name and password
			WebDriver driver = new ChromeDriver();

			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			
			driver.get("http://localhost:8888");
			
			driver.findElement(By.name("user_name")).sendKeys("admin");
			
			driver.findElement(By.name("user_password")).sendKeys("admin");
			
			driver.findElement(By.id("submitButton")).click();	
			//Navigate to Vendors module
			driver.findElement(By.linkText("Vendors")).click();
			//Click on create contact look up image ( (+) icon)
			driver.findElement(By.xpath("//img[@alt='Create Vendor...']")).click();
			//Create Lead with Mandatory information
			
			driver.findElement(By.name("vendorname")).sendKeys("Yazhisai");
			
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			
			String ele = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
			
			if(ele.contains("Yazhisai"))
			{
				System.out.println("PASS");
			}
			else
			{
				System.out.println("FAIL");
			}
			
			//Logout of App
			Actions a = new Actions(driver);
			
	        WebElement signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			
			a.moveToElement(signout).build().perform();
			
			driver.findElement(By.linkText("Sign Out")).click();
			
			driver.quit();
			
}
}
