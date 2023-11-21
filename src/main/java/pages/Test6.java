package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page Object class for Test6.
 */
public class Test6 {
	WebDriver driver;
	WebElement table;
	WebElement cell;
	WebElement test6Div;
	WebDriverWait wait;

	/**
	 * Initializes the Test6 Page Object with the WebDriver and locates elements.
	 *
	 * @param driver The WebDriver used for the test.
	 */
	public Test6(WebDriver driver){
		this.driver=driver;
		test6Div = driver.findElement( By.xpath("//div[@id='test-6-div']"));
	}
	public WebElement getTestDiv() {
		return test6Div;
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

	//find the value of the cell at coordinates 2, 2 (staring at 0 in the top left corner) using above method
	public String getCellValue(int row, int column) {	
		String cellValue = getCellValueInGrid( driver, row, column);
		return cellValue;
	}

}
