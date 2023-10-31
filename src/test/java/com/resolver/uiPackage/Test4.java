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
 * Page Object class for Test4.
 */
public class Test4 {
	WebDriver driver;
	WebElement firstButton;
	WebElement secondButton;
	ScreenshotUtils screenshot;
	WebElement screenshotpart;
	WebDriverWait wait;

	 /**
     * Initializes the Test4 Page Object with the WebDriver and locates elements.
     *
     * @param driver The WebDriver used for the test.
     */
	public Test4(WebDriver driver){
		this.driver=driver;
		firstButton = driver.findElement( By.xpath("//button[@class='btn btn-lg btn-primary']"));
		secondButton = driver.findElement(  By.xpath("//button[@class='btn btn-lg btn-secondary']"));
		screenshotpart = driver.findElement( By.xpath("//div[@id='test-4-div']"));
	}

	  /**
     * Performs the validation for Test4, including element visibility checks, text content checks, and capturing a screenshot.
     */
	public void assertTest4() {
		// Set up an explicit wait with a 40-second timeout to wait for element visibility.
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(screenshotpart));
		
		//assert that the first button is enabled 
		Assert.assertEquals(true, firstButton.isEnabled());
		System.out.println("First Button is enabled – Assert passed");
		
		//assert that the second button is disabled 
		Assert.assertEquals(false, secondButton.isEnabled());
		System.out.println("Second Button is disabled – Assert passed");
		
		// Capture a screenshot of the Test4 div.
		screenshot = new ScreenshotUtils();
		screenshot.captureScreenshotfromPage(screenshotpart, "test4Validation");
	}

}
