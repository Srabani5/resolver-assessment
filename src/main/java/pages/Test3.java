package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


/**
 * Page Object class for Test3.
 */
public class Test3 extends BasePage {
	WebElement dropdownDefault;
	WebElement dropdown;
	WebElement dropdown3;
	Select option3;
	WebElement dropdownshow;
	WebElement divElement;

	/**
	 * Initializes the Test3 Page Object with the WebDriver and locates elements.
	 *
	 * @param driver The WebDriver used for the test.
	 */
	public Test3(WebDriver driver){
		super(driver);
		dropdownDefault = driver.findElement( By.id("dropdownMenuButton"));
		dropdown = driver.findElement(By.xpath("//div[@class='dropdown-menu']"));
		dropdown3 = driver.findElement(By.xpath("//a[contains(text(),'Option 3')]"));
		divElement = driver.findElement( By.xpath("//div[@id='test-3-div']"));

	}

	@Override
	public WebElement getTestDiv() {
		return divElement;
	}

	/**
	 * Gets the drop down button element
	 * 
	 * @return	The drop down button element
	 */
	public WebElement getDropdownButton() {
		return getTestDiv().findElement(By.id("dropdownMenuButton"));
	}

	/**
	 * Gets the drop down option element matching a given text
	 * 
	 * @param 	optionText	Text of the drop down option to look up
	 * @return	Option element matching the text
	 */
	public WebElement getOptionElement(String optionText) {
		List<WebElement> optionElements = getTestDiv().findElements(By.cssSelector(".dropdown-item"));
		for (WebElement element : optionElements) {
			if (element.getText().equals(optionText)) {
				return element;
			}
		}
		return null;
	}

	/**
	 * Gets the text for a selected drop down option
	 * 
	 * @return	A string containing the text
	 */
	public String getSelectedOptionText() {
		return getDropdownButton().getText();
	}

	/**
	 * Open a drop down menu element
	 */
	public void openDropdown() {
		dropdownDefault.click();
	}

	/**
	 * Selects a drop down option
	 * 
	 * @param 	optionText	Text of the drop down option to select
	 */
	public void selectOption(String optionText) {
		openDropdown();
		WebElement optionElement = getOptionElement(optionText);
		if (optionElement != null) {
			optionElement.click();
		}
	}

}
