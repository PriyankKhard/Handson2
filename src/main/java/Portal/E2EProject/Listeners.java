package Portal.E2EProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.Base;
import Resources.ExtentTestReporter;

public class Listeners extends Base implements ITestListener {
	public ExtentTest localreportvariable;
	public ExtentReports er = ExtentTestReporter.getExtentReportObject();
	ThreadLocal<ExtentTest> threadET = new ThreadLocal<ExtentTest>();
	WebDriver driver = null;

	@Override
	public void onTestFailure(ITestResult result) {


		String TCName = result.getMethod().getMethodName();
		threadET.get().log(Status.FAIL, result.getThrowable());
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			threadET.get().addScreenCaptureFromPath(getScreenshotandPath(TCName, driver), "Screenshots") ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		localreportvariable = er.createTest(result.getMethod().getMethodName());
		threadET.set(localreportvariable);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String TCName = result.getMethod().getMethodName();
		threadET.get().log(Status.PASS, "Test Case Passed");
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			threadET.get().addScreenCaptureFromPath(getScreenshotandPath(TCName, driver), "Screenshots") ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		er.flush();
	}

}
