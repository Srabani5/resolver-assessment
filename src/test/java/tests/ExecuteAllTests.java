/**
 * Resolver automation assessment
 * @author Srabani "Bonnie" Banik
 */
package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
import testdata.TestData;
import pages.BasePage;

import pages.Test1;
import pages.Test2;
import pages.Test3;
import pages.Test4;
import pages.Test5;
import pages.Test6;

/**
 * Main class responsible for setup and execution of all test cases
 */
public class ExecuteAllTests {

	WebDriver driver;

	/**
	 * This method sets up the WebDriver and navigates to the test application.
	 *
	 * @param browser The name of the browser to use for testing.
	 * @throws Exception If an incorrect browser is provided.
	 */
	@BeforeClass
	@Parameters("browser")
	public void setupDriver(@Optional("chrome") String browser) throws Exception {
		try {
			// Construct the relative path of the test file
			// Note: The tests must be run from the project's root directory in order for the relative path to be found
			File relativePath = new File("/src/test/java/test_page/QE-index.html");
			String targetPage = System.getProperty("user.dir") + relativePath.toString();

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
			driver.get(targetPage);
		}
		// Catch any unexpected errors and print stack trace for easy debugging
		catch(Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	/**
	 * Sets up a timed wait with a 40-second timeout to wait for element visibility.
	 */
	public void waitForElement(WebElement element)
	{
		WebDriverWait wait;
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(element));
	}


	/////////////////////////////// TEST CASES ////////////////////////////////
	
	/**
	 * Test method for executing Test1.
	 */
	@Test
	public void runTest1() {
		Test1 test1=new Test1(driver);
		Assert.assertTrue(test1.isEmailInputPresent(), "Email input is not present");
		logger.log(LogStatus.INFO, "Email input is present");
		Assert.assertTrue(test1.isPasswordInputPresent(), "Password input is not present");
		logger.log(LogStatus.INFO, "Password input is present");
		Assert.assertTrue(test1.isLoginButtonPresent(), "Login button is not present");
		logger.log(LogStatus.INFO, "Login button is present");
		test1.enterEmail(TestData.VALID_USERNAME);
		test1.enterPassword(TestData.VALID_PASSWORD);
		test1.clickLoginButton();
		logger.log(LogStatus.INFO, "Entered email address and password");
		//test1.getScreenshot();
	}

	/**
	 * Test method for executing Test2.
	 */
	@Test
	public void runTest2() {
		Test2 test2 = new Test2(driver);
		//test2.navigateToHomePage(TEST_PAGE);
//		test2.waitForElement(test2.);
		int itemCount = test2.getListGroupItemCount();
		Assert.assertEquals(itemCount, 3);
		logger.log(LogStatus.INFO, "There are 3 values in the listgroup");
		//Assert.assertEquals(listItems.size(), 3);
		
		String listItemText = test2.getListItemText(); // Index 1 corresponds to the second list item.
		Assert.assertEquals(listItemText.toString().contains("List Item 2"), true);
		logger.log(LogStatus.INFO, "second list item's value is set to \"List Item 2\"");

		int badgeValue = test2.getListItemBadgeValue(1); // Index 1 corresponds to the second list item.
		Assert.assertEquals(badgeValue, 6);
		logger.log(LogStatus.INFO, "second list item's badge value is 6");
		//test2.getScreenshot();


	}


	/**
	 * Test method for executing Test3.
	 */
	@Test
	public void runTest3() {
		Test3 test3=new Test3(driver);
//		test3.waitForElement();
		String selectedOptionText = test3.getSelectedOptionText();
		Assert.assertEquals(selectedOptionText, "Option 1");
		logger.log(LogStatus.INFO, "\"Option 1\" is the default selected value");
		test3.selectOption("Option 3");
		selectedOptionText = test3.getSelectedOptionText();
		Assert.assertEquals(selectedOptionText, "Option 3");
		logger.log(LogStatus.INFO, "Selected \"Option 3\" from the select list");
		//test3.getScreenshot();

	}




	/**
	 * Test method for executing Test4.
	 */
	@Test
	public void runTest4() {
		Test4 test4=new Test4(driver);
		//test4.navigateToHomePage(TEST_PAGE);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		test4.waitForElement();

		boolean isButton1Enabled = test4.isButtonEnabled(test4.getButton1());
		boolean isButton2Enabled = test4.isButtonEnabled(test4.getButton2());

		Assert.assertTrue(isButton1Enabled, "Button 1 is not enabled.");
		logger.log(LogStatus.INFO, "Button 1 is enabled");
		Assert.assertFalse(isButton2Enabled, "Button 2 is not disabled.");
		logger.log(LogStatus.INFO, "Button 2 is disabled");
		//test4.getScreenshot();

	}


	/**
	 * Test method for executing Test5.
	 */
	@Test
	public void runTest5() {
		logger.log(LogStatus.INFO, "wait for a button to be displayed and then click it");
		Test5 test5 = new Test5(driver);
		if (test5 == null) {
			System.out.println("Sharnav NULL");
		}
		//test5.navigateToHomePage(TEST_PAGE);
//		test5.waitForElement();
		test5.wait.until(ExpectedConditions.visibilityOf(test5.test5Div));
		test5.waitForButtonDisplayed(); // Wait for the button with a random delay.

		test5.clickDynamicButton();
		logger.log(LogStatus.INFO, "you've clicked the button");

		String successMessage = test5.getSuccessMessageText();
		Assert.assertEquals(successMessage, "You clicked a button!");
		logger.log(LogStatus.INFO, "success message is displayed");

		boolean isButtonDisabled = test5.isDynamicButtonDisabled();
		Assert.assertTrue(isButtonDisabled, "Button is not disabled.");
		logger.log(LogStatus.INFO, "Button is now disabled");
		//test5.getScreenshot();

	}


	/**
	 * Test method for executing Test6.
	 */
	@Test
	public void runTest6() {
		Test6 test6=new Test6(driver);
//		test6.waitForElement();
		logger.log(LogStatus.INFO, "method to find the value of the cell at coordinates 2, 2 ");
		String cellValue = test6.getCellValue(2, 2);

		// Assert that the value of the cell is "Ventosanzap".
		Assert.assertEquals(cellValue, "Ventosanzap");
		logger.log(LogStatus.INFO, "the value of the cell is \"Ventosanzap\"");
		//test6.getScreenshot();
	}


}
