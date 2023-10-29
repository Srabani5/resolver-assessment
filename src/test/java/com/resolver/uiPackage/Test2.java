package com.resolver.uiPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Test2 {
	WebDriver driver;
	WebElement listItem1;
	WebElement listItem2;
	WebElement listItem3;
	WebElement list2Badge;
	
	public Test2(WebDriver driver){
		this.driver=driver;
		listItem1 = driver.findElement( By.xpath("//li[contains(text(),'List Item 1')]"));
		listItem2 = driver.findElement( By.xpath("//li[contains(text(),'List Item 2')]"));
		listItem3 = driver.findElement( By.xpath("//li[contains(text(),'List Item 3')]"));
		list2Badge = driver.findElement( By.xpath("//span[contains(text(),'6')]"));
	}
	
	public void assertTest2() {
		Assert.assertEquals(true, listItem1.isDisplayed());
		System.out.println("List Item 1 is displayed – Assert passed");
		Assert.assertEquals(true, listItem2.isDisplayed());
		System.out.println("List Item 2 Input is displayed – Assert passed");
		Assert.assertEquals(true, listItem3.isDisplayed());
		System.out.println("List Item 3 is displayed – Assert passed");
		Assert.assertEquals(true, listItem2.toString().contains("List Item 2"));
		System.out.println("List Item 2 Contains expected text - Assert passed");
		Assert.assertEquals(true, list2Badge.toString().contains("6"));
		System.out.println("List Item 2 Badge value Contains expected value - Assert passed");
		
		
		
		

	}
}
