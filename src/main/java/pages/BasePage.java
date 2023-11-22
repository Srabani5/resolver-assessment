package pages;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * Defines the base functionalities of a test page
 */
public abstract class BasePage {

	static final int WAIT_TIMEOUT = 60;
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	String homePage;
	
	/*
	 * Default constructor.
	 * 
	 * @param driver Default WebDriver to be used for the tests.
	 * 
	 */
	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT));
		
		// Construct the relative path of the test file regardless of the OS
		// Note: The tests must be run from the project's root directory in order for the relative path to be found
		File relativePath = new File("/src/test/java/test_page/QE-index.html");
		homePage = System.getProperty("user.dir") + relativePath.toString();
		navigateToHomePage();
	}
	
	/**
	 * Loads and navigates to the default home page
	 */
	public void navigateToHomePage() {
		driver.get(homePage);
	}
	
	/**
	 * Waits for element visibility until default timeout.
	 */
	public void waitForElement(WebElement element)
	{
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	//abstract methods
	
	/**
	 * Abstract method for getting the main div for the test
	 */
	public abstract WebElement getTestDiv();


}