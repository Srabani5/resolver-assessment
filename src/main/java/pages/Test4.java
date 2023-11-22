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
	WebElement test4Div;
	
	/**
	 * Initializes the Test4 Page Object with the WebDriver and locates elements.
	 *
	 * @param driver The WebDriver used for the test.
	 */
	public Test4(WebDriver driver){
		super(driver);
		//firstButton = driver.findElement( By.xpath("//button[@class='btn btn-lg btn-primary']"));
		//driver. = driver.findElement(  By.xpath("//button[@class='btn btn-lg btn-secondary']"));
		test4Div = driver.findElement( By.xpath("//div[@id='test-4-div']"));
	}

	@Override
	public WebElement getTestDiv() {
		return test4Div;
	}

	public WebElement getTest4Div() {
		return test4Div;
	}

	public WebElement getButton1() {
		return getTest4Div().findElement(By.xpath("//button[@class='btn btn-lg btn-primary']"));
	}

	public WebElement getButton2() {
		return getTest4Div().findElement( By.xpath("//button[@class='btn btn-lg btn-secondary']"));
	}

	public boolean isButtonEnabled(WebElement button) {
		return button.isEnabled();
	}

}
