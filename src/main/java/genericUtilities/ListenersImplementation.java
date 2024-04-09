package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to ITestListeners interface of TestNG
 * 
 * @Sneha
 */
public class ListenersImplementation implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {

		String methodName = result.getMethod().getMethodName();

		System.out.println(methodName + "---Test Start---");
		
		//Create a test for @Test in extent reports
		
		test = report.createTest(methodName);

	}

	public void onTestSuccess(ITestResult result) {

		String methodName = result.getMethod().getMethodName();

		System.out.println(methodName + "---Test Success---");
		
		// log the pass status in extent report
		
		test.log(Status.PASS, methodName + "---Test Success---");

	}

	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();

		System.out.println(methodName + "---Test Fail---");
		
		//Log the fail status in extent report
		
		test.log(Status.FAIL, methodName + "---Test Fail---");
		
		SeleniumUtility s = new SeleniumUtility();
		JavaUtility j= new JavaUtility();
		
		String screenShotName = methodName+"-"+j.getDate();
		
		try {
			String path =s.takeScreenshot(BaseClass.sdriver, screenShotName);
			
			//Attach screenshot for extent report
			
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {

		String methodName = result.getMethod().getMethodName();

		System.out.println(methodName + "---Test Skipped---");
		
		//Log the skip status in extent report
		
		test.log(Status.SKIP, methodName + "---Test Skipped---");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {

		System.out.println("----Script execution Started----");
		
		//Configure the extend report
		
		ExtentSparkReporter rep = new ExtentSparkReporter(".\\ExtentReports\\Reports-"+new JavaUtility().getDate());
		
		rep.config().setDocumentTitle("ExtentReport");
		rep.config().setReportName("Vtiger Execution Report");
		rep.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		
		report.attachReporter(rep);
		
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Base OS", "Windows");
		report.setSystemInfo("Base Platform", "Testing");
		report.setSystemInfo("Base url", "http://localhost:8888");
	
	}

	public void onFinish(ITestContext context) {
		System.out.println("----Script execution Finished----");
		
		//generate extent report
		
		report.flush();

	}
}
