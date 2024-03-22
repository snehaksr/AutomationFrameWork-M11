package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class BaseClass {
public PropertyFileUtility pf = new PropertyFileUtility();
public ExcelFileUtility ef = new ExcelFileUtility();
public SeleniumUtility su = new SeleniumUtility();
public WebDriver driver;
//For Listeners

public static WebDriver sdriver;
@BeforeSuite(alwaysRun = true)

	public void bsConfig()
	{
		System.out.println("===DB Connection Successfuly===");
	}
//@Parameters("Browser")
//@BeforeTest 
@BeforeClass(alwaysRun = true)
public void bcConfig(/*String BROWSER*/) throws IOException
{
	String URL = pf.readDataFromPropetyFile("url");
//	if(BROWSER.equalsIgnoreCase("Chrome"))
//	{
//		driver=new ChromeDriver();
//	}
//	else if(BROWSER.equalsIgnoreCase("FireFox"))
//	
//	{
//		WebDriverManager.firefoxdriver().setup();
//		driver = new FirefoxDriver();
//	}
//	
	
	driver=new ChromeDriver();
	
	su.maximizeWindow(driver);
	
	su.addimplicitWait(driver);
	
	driver.get(URL);
	
	System.out.println("==Launch the Browser successfuly==");
	
	//For listeners
	
	sdriver = driver;
	
}

@BeforeMethod (alwaysRun = true)
public void bmConfig() throws IOException 
{
	String USERNAME = pf.readDataFromPropetyFile("username");
	
	String PASSWORD = pf.readDataFromPropetyFile("password");
	
	LoginPage lp = new LoginPage(driver);
	
	lp.loginToApp(USERNAME, PASSWORD);
	
	System.out.println("==Login successfuly==");
}
@AfterMethod (alwaysRun = true)
public void amConfig() throws InterruptedException
{
	HomePage hp = new HomePage(driver);
	
	hp.logOutApp(driver);
	
	System.out.println("==Logout successfuly==");
	
}
//@AfterTest
@AfterClass(alwaysRun = true)
public void acConfig()
{
	driver.quit();
	
	System.out.println("==Close browser successfuly==");
	}

@AfterSuite (alwaysRun = true)
public void asConfig()
{
	System.out.println("===DB Close Successfuly===");
}
}
