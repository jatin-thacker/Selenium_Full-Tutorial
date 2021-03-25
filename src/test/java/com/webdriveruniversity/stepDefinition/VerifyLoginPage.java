package com.webdriveruniversity.stepDefinition;
import com.webdriveruniversity.pages.HomePage;
import com.webdriveruniversity.pages.LoginPage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.webdriveruniversity.common.BaseClass;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class VerifyLoginPage {
	
	
	@io.cucumber.java.en.When("I click the login button")
	public void click_the_login_button() {
		WebElement button = HomePage.getLoginButton(BaseClass.driver);
		try {
			button.click();
		}
		catch(Exception e) {
			JavascriptExecutor js = (JavascriptExecutor)BaseClass.driver;
			js.executeScript("arguments[0].click();", button);
		}
	}
	
	@When("^Enter the \"([^\"]*)\" as username and \"([^\"]*)\" as password$")
	public void enter_the_credentials(String uname, String pwd) {
		LoginPage.setUsername(BaseClass.driver, uname);
		LoginPage.setPwd(BaseClass.driver, pwd);
		LoginPage.getSubmitButton(BaseClass.driver).click();
	}
	
	@Then("The user should get a pop-up")
	public void verify_login() {
		System.out.println(BaseClass.driver.switchTo().alert().getText());
		BaseClass.driver.switchTo().alert().accept();
	}
}
