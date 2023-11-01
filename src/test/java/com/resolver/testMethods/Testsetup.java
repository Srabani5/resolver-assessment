package com.resolver.testMethods;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.resolver.uiPackage.Test1;
import com.resolver.uiPackage.Test2;
import com.resolver.uiPackage.Test3;
import com.resolver.uiPackage.Test4;
import com.resolver.uiPackage.Test5;
import com.resolver.uiPackage.Test6;
import com.resolver.utils.FileUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class contains test methods and setup methods for test execution.
 */
public class Testsetup {
	public static WebDriver driver;
	//The url of the home page
	public static String HOME_PAGE = FileUtil.getResourceFile("/QE-index.html").toString();

	
	//private static final String HOME_PAGE = "C:\\eclipse-workspace\\resolver-assessment\\src\\main\\resources\\QE-index.html";
    /**
     * This method sets up the WebDriver and navigates to the test application.
     *
     * @param browser The name of the browser to use for testing.
     * @throws Exception If an incorrect browser is provided.
     */
	@BeforeTest
	@Parameters("browser")
	public void beforeTest(@Optional("chrome") String browser) throws Exception {
		try {
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
		}catch(Exception e) {
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		driver.get(HOME_PAGE);
	}
	
    /**
     * Test method for validating Test1.
     */
	@Test
	public void test1Validation() {
		Test1 test1=new Test1(driver);
		test1.assertTest1();
	}
	
    /**
     * Test method for validating Test2.
     */
	@Test
	public void test2Validation() {
		Test2 test2=new Test2(driver);
		test2.assertTest2();
	}
	
    /**
     * Test method for validating Test3.
     */
	@Test
	public void test3Validation() {
		Test3 test3=new Test3(driver);
		test3.assertTest3();
	}
	
    /**
     * Test method for validating Test4.
     */
	@Test
	public void test4Validation() { 
		Test4 test4=new Test4(driver);
		test4.assertTest4();

	}
	
    /**
     * Test method for validating Test5.
     */
	@Test
	public void test5Validation() {
		Test5 test5=new Test5(driver);
		test5.assertTest5();
	}
	
    /**
     * Test method for validating Test6.
     */
	@Test
	public void test6Validation() {
		Test6 test6=new Test6(driver);
		test6.assertTest6();
	}
	
    /**
     * This method is executed after all tests are complete and performs cleanup actions.
     */
	@AfterTest
	public void afterTest() {
		//test4.captureScreenshotfromPage("test4Validation");
		driver.quit();
	}


}