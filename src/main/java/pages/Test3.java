package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;


/**
 * Page Object class for Test3.
 */
public class Test3 {
	WebDriver driver;
	WebElement dropdownDefault;
	WebElement dropdown;
	WebElement dropdown3;
	Select option3;
	WebElement dropdownshow;
	WebElement test3Div;
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
		//dropdownDefault.click();
		//dropdownshow=driver.findElement(By.xpath("//div[@class='dropdown-menu show']"));
		dropdown3 = driver.findElement(By.xpath("//a[contains(text(),'Option 3')]"));
		test3Div = driver.findElement( By.xpath("//div[@id='test-3-div']"));

	}

	public WebElement getTestDiv() {
		return test3Div;
	}

	public WebElement getDropdownButton() {
		return getTestDiv().findElement(By.id("dropdownMenuButton"));
	}

	public WebElement getOptionElement(String optionText) {
		List<WebElement> optionElements = getTestDiv().findElements(By.cssSelector(".dropdown-item"));
		for (WebElement element : optionElements) {
			if (element.getText().equals(optionText)) {
				return element;
			}
		}
		return null;
	}

	public String getSelectedOptionText() {
		return getDropdownButton().getText();
	}

	public void openDropdown() {
		dropdownDefault.click();
	}

	public void selectOption(String optionText) {
		openDropdown();
		WebElement optionElement = getOptionElement(optionText);
		if (optionElement != null) {
			optionElement.click();
		}
	}

}
