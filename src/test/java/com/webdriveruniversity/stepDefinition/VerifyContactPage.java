package com.webdriveruniversity.stepDefinition;


import org.junit.Assert;

import com.webdriveruniversity.common.BaseClass;
import com.webdriveruniversity.pages.ContactUsPage;
import com.webdriveruniversity.pages.ContactUsResponsePage;
import com.webdriveruniversity.pages.HomePage;
//import com.webdriveruniversity.common.Utilities;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class VerifyContactPage {


	@Given("^I am present on the home page of the WebDriver University$")
	public void i_am_present_on_the_home_page_of_the_WebDriver_University() {
		HomePage.open(BaseClass.driver);
		//Utilities.attachScreenshot(BaseClass.scenario, "Present on the home page");
	}

	@When("^I click the Contact Us page$")
	public void i_click_the_Contact_Us_page() {
	    HomePage.getContactUsButton(BaseClass.driver).click();
		//Utilities.attachScreenshot(BaseClass.scenario, "Clicked on the contact us page");
	}
	
	@When("^I switch to the new tab$")
	public void swtich_tabs() {
	    com.webdriveruniversity.common.Utilities.switchTabs(BaseClass.driver);
		//Utilities.attachScreenshot(BaseClass.scenario, "Switch tabs");
	}

	@When("^Enter the \"([^\"]*)\" as firstname, \"([^\"]*)\" as lastname, \"([^\"]*)\" as email and \"([^\"]*)\" as message$")
	public void enter_the_and(String firstName, String lastName, String email, String message) {
	    try{
	    	Thread.sleep(1000);
		    ContactUsPage.setFirstName(BaseClass.driver, firstName);
		    Thread.sleep(1000);
		    ContactUsPage.setLastName(BaseClass.driver, lastName);
		    Thread.sleep(1000);
		    ContactUsPage.setEmail(BaseClass.driver, email);
		    Thread.sleep(1000);
		    ContactUsPage.setMessage(BaseClass.driver, message);
		    Thread.sleep(1000);
			//Utilities.attachScreenshot(BaseClass.scenario, "Entered Details");
		    ContactUsPage.submitButton(BaseClass.driver).click();
	    }   
	    catch(Exception e) {	
	    }
	}

	@Then("^The user should get success message$")
	public void the_user_should_get_success_message() {
	   boolean response;
	   response = ContactUsResponsePage.verifySuccessMessage(BaseClass.driver);
	   if(response)
		   ; //Utilities.attachScreenshot(BaseClass.scenario, "Success message verified");
	   else 
		   Assert.fail("Success message not received");
	   }
	
	@Then("^The user should get error message as \"([^\"]*)\"$")
	public void the_user_should_get_error_message_as(String errorMessage) {
	    boolean passed;
	    passed = ContactUsResponsePage.verifyFailureMessage(BaseClass.driver, errorMessage);
	    if(!passed) {
	    	Assert.fail("Error message not found");
	    }
		//Utilities.attachScreenshot(BaseClass.scenario, "Error message verified");
	}
}
