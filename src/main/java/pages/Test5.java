package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * Page Object class for Test5.
 */
public class Test5 {
	WebDriver driver;
	WebElement uniqueButton;
	WebElement alertSuccess;
	public WebDriverWait wait;
	WebElement test5Div;

	/**
	 * Initializes the Test5 Page Object with the WebDriver and locates elements.
	 *
	 * @param driver The WebDriver used for the test.
	 */
	public Test5(WebDriver driver){
		this.driver = driver;
		uniqueButton = driver.findElement(By.id("test5-button"));
		alertSuccess = driver.findElement(By.id("test5-alert"));
		test5Div = driver.findElement( By.xpath("//div[@id='test-5-div']"));
	}

	public WebElement getTestDiv() {
		return test5Div;
	}

	public WebElement getDynamicButton() {
		return getTestDiv().findElement(By.id("test5-button"));
	}

	public WebElement getSuccessMessage() {
		return getTestDiv().findElement(By.id("test5-alert"));
	}

	public void waitForButtonDisplayed() {
		wait.until(ExpectedConditions.visibilityOf(getDynamicButton()));
	}

	public void clickDynamicButton() {
		getDynamicButton().click();
	}

	public String getSuccessMessageText() {
		return getSuccessMessage().getText();
	}

	public boolean isDynamicButtonDisabled() {
		return !getDynamicButton().isEnabled();
	}

}
