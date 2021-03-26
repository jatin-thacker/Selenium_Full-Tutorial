package com.webdriveruniversity.stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.webdriveruniversity.common.BaseClass;
import com.webdriveruniversity.pages.ActionsPage;
import com.webdriveruniversity.pages.HomePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyActionClick {

	static String beforeDoubleClickColor = null;
	static String afterDoubleClickColor = null;
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
}
