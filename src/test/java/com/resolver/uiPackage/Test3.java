package com.resolver.uiPackage;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.resolver.utils.ScreenshotUtils;

/**
 * Page Object class for Test3.
 */
public class Test3 {
	WebDriver driver;
	ScreenshotUtils screenshot;
	WebElement dropdownDefault;
	WebElement dropdown;
	WebElement dropdown3;
	Select option3;
	WebElement dropdownshow;
	WebElement screenshotpart;
	WebDriverWait wait;
	
	 /**
     * Initializes the Test3 Page Object with the WebDriver and locates elements.
     *
     * @param driver The WebDriver used for the test.
     */
	public Test3(WebDriver driver){
		this.driver=driver;
		dropdownDefault = driver.findElement( By.id("dropdownMenuButton"));
		dropdown = driver.findElement(By.xpath("//div[@class='dropdown-menu']"));
		dropdownDefault.click();
		dropdownshow=driver.findElement(By.xpath("//div[@class='dropdown-menu show']"));
		dropdown3 = driver.findElement(By.xpath("//a[contains(text(),'Option 3')]"));	
		screenshotpart = driver.findElement( By.xpath("//div[@id='test-3-div']"));

	}

	  /**
     * Performs the validation for Test3, including element visibility checks, text content checks, and capturing a screenshot.
     */
	public void assertTest3() {
		// Set up an explicit wait with a 40-second timeout to wait for element visibility.
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(screenshotpart));
		
		 //assert that "Option 1" is the default selected value
		Assert.assertEquals(true, dropdownDefault.getText().equals("Option 1"));
		System.out.println("Dropdown default value contains expected value – Assert passed");
		 
		//Select "Option 3" from the select list
		dropdown3.click();
		
		// Capture a screenshot of the Test3 div.
		screenshot = new ScreenshotUtils();
		screenshot.captureScreenshotfromPage(screenshotpart, "test3Validation");

	}
}
