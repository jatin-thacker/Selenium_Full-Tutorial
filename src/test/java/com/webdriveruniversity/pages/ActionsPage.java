package com.webdriveruniversity.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionsPage {
	
	
static By doubleClickLocator = By.id("double-click");
	
	
	public static WebElement getDoubleClickIcon(WebDriver driver) {
		WebElement element = driver.findElement(doubleClickLocator);
		return element;
	}
}
