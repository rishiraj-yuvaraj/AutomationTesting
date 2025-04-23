package genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImplementation implements IRetryAnalyzer{
	
	int count = 0;
	int retryCount = 3; //Manual Analysis
	
	public boolean retry(ITestResult result) {
		//0<3 1<3 2<3 3<3No
		while(count<retryCount) {
			count++; //1 2 3
			return true;
		}
		
		return false; //stop retry
	}
}
