package com.resolver.testMethods;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.resolver.uiPackage.Test1;
import com.resolver.uiPackage.Test2;
import com.resolver.uiPackage.Test3;
import com.resolver.uiPackage.Test4;
import com.resolver.uiPackage.Test5;
import com.resolver.uiPackage.Test6;

import io.github.bonigarcia.wdm.WebDriverManager;




public class Testsetup {
	public static WebDriver driver;

	@BeforeTest
	@Parameters("browser")
	public void beforeTest(@Optional("chrome") String browser) throws Exception {
		if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			throw new Exception("Incorrect Browser");
		}

		//driver = new ChromeDriver();
		//driver = new EdgeDriver();
		//driver = new InternetExplorerDriver();
		//driver = new FirefoxDriver();
		//public static homepage = "C:\\eclipse-workspace\\assessmentTest\\src\\main\\resources\\QE-index.html";
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("C:\\eclipse-workspace\\assessmentTest\\src\\main\\resources\\QE-index.html");
	}

	@Test
	public void test1Validation() {
		Test1 test1=new Test1(driver);
		test1.assertTest1();
		test1.sendEmailPassword("Bonnie", "password");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		captureScreenshot("test1Validation");
	}

	@Test
	public void test2Validation() {
		Test2 test2=new Test2(driver);
		test2.assertTest2();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		captureScreenshot("test2Validation");
	}

	@Test
	public void test3Validation() {
		Test3 test3=new Test3(driver);
		test3.assertTest3();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		captureScreenshot("test3Validation");
	}

	@Test
	public void test4Validation() {
		Test4 test4=new Test4(driver);
		test4.assertTest4();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		captureScreenshot("test4Validation");
	}

	@Test
	public void test5Validation() {
		Test5 test5=new Test5(driver);
		test5.assertTest5();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		captureScreenshot("test5Validation");
	}

	@Test
	public void test6Validation() {
		Test6 test6=new Test6(driver);
		test6.assertTest6();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		captureScreenshot("test6Validation");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	
	// Utility method to capture a screenshot
	public void captureScreenshot(String screenshotName) {
	    try {
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        File destination = new File("C:\\eclipse-workspace\\assessmentTest\\test-output\\" + screenshotName + ".png");
	        FileUtils.copyFile(source, destination);
	        System.out.println("Screenshot saved to: " + destination.getAbsolutePath());
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}