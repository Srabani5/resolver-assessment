package com.resolver.uiPackage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Test5 {
	WebDriver driver;
	WebElement uniqueButton;
	WebElement alertSuccess;
	WebDriverWait wait;
	
	public Test5(WebDriver driver){
		this.driver=driver;
		uniqueButton = driver.findElement( By.id("test5-button"));
		alertSuccess = driver.findElement(By.id("test5-alert"));
		
	}
	
	public void assertTest5() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-lg btn-primary']")));
		//System.out.println("Button is visible"+uniqueButton.getText());
		uniqueButton.click();
		Assert.assertEquals(true, alertSuccess.isDisplayed());
		System.out.println("Alert is visible – Assert passed");
		Assert.assertEquals(false, uniqueButton.isEnabled());
		System.out.println("The Button is disabled – Assert passed");
		}
}
