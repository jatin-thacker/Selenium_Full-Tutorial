package com.webdriveruniversity.common;

import java.util.ArrayList;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.Scenario;




public class Utilities {
	public static void switchTabs(WebDriver driver) {
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTb.get(1));
	}
	public static void attachScreenshot(Scenario scenario, String message) {
		final byte[] screenshot = ((TakesScreenshot) BaseClass.driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", message);
	}
}
