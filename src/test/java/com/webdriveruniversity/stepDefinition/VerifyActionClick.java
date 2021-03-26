package com.webdriveruniversity.stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.webdriveruniversity.common.BaseClass;
import com.webdriveruniversity.common.Utilities;
import com.webdriveruniversity.pages.ActionsPage;
import com.webdriveruniversity.pages.HomePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyActionClick {

	static String beforeDoubleClickColor = null;
	static String afterDoubleClickColor = null;
	static int link = 0;
	
	@When("I click the Actions button icon")
	public void i_click_the_actions_button_icon() {
		WebElement button = HomePage.getActionButton(BaseClass.driver);
		try{
			button.click();
		}
		catch(Exception e) {
			JavascriptExecutor js = (JavascriptExecutor)BaseClass.driver;
			js.executeScript("arguments[0].click();", button);
		}
	}
	
	@When("I double click the DoubleClickMe icon")
	public void i_double_click_the_double_click_me_icon() {
	    WebElement button = ActionsPage.getDoubleClickIcon(BaseClass.driver);
	    Actions action = new Actions(BaseClass.driver);
	    beforeDoubleClickColor = button.getCssValue("background-color");
	    action.doubleClick(button).perform();
	}
	
	@Then("the color of icon should be changed")
	public void the_color_of_icon_should_be_changed() {
		WebElement button = ActionsPage.getDoubleClickIcon(BaseClass.driver);
	    afterDoubleClickColor = button.getCssValue("background-color");
	    Assert.assertNotEquals(beforeDoubleClickColor, afterDoubleClickColor);
	}
	
	@Then("^I hover over the \"([^\"]*)\" icon$")
	public void hover_the_link(int number) {
		link = number;
		try {
			WebElement hoverOver = ActionsPage.getHoverOverLink(BaseClass.driver, number);
			Actions action = new Actions(BaseClass.driver);
			action.moveToElement(hoverOver).perform();
		}
		catch (Exception e) {
			Assert.fail("Unable to hover over the link");
		}
	}
	
	@Then("the link should be visible")
	public void checking_the_link() {
		WebElement link;
		try {
			link = ActionsPage.getHiddenLink(BaseClass.driver);
			link.click();
		}
		catch (Exception e) {
			Assert.fail("Links is not visible");
		}
	}
	
	@Then("clicking the link should give you a pop-up")
	public void clicking_the_link() {
		String message = Utilities.readAndAcceptPopup(BaseClass.driver);
		//System.out.println(message + " is popped-up");
	}
}
