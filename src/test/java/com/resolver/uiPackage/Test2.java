package com.resolver.uiPackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.resolver.utils.ScreenshotUtils;

/**
 * Page Object class for Test2.
 */
public class Test2 {
	WebDriver driver;
	WebElement listItem1;
	WebElement listItem2;
	WebElement listItem3;
	WebElement list2Badge;
	ScreenshotUtils screenshot;
	WebElement screenshotpart;
	WebDriverWait wait;

	 /**
     * Initializes the Test2 Page Object with the WebDriver and locates elements.
     *
     * @param driver The WebDriver used for the test.
     */
	public Test2(WebDriver driver){
		this.driver=driver;
		listItem1 = driver.findElement( By.xpath("//li[contains(text(),'List Item 1')]"));
		listItem2 = driver.findElement( By.xpath("//li[contains(text(),'List Item 2')]"));
		listItem3 = driver.findElement( By.xpath("//li[contains(text(),'List Item 3')]"));
		list2Badge = driver.findElement( By.xpath("//span[contains(text(),'6')]"));
		screenshotpart = driver.findElement( By.xpath("//div[@id='test-2-div']"));
	}

	  /**
     * Performs the validation for Test2, including element visibility checks, text content checks, and capturing a screenshot.
     */
	public void assertTest2() {
		
		// Set up an explicit wait with a 40-second timeout to wait for element visibility.
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(screenshotpart));
		
		// Get the list of items in the Test2 div.
        List<WebElement> listItems = screenshotpart.findElements(By.tagName("li"));
       
        // Assert that there are three values in the list group.
        Assert.assertEquals(listItems.size(), 3);
        System.out.println("Test2 - Three items in the list group - Assert passed");
       
        // Check if the second list item's value is "List Item 2".
        Assert.assertEquals(listItem2.getText(),  "List Item 2 6");
       //String listItem2Text = listItem2.getText();
        //Assert.assertEquals(listItem2Text, "List Item 2");
		System.out.println("List Item 2 Contains expected text - Assert passed");
		 
		// Check if the second list item's badge value is 6.
		Assert.assertEquals(true, list2Badge.toString().contains("6"));
		System.out.println("List Item 2 Badge value Contains expected value - Assert passed");
		
		// Capture a screenshot of the Test2 div.
		screenshot = new ScreenshotUtils();
		screenshot.captureScreenshotfromPage(screenshotpart, "test2Validation");
	}

}
