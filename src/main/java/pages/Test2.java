/**
 * Test2 implementation
 * @author Srabani "Bonnie" Banik
 */

package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Page Object class for Test2.
 */
public class Test2 {
	WebDriver driver;
	WebElement listItem1;
	WebElement listItem2;
	WebElement listItem3;
	WebElement list2Badge;
	WebElement test2Div;
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
		test2Div = driver.findElement( By.xpath("//div[@id='test-2-div']"));
	}

	/**
     * Performs the validation for Test2, including element visibility checks, text content checks, and capturing a screenshot.
     */
	public void explicitWait()
	{
		// Set up an explicit wait with a 40-second timeout to wait for element visibility.
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(test2Div));
	}

	  public int getListGroupItemCount() {
	        WebElement listGroup = test2Div.findElement(By.className("list-group"));
	        return listGroup.findElements(By.tagName("li")).size();
	    }
        // Check if the second list item's value is "List Item 2".
	    public String getListItemText() {
	       return listItem2.getText();
	    }
		// Check if the second list item's badge value is 6.
	    public int getListItemBadgeValue(int index) {
	        WebElement listGroup = test2Div.findElement(By.className("list-group"));
	        String badgeText = listGroup.findElements(By.tagName("li")).get(index).findElement(By.xpath("//span[contains(text(),'6')]")).getText();
	        return Integer.parseInt(badgeText);
	    }
		
}
