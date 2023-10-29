package com.resolver.uiPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Test4 {
	WebDriver driver;
	WebElement firstButton;
	WebElement secondButton;
	
	public Test4(WebDriver driver){
		this.driver=driver;
		firstButton = driver.findElement( By.xpath("//button[@class='btn btn-lg btn-primary']"));
		secondButton = driver.findElement(  By.xpath("//button[@class='btn btn-lg btn-secondary']"));
	}
	
	public void assertTest4() {
		Assert.assertEquals(true, firstButton.isEnabled());
		System.out.println("First Button is enabled – Assert passed");
		Assert.assertEquals(false, secondButton.isEnabled());
		System.out.println("Second Button is disabled – Assert passed");
	}
}
