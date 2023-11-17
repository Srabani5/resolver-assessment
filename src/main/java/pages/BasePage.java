package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BasePage {


	public static WebDriver driver;
	public static ExtentTest logger;
	public static ExtentReports report;


	public static final String TEST_PAGE = "C:\\Users\\sraba\\dev\\repos\\resolver-assessment\\src\\test\\java\\test_page\\QE-index.html";
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
		} catch(Exception e) {
			e.printStackTrace();
		}

		driver.manage().window().maximize();
		
		driver.get(TEST_PAGE);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}