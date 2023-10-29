package com.resolver.uiPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Test3 {
	WebDriver driver;
	WebElement dropdownDefault;
	WebElement dropdown;
	WebElement dropdown3;
	Select option3;
	WebElement dropdownshow;
	//WebElement dropdown3;
	public Test3(WebDriver driver){
		this.driver=driver;
		dropdownDefault = driver.findElement( By.id("dropdownMenuButton"));
		dropdown = driver.findElement(By.xpath("//div[@class='dropdown-menu']"));
		dropdownDefault.click();
		dropdownshow=driver.findElement(By.xpath("//div[@class='dropdown-menu show']"));
		
	
		
		dropdown3 = driver.findElement(By.xpath("//a[contains(text(),'Option 3')]"));	
		
	}
	
	public void assertTest3() {
		Assert.assertEquals(true, dropdownDefault.getText().equals("Option 1"));
		System.out.println("Dropdown default value contains expected value – Assert passed");
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		dropdown3.click();
		System.out.println(dropdownDefault.getText());
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

	}
}
