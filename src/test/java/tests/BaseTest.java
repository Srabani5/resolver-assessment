package tests;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	protected static WebDriver driver;
	protected static ExtentTest test;

	/**
	 * This method sets up the WebDriver and navigates to the test application.
	 *
	 * @param browser The name of the browser to use for testing.
	 * @throws Exception If an incorrect browser is provided.
	 */
	@BeforeClass
	@Parameters("browser")
	public void setupDriver(@Optional("chrome") String browser, ITestContext context) throws Exception {
		try {
			// Construct the relative path of the test file regardless of the OS
			// Note: The tests must be run from the project's root directory in order for the relative path to be found
			File relativePath = new File("/src/test/java/test_page/QE-index.html");
			String homePage = System.getProperty("user.dir") + relativePath.toString();

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
				throw new Exception("Unsupported Browser: " + browser);
			}
			driver.manage().window().maximize();
			driver.get(homePage);
			context.setAttribute("WebDriver", driver);
		}
		catch(Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

//	/**
//	 * Sets up a timed wait with a 40-second timeout to wait for element visibility.
//	 */
//	public void waitForElement(WebElement element)
//	{
//		WebDriverWait wait;
//		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
//		wait.until(ExpectedConditions.visibilityOf(element));
//	}


}
