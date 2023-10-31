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
 * Page Object class for Test5.
 */
public class Test5 {
	WebDriver driver;
	WebElement uniqueButton;
	WebElement alertSuccess;
	WebDriverWait wait;
	ScreenshotUtils screenshot;
	WebElement screenshotpart;

	 /**
     * Initializes the Test5 Page Object with the WebDriver and locates elements.
     *
     * @param driver The WebDriver used for the test.
     */
	public Test5(WebDriver driver){
		this.driver=driver;
		uniqueButton = driver.findElement( By.id("test5-button"));
		alertSuccess = driver.findElement(By.id("test5-alert"));
		screenshotpart = driver.findElement( By.xpath("//div[@id='test-5-div']"));
	}

	  /**
     * Performs the validation for Test5, including element visibility checks, text content checks, and capturing a screenshot.
     */
	public void assertTest5() {
		
		//wait for a button to be displayed 
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(uniqueButton));
		
		//click the button
		uniqueButton.click();
		
		//assert that a success message is displayed
		Assert.assertEquals(true, alertSuccess.isDisplayed());
		System.out.println("Alert is visible – Assert passed");
		
		//Assert that the button is now disabled
		Assert.assertEquals(false, uniqueButton.isEnabled());
		System.out.println("The Button is disabled – Assert passed");
		
		// Capture a screenshot of the Test5 div.
		screenshot = new ScreenshotUtils();
		screenshot.captureScreenshotfromPage(screenshotpart, "test5Validation");
	}
}
