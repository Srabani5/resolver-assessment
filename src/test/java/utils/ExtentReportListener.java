package utils;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import tests.BaseTest;

public class ExtentReportListener extends BaseTest implements ITestListener, ISuiteListener {

//	WebDriver driver;
	ExtentReports report;
//	ExtentTest test;
	String browser;
	
	@Override
	public void onStart(ISuite suite) {
		//Create an html report for the test suite that is executed
		report = new ExtentReports("./report/" + suite.getName() + "-Report.html");
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
//		driver = (WebDriver)result.getTestContext().getAttribute("WebDriver"); // Use string from setAttribute from BaseTest
	    browser = ((RemoteWebDriver) driver).getCapabilities().getBrowserName();

	    // Make sure the test names contain the browser name in the report
	    String testName = String.format("%s-%s", result.getMethod().getMethodName(), browser);
	    test = report.startTest(testName);
		test.log(LogStatus.INFO, "[" + browser + "] RUN: " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(LogStatus.INFO, "[" + browser + "] PASS");
	}


	@Override
	public void onTestFailure(ITestResult result) {
		String fileName = String.format("%s-failure-%s-%s.jpg", result.getMethod().getMethodName(), browser, Calendar.getInstance().getTimeInMillis());
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("./screenshots/" + fileName);
		
		// Try to capture a screenshot of the element during failure.
		try {
			FileUtils.copyFile(srcFile, destFile);
			System.out.println("Screenshot taken, saved in screenshots folder");
		} catch(IOException e) {
			System.out.println("Failed to take screenshot");
		}
		
		// Get the assertion message and log it in the report
		Throwable t = result.getThrowable();
		test.log(LogStatus.FAIL, "[" + browser + "] FAIL: " + t.getMessage());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(LogStatus.SKIP, "[" + browser + "] SKIP");
	}

}