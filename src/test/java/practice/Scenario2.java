package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario2 {
	public static void main(String[] args) {
		//Login to application with valid user name and password
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("http://localhost:8888");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		
		driver.findElement(By.name("user_password")).sendKeys("admin");
		
		driver.findElement(By.id("submitButton")).click();	
		//Navigate to Leads module
		driver.findElement(By.linkText("Leads")).click();
		//Click on create contact look up image ( (+) icon)
		driver.findElement(By.xpath("//img[@alt='Create Lead...']")).click();
		//Create Lead with Mandatory information
		
		driver.findElement(By.name("lastname")).sendKeys("SnehaM");
		
		driver.findElement(By.name("company")).sendKeys("ITC");
		
		//Click on save
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	
	    //Verify for New Lead
		
		String lead = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(lead.contains("SnehaM"))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
		
		//Logout of App
		Actions a = new Actions(driver);
		
        WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		a.moveToElement(ele).build().perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		
		driver.quit();
	}
	

}
