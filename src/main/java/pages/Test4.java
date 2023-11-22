package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Page Object class for Test4.
 */
public class Test4 extends BasePage {
	WebElement firstButton;
	WebElement secondButton;
	WebElement divElement;
	
	/**
	 * Initializes the Test4 Page Object with the WebDriver and locates elements.
	 *
	 * @param driver The WebDriver used for the test.
	 */
	public Test4(WebDriver driver){
		super(driver);
		divElement = driver.findElement( By.id("test-4-div"));
	}

	@Override
	public WebElement getTestDiv() {
		return divElement;
	}

	/**
	 * Gets button 1
	 * 
	 * @return	the button1 element
	 */
	public WebElement getButton1() {
		return divElement.findElement(By.xpath("//button[@class='btn btn-lg btn-primary']"));
	}

	/**
	 * Gets button 2
	 * 
	 * @return	the button2 element
	 */
	public WebElement getButton2() {
		return divElement.findElement( By.xpath("//button[@class='btn btn-lg btn-secondary']"));
	}

	/**
	 * Checks if a given button is enabled 
	 * 
	 * @return 	True if enabled, false otherwise
	 */
	public boolean isButtonEnabled(WebElement button) {
		return button.isEnabled();
	}

}
