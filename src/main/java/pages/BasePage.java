package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(40));
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebDriverWait getDriverWait() {
		return wait;
	}

	//abstract methods
	public abstract WebElement getTestDiv();


}