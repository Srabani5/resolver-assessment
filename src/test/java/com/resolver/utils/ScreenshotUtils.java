package com.resolver.utils;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

/**
 * A utility class for capturing and saving screenshots of web elements.
 */
public class ScreenshotUtils {
    /**
     * Captures a screenshot of a web element and saves it to a file.
     *
     * @param element        The web element to capture a screenshot of.
     * @param screenshotName The name to use for the saved screenshot file.
     */
	public void captureScreenshotfromPage(WebElement element, String screenshotName) {
		try {
			File source = element.getScreenshotAs(OutputType.FILE);
			File destination = new File(""+ screenshotName + ".png");
			FileUtils.copyFile(source, destination);
			System.out.println("Screenshot saved to Path " + screenshotName + ".png");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
