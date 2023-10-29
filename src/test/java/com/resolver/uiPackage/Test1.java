package com.resolver.uiPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Test1 {
	WebDriver driver;
	WebElement email;
	WebElement password;
	WebElement signinButton;

	public Test1(WebDriver driver){
		this.driver=driver;
		email = driver.findElement( By.id("inputEmail"));
		password = driver.findElement( By.id("inputPassword"));
		signinButton = driver.findElement(By.xpath("//button[contains(text(),'Sign in')]"));
	}
	
	
	public void assertTest1() {
		Assert.assertEquals(true, email.isDisplayed());
		System.out.println("Email Input is displayed – Assert passed");
		Assert.assertEquals(true, password.isDisplayed());
		System.out.println("Password Input is displayed – Assert passed");
		Assert.assertEquals(true, signinButton.isDisplayed());
		System.out.println("Sign In button is displayed – Assert passed");

	}


	public void sendEmailPassword(String inputEmail, String inputpassword) {
		email.sendKeys(inputEmail);
		password.sendKeys(inputpassword);
		
	}



}
