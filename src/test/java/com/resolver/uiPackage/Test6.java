package com.resolver.uiPackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Test6 {
	WebDriver driver;
	WebElement table;
	WebElement cell;
	
	public Test6(WebDriver driver){
		this.driver=driver;
	
	}
	
	public String getCellValueInGrid(WebDriver driver, int row, int column) {
	    try {
	        // Find the table element using the provided locator
	    	table = driver.findElement(By.xpath("//table[@class='table table-bordered table-dark']"));

	        // Find the specific row and column within the table
	        cell = table.findElement(By.xpath(".//tr[" + (row+1) + "]/td[" + (column+1) + "]"));

	        // Get the text (value) of the cell
	        String cellValue = cell.getText();

	        return cellValue;
	    } catch (Exception e) {
	        // Handle exceptions if the element is not found or other issues
	        e.printStackTrace();
	        return null;
	    }
	}
	
	public void assertTest6() {
		String cellValue = getCellValueInGrid( driver, 2, 2);
		Assert.assertEquals(cellValue, "Ventosanzap");
		System.out.println("Cell Value expected – Assert passed");
		}
}