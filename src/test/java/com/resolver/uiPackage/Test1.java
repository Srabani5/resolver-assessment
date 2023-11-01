package com.resolver.uiPackage;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.resolver.utils.ScreenshotUtils;

/**
 * Page Object class for Test1.
 */
public class Test1 {
	WebDriver driver;
	WebElement email;
	WebElement password;
	WebElement signinButton;
	WebDriverWait wait;
	WebElement screenshotpart;
	ScreenshotUtils screenshot;

	/**
	 * Initializes the Test1 Page Object with the WebDriver and locates elements.
	 *
	 * @param driver The WebDriver used for the test.
	 */
	public Test1(WebDriver driver){
		this.driver=driver;
		email = driver.findElement( By.id("inputEmail"));
		password = driver.findElement( By.id("inputPassword"));
		signinButton = driver.findElement(By.xpath("//button[contains(text(),'Sign in')]"));
		screenshotpart = driver.findElement( By.xpath("//div[@id='test-1-div']"));
	}

	/**
	 * Performs the validation for Test1, including element visibility checks, text content checks, and capturing a screenshot.
	 */
	public void assertTest1() {
		// Set up an explicit wait with a 40-second timeout to wait for element visibility.
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(screenshotpart));
		
		//Assert that both the email address and password inputs are present as well as the login button
		Assert.assertEquals(true, email.isDisplayed());
		System.out.println("Email Input is displayed – Assert passed");
		Assert.assertEquals(true, password.isDisplayed());
		System.out.println("Password Input is displayed – Assert passed");
		Assert.assertEquals(true, signinButton.isDisplayed());
		System.out.println("Sign In button is displayed – Assert passed");
		
		//Enter in an email address and password combination into the respective fields
		email.sendKeys("Bonnie");
		password.sendKeys("password");
		
		// Capture a screenshot of the Test1 div.
		screenshot = new ScreenshotUtils();
		screenshot.captureScreenshotfromPage(screenshotpart, "test1Validation");
	}
}
