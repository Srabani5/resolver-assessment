/**
 * Resolver automation assessment
 * @author Srabani "Bonnie" Banik
 */
package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.Test1;
import pages.Test2;
import pages.Test3;
import pages.Test4;
import pages.Test5;
import pages.Test6;
import testdata.TestData;

/**
 * Main class responsible for setup and execution of all test cases
 */
public class TestCases extends BaseTest {

	/**
	 * Test method for executing Test1.
	 */
	@Test
	public void test1() {
		Test1 test1= new Test1(driver);
		Assert.assertTrue(test1.isEmailInputPresent(), "Email input textbox present");
		test.log(LogStatus.INFO, "Email input is present");
		Assert.assertTrue(test1.isPasswordInputPresent(), "Password input textbox present");
		test.log(LogStatus.INFO, "Password input is present");
		Assert.assertTrue(test1.isLoginButtonPresent(), "Sign in button present");
		test.log(LogStatus.INFO, "Login button is present");
		test1.enterEmail(TestData.VALID_USERNAME);
		test1.enterPassword(TestData.VALID_PASSWORD);
		test1.clickLoginButton();
		test.log(LogStatus.INFO, "Entered email address and password");
		//test1.getScreenshot();
	}

	/**
	 * Test method for executing Test2.
	 */
	@Test
	public void test2() {
		Test2 test2 = new Test2(driver);
		//test2.navigateToHomePage(TEST_PAGE);
//		test2.waitForElement(test2.);
		int itemCount = test2.getListGroupItemCount();
		Assert.assertEquals(itemCount, 3);
		test.log(LogStatus.INFO, "There are 3 values in the listgroup");
		//Assert.assertEquals(listItems.size(), 3);
		
		String listItemText = test2.getListItemText(); // Index 1 corresponds to the second list item.
		Assert.assertEquals(listItemText.toString().contains("List Item 2"), true);
		test.log(LogStatus.INFO, "second list item's value is set to \"List Item 2\"");

		int badgeValue = test2.getListItemBadgeValue(1); // Index 1 corresponds to the second list item.
		Assert.assertEquals(badgeValue, 6);
		test.log(LogStatus.INFO, "second list item's badge value is 6");
		//test2.getScreenshot();
	}

	/**
	 * Test method for executing Test3.
	 */
	@Test
	public void test3() {
		Test3 test3=new Test3(driver);
//		test3.waitForElement();
		String selectedOptionText = test3.getSelectedOptionText();
		Assert.assertEquals(selectedOptionText, "Option 1");
		//test.log(LogStatus.INFO, "\"Option 1\" is the default selected value");
		test3.selectOption("Option 3");
		selectedOptionText = test3.getSelectedOptionText();
		Assert.assertEquals(selectedOptionText, "Option 3");
		//test.log(LogStatus.INFO, "Selected \"Option 3\" from the select list");
		//test3.getScreenshot();

	}

	/**
	 * Test method for executing Test4.
	 */
	@Test
	public void test4() {
		Test4 test4=new Test4(driver);
		//test4.navigateToHomePage(TEST_PAGE);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		test4.waitForElement();

		boolean isButton1Enabled = test4.isButtonEnabled(test4.getButton1());
		boolean isButton2Disabled = !test4.isButtonEnabled(test4.getButton2());

		Assert.assertTrue(isButton1Enabled, "Button 1 enabled.");
		//test.log(LogStatus.INFO, "Button 1 is enabled");
		Assert.assertTrue(isButton2Disabled, "Button 2 disabled.");
		//test.log(LogStatus.INFO, "Button 2 is disabled");
		//test4.getScreenshot();
	}

	/**
	 * Test method for executing Test5.
	 */
	@Test
	public void test5() {
		//test.log(LogStatus.INFO, "wait for a button to be displayed and then click it");
		Test5 test5 = new Test5(driver);

//		test5.waitForElement();
//		test5.wait.until(ExpectedConditions.visibilityOf(test5.getTestDiv()));
		test5.waitForButtonDisplayed(); // Wait for the button with a random delay.

		test5.clickDynamicButton();
		//test.log(LogStatus.INFO, "you've clicked the button");

		String successMessage = test5.getSuccessMessageText();
		Assert.assertEquals(successMessage, "You clicked a button!");
		//test.log(LogStatus.INFO, "success message is displayed");

		boolean isButtonDisabled = test5.isDynamicButtonDisabled();
		Assert.assertTrue(isButtonDisabled, "Button is not disabled.");
		//test.log(LogStatus.INFO, "Button is now disabled");
		//test5.getScreenshot();
	}

	/**
	 * Test method for executing Test6.
	 */
	@Test
	public void test6() {
		Test6 test6=new Test6(driver);
//		test6.waitForElement();
		//test.log(LogStatus.INFO, "method to find the value of the cell at coordinates 2, 2 ");
		String cellValue = test6.getCellValue(2, 2);

		// Assert that the value of the cell is "Ventosanzap".
		Assert.assertEquals(cellValue, "Ventosanzap");
		//test.log(LogStatus.INFO, "the value of the cell is \"Ventosanzap\"");
		//test6.getScreenshot();
	}


}
