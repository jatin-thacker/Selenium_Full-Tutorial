package com.webdriveruniversity.stepDefinition;
import com.webdriveruniversity.pages.HomePage;
import com.webdriveruniversity.pages.LoginPage;
import com.webdriveruniversity.common.BaseClass;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class VerifyLoginPage {
	
	
	@io.cucumber.java.en.When("I click the login button")
	public void click_the_login_button() {
		HomePage.getLoginButton(BaseClass.driver).click();
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
