package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Page Object class for Test5.
 */
public class Test5 extends BasePage {
	WebElement uniqueButton;
	WebElement alertSuccess;
	WebElement divElement;

	/**
	 * Initializes the Test5 Page Object with the WebDriver and locates elements.
	 *
	 * @param driver The WebDriver used for the test.
	 */
	public Test5(WebDriver driver){
		super(driver);
		uniqueButton = driver.findElement(By.id("test5-button"));
		alertSuccess = driver.findElement(By.id("test5-alert"));
		divElement = driver.findElement( By.id("test-5-div"));
	}

	@Override
	public WebElement getTestDiv() {
		return divElement;
	}

	/**
	 * Gets dynamic button
	 * 
	 * @return	the dynamic button element
	 */
	public WebElement getDynamicButton() {
		return uniqueButton;
	}

	/**
	 * Gets success message alert element
	 * 
	 * @return	the success message alert element
	 */
	public WebElement getSuccessMessage() {
		return alertSuccess;
	}

	/**
	 * Wait for the button element to be displayed
	 */
	public void waitForButtonDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(getDynamicButton()));
	}

	/**
	 * Submits a button click
	 */
	public void clickDynamicButton() {
		getDynamicButton().click();
	}

	/**
	 * Gets the text from the success message alert
	 * 
	 * @return	A string containing the sucches message
	 */
	public String getSuccessMessageText() {
		return getSuccessMessage().getText();
	}

	/**
	 * Checks if the dynamic button is Disabled
	 * 
	 * @return 	True if disabled, false otherwise
	 */
	public boolean isDynamicButtonDisabled() {
		return !getDynamicButton().isEnabled();
	}

}
