package com.webdriveruniversity.stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.webdriveruniversity.common.BaseClass;
import com.webdriveruniversity.pages.ClickButtonPage;
import com.webdriveruniversity.pages.HomePage;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class ButtonClick{
	
	@When("^I click the Click_button icon$")
	public void i_click_the_click_button_icon() {
	    HomePage.getClickButton(BaseClass.driver).click();
	}
	
	@When("^I click the \"([^\"]*)\" click element$")
	public void i_click_the_click_first_click_element(int n) {
		try{
				if(n==1) {
				ClickButtonPage.getFirstLink(BaseClass.driver).click();
			}
			else if(n ==2) {
				JavascriptExecutor js = (JavascriptExecutor)BaseClass.driver;
				WebElement button = ClickButtonPage.getSecondLink(BaseClass.driver);
				js.executeScript("arguments[0].click();", button);	
			}
			else if(n == 3) {
				WebElement button = ClickButtonPage.getThirdLink(BaseClass.driver);
				Actions action = new Actions(BaseClass.driver);
				action.moveToElement(button).click().perform();
			}
			else throw new Exception();
		}
		catch (Exception E){
			Assert.fail("There are just three buttons, the value is not within the range!");
		}
	}
	
	@Then("^The user should get acknowledgment and pop-up with the message as \"([^\"]*)\"$")
	public void enter_the_credentials(String message) {
		try{
			Thread.sleep(1000);
		}
		catch(Exception e) {
			;
		}
		String result = ClickButtonPage.getTextFromPopup(BaseClass.driver);
		if (result.contains(message))
			;
		else {
			String errorReport = "Actual:" + result + " Expected: " + message;
			Assert.fail(errorReport);
		}
	}
}