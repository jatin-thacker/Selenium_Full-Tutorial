package com.webdriveruniversity.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClickButtonPage {
	static By firstClickButton = By.xpath("//*[@id='button1']");
	static By secondClickButton = By.cssSelector("span#button2");
	static By thirdClickButton = By.id("button3");
	static By popupLocator = By.xpath("//*[@class='modal fade in show']//div[@class='modal-body']/p");
	
	
	public static WebElement getFirstLink(WebDriver driver) {
		WebElement element = driver.findElement(firstClickButton);
		return element;
	}
	
	public static WebElement getSecondLink(WebDriver driver) {
		WebElement element = driver.findElement(secondClickButton);
		return element;
	}
	
	public static WebElement getThirdLink(WebDriver driver) {
		WebElement element = driver.findElement(thirdClickButton);
		return element;
	}
	
	public static String getTextFromPopup(WebDriver driver) {
		String result = driver.findElement(popupLocator).getText();
		return result;
	}
}
