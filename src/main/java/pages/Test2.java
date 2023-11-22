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
	WebElement divElement;

	/**
     * Initializes the Test2 Page Object with the WebDriver and locates elements.
     *
     * @param driver The WebDriver used for the test.
     */
	public Test2(WebDriver driver){
		super(driver);
		listItem1 = driver.findElement( By.cssSelector("li.list-group-item:nth-child(1)"));
		listItem2 = driver.findElement( By.cssSelector("li.list-group-item:nth-child(2)"));
		listItem3 = driver.findElement( By.cssSelector("li.list-group-item:nth-child(3)"));
		list2Badge = driver.findElement( By.xpath("//span[contains(text(),'6')]"));
		divElement = driver.findElement( By.id("test-2-div"));
	}

	@Override
	public WebElement getTestDiv() {
		return divElement;
	}

	/**
	 * Gets the number of items in the list group
	 * 
	 * @return	Number of items in the list group
	 */
	public int getListGroupItemCount() {
		WebElement listGroup = divElement.findElement(By.className("list-group"));
		return listGroup.findElements(By.tagName("li")).size();
	}
	
	/**
	 * Gets the text of Item2 from the list
	 * 
	 * @return	Text of item2
	 */
	public String getListItem2Text() {
		return listItem2.getText();
	}

	/**
	 * Gets the badge value of a given list item
	 * 
	 * @param 	index	Index of the list item to look up
	 * @return			Badge value of the given item
	 */
	public int getListItemBadgeValue(int index) {
		WebElement listGroup = divElement.findElement(By.className("list-group"));
		String badgeText = listGroup.findElements(By.tagName("li")).get(index).findElement(By.xpath("//span[contains(text(),'6')]")).getText();
		return Integer.parseInt(badgeText);
	}

}
