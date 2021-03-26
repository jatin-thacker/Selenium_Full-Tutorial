package com.webdriveruniversity.pages;


import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ActionsPage {
	
	
static By doubleClickLocator = By.id("double-click");
static By firstHoverLocator = By.xpath("//div[@class='dropdown hover']"); 
static By secondHoverLocator = By.xpath("//div[@class='dropdown'][@style='float:center;']"); 
static By thirdHoverLocator = By.xpath("//div[@class='dropdown'][@style='float:right;']");
//static By hiddenLink = By.className("list-alert");
static int numberLinks = 0;

	public static WebElement getDoubleClickIcon(WebDriver driver) {
		WebElement element = driver.findElement(doubleClickLocator);
		return element;
	}
	
	public static WebElement getHoverOverLink(WebDriver driver, int number) throws Exception {
		WebElement element;
		numberLinks = number;
		if (number == 1) {
			element = driver.findElement(firstHoverLocator);
		}
		else if (number == 2) {
			element = driver.findElement(secondHoverLocator);
		}
		else if (number == 3) {
			element = driver.findElement(thirdHoverLocator);
		}
		else
			throw new Exception ("Link is not present");
		//hovered = element;
		return element;
	}
	
	public static WebElement getHiddenLink(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10); 
		WebElement link = null;
		List<WebElement> links = new ArrayList<WebElement>();;
		if (numberLinks == 1) {
			link = driver.findElement(firstHoverLocator).findElement(By.tagName("a"));
		}
		else if (numberLinks == 2) {
			link = driver.findElement(secondHoverLocator).findElement(By.tagName("a"));
		}
		else if (numberLinks == 3) {
			link = driver.findElement(thirdHoverLocator).findElement(By.tagName("a")); 
		}
		else {
			Assert.fail("Link number invalid");
		}
		try{
				wait.until(ExpectedConditions.visibilityOf(link));
				Actions action = new Actions(driver); 
				action.moveToElement(link);
				wait.until(ExpectedConditions.elementToBeClickable(link));
		}
		catch(Exception e) {
			//e.printStackTrace();
			Assert.fail(e.getMessage());
		}
		return link;
	}
}
