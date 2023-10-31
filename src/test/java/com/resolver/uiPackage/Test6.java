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
 * Page Object class for Test6.
 */
public class Test6 {
	WebDriver driver;
	WebElement table;
	WebElement cell;
	ScreenshotUtils screenshot;
	WebElement screenshotpart;
	WebDriverWait wait;

	/**
     * Initializes the Test6 Page Object with the WebDriver and locates elements.
     *
     * @param driver The WebDriver used for the test.
     */
	public Test6(WebDriver driver){
		this.driver=driver;
		screenshotpart = driver.findElement( By.xpath("//div[@id='test-6-div']"));
	}

	//method that allows you to find the value of any cell on the grid
	public String getCellValueInGrid(WebDriver driver, int row, int column) {
		try {
			// Find the table element using the provided locator
			table = driver.findElement(By.xpath("//table[@class='table table-bordered table-dark']"));

			// Find the specific row and column within the table
			cell = table.findElement(By.xpath(".//tr[" + (row+1) + "]/td[" + (column+1) + "]"));

			// Get the text (value) of the cell
			String cellValue = cell.getText();
			return cellValue;
		} catch (Exception e) {
			// Handle exceptions if the element is not found or other issues
			e.printStackTrace();
			return null;
		}
	}

	  /**
     * Performs the validation for Test5, including element visibility checks, text content checks, and capturing a screenshot.
     */
	public void assertTest6() {
		// Set up an explicit wait with a 40-second timeout to wait for element visibility.
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(screenshotpart));
		
		//find the value of the cell at coordinates 2, 2 (staring at 0 in the top left corner) using above method
		String cellValue = getCellValueInGrid( driver, 2, 2);
		
		//Assert that the value of the cell is "Ventosanzap"
		Assert.assertEquals(cellValue, "Ventosanzap");
		System.out.println("Cell Value expected – Assert passed");
		
		// Initialize ScreenshotUtils and capture a screenshot of the specified element.
		screenshot = new ScreenshotUtils();
		screenshot.captureScreenshotfromPage(screenshotpart, "test1Validation");
	}
}