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
 * This class provides implementation to ITestListener interface of testNG
 * @author ADMIN
 */
public class ListenersImplementation implements ITestListener{
	
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" -> @Test Execution Started");
		
		//Intimate Extent report for test
		test = report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" -> @Test is pass");
		
		//Log the test result as PASS in Extent Report
		test.log(Status.PASS, methodName + " -> @Test is Pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" -> @Test is fail");
		
		//Log the status as FAIL in extent report
		test.log(Status.FAIL, methodName + " -> @Test if Fail");

		//Capture the exception
		System.out.println(result.getThrowable());
		
		//Log the exception in extent report
		test.log(Status.WARNING, result.getThrowable());

		//Capture Screenshot
		SeleniumUtility s = new SeleniumUtility();
		JavaUtility j = new JavaUtility();

		String ScreenshotName = methodName+"-"+j.getSystemDateInFormat();

		try {
			s.captureScreenShot(BaseClass.sdriver, ScreenshotName);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" -> @Test is skip");

		//Capture the exception
		System.out.println(result.getThrowable());

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Suite Execution Started");
		
		//Configure the extent reports
		ExtentSparkReporter esr = new ExtentSparkReporter(".\\ExtentReports\\Report - "+ new JavaUtility().getSystemDateInFormat()+".html");
		esr.config().setDocumentTitle("Swag labs Execution report");
		esr.config().setReportName("Execution Report");
		esr.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Browser", "Microsoft Edge");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Env", "Testing");
		report.setSystemInfo("Reporter Name", "Rishi");
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Suite Execution Finished");
		
		//Generate Extent Reports
		report.flush();
	}



}
