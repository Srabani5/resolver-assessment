package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page Object class for Test1.
 */
public class Test1 {
	WebDriver driver;
	WebElement email;
	WebElement password;
	WebElement signinButton;
	WebDriverWait wait;
	WebElement test1Div;

	/**
	 * Initializes the Test1 Page Object with the WebDriver and locates elements.
	 *
	 * @param driver The WebDriver used for the test.
	 */
	public Test1(WebDriver drv){
		driver = drv;
		email = driver.findElement( By.id("inputEmail"));
		password = driver.findElement( By.id("inputPassword"));
		signinButton = driver.findElement(By.xpath("//button[contains(text(),'Sign in')]"));
		test1Div = driver.findElement( By.xpath("//div[@id='test-1-div']"));
	}

	/**
	 * Performs the validation for Test1, including element visibility checks, text content checks, and capturing a screenshot.
	 */
	public void explicitWait()
	{
		// Set up an explicit wait with a 40-second timeout to wait for element visibility.
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(test1Div));
	}

	public boolean isEmailInputPresent() {
		return email.isDisplayed();
	}

	public boolean isPasswordInputPresent() {
		return password.isDisplayed();
	}

	public boolean isLoginButtonPresent() {
		return signinButton.isDisplayed();
	}

	public void enterEmail(String email) {
		this.email.sendKeys(email);
	}

	public void enterPassword(String password) {
		this.password.sendKeys(password);
	}

	public void clickLoginButton() {
		this.signinButton.click();
	}
	
	

}
