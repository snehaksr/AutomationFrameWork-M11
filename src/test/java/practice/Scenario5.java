package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario5 {
public static void main(String[] args) {
	//Login to application with valid user name and password
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("http://localhost:8888");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		
		driver.findElement(By.name("user_password")).sendKeys("admin");
		
		driver.findElement(By.id("submitButton")).click();	
		//Navigate to Campaigns module
		Actions a = new Actions(driver);
		WebElement more = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
		a.moveToElement(more).build().perform();
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//a[@title='Campaigns']")).click();
		driver.findElement(By.name("Edit")).click();
		
		WebElement name = driver.findElement(By.name("campaignname"));
		
		name.clear();
		
		name.sendKeys("SnehaM");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String headers = driver.findElement(By.className("dvHeaderText")).getText();
		
		if(headers.contains("SnehaM"))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
		
		//Logout of App
		
		
	    WebElement signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		a.moveToElement(signout).build().perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		
		driver.quit();
		
}
}
