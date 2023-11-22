package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Page Object class for Test1.
 */
public class Test1 extends BasePage {
	WebElement email;
	WebElement password;
	WebElement signinButton;
	WebElement divElement;
	
	/**
	 * Initializes the Test1 Page Object with the WebDriver and locates elements.
	 *
	 * @param driver The WebDriver used for the test.
	 */
	public Test1(WebDriver driver){
		super(driver);
		email = driver.findElement( By.id("inputEmail"));
		password = driver.findElement( By.id("inputPassword"));
		signinButton = driver.findElement(By.xpath("//button[contains(text(),'Sign in')]"));
		divElement = driver.findElement( By.id("test-1-div"));
	}

	@Override
	public WebElement getTestDiv() {
		return divElement;
	}

	/**
	 * Checks if email input text box is visible on the page 
	 * 
	 * @return 	True if present, false otherwise
	 */
	public boolean isEmailInputPresent() {
		return email.isDisplayed();
	}

	/**
	 * Checks if password input text box is visible on the page 
	 * 
	 * @return	True if present, false otherwise
	 */
	public boolean isPasswordInputPresent() {
		return password.isDisplayed();
	}

	/**
	 * Checks if login button is visible on the page 
	 * 
	 * @return	True if present, false otherwise
	 */
	public boolean isLoginButtonPresent() {
		return signinButton.isDisplayed();
	}

	/**
	 * Submits email from text box
	 */
	public void enterEmail(String email) {
		this.email.sendKeys(email);
	}

	/**
	 * Submits password from text box
	 */
	public void enterPassword(String password) {
		this.password.sendKeys(password);
	}

	/**
	 * Submits login info from form 
	 */
	public void clickLoginButton() {
		this.signinButton.click();
	}

}
