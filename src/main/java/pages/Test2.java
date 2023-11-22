/**
 * Test2 implementation
 * @author Srabani "Bonnie" Banik
 */

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * Page Object class for Test2.
 */
public class Test2 extends BasePage {
	WebElement listItem1;
	WebElement listItem2;
	WebElement listItem3;
	WebElement list2Badge;
	WebElement test2Div;

	/**
     * Initializes the Test2 Page Object with the WebDriver and locates elements.
     *
     * @param driver The WebDriver used for the test.
     */
	public Test2(WebDriver driver){
		super(driver);
		listItem1 = driver.findElement( By.xpath("//li[contains(text(),'List Item 1')]"));
		listItem2 = driver.findElement( By.xpath("//li[contains(text(),'List Item 2')]"));
		listItem3 = driver.findElement( By.xpath("//li[contains(text(),'List Item 3')]"));
		list2Badge = driver.findElement( By.xpath("//span[contains(text(),'6')]"));
		test2Div = driver.findElement( By.xpath("//div[@id='test-2-div']"));
	}

	@Override
	public WebElement getTestDiv() {
		return test2Div;
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
