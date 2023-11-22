package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Page Object class for Test6.
 */
public class Test6 extends BasePage {
	WebElement table;
	WebElement cell;
	WebElement divElement;

	/**
	 * Initializes the Test6 Page Object with the WebDriver and locates elements.
	 *
	 * @param driver The WebDriver used for the test.
	 */
	public Test6(WebDriver driver){
		super(driver);
		divElement = driver.findElement( By.xpath("//div[@id='test-6-div']"));
	}
	
	@Override
	public WebElement getTestDiv() {
		return divElement;
	}

	/**
	 * 	Finds the value of any cell on the grid
	 * 
	 * @return 	A string containing the value of the cell
	 */
	public String getCellValueInGrid(int row, int column) {
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
}
