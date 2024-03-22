package genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class will provide implementation to IRetryAnalyser of TestNG
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer {
	
	int count =0;
	
	int retrycount=3;//manual analysis
	
	public boolean retry(ITestResult result)
	{
		//0<3 1<3 2<3
		while(count<retrycount)
		{
			count++;//1 2 3
			
			return true;//retry retry retry
		}
		return false; // not to retry
		
	}

}
