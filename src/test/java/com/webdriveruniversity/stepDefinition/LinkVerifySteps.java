package com.webdriveruniversity.stepDefinition;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.WebElement;
import com.webdriveruniversity.common.BaseClass;
import com.webdriveruniversity.pages.HomePage;
import org.junit.Assert;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LinkVerifySteps {
	//Variables 
	Boolean linksBroken = false;
	String output;
	//Step Definitions start here 
	@Given("^I am present on the home page of the WebDriver$")
	public void i_am_present_on_the_home_page_of_the_WebDriver() {
    	HomePage.open(BaseClass.driver);
	}
	@When("^I check all the links$")
	public void i_check_all_the_links() {
		String homePage = "http://webdriveruniversity.com";
    	String url = "";
    	HttpURLConnection huc = null;
	    int respCode = 200;
	    List <WebElement> allLinks = HomePage.getAllLinks(BaseClass.driver);
	    for (WebElement link : allLinks) {
	    		url = link.getAttribute("href");
		    	try 
		    	{
		    		if ( url == null || url.isEmpty() ) {
		    		output = (link.getAttribute("href")+ "URL is not configured or anchor tag is empty");
	                //BaseClass.scenario.write(output);
		    		continue;
		    	}
		    	if (!url.startsWith(homePage)){
		    		output = (link.getAttribute("href")+ "URL belongs to other domain, skipping it");
	                //BaseClass.scenario.write(output);
		    		continue;
	            }
                huc = (HttpURLConnection)(new URL(url).openConnection());
                huc.setRequestMethod("HEAD");
                huc.connect();
                respCode = huc.getResponseCode();
                if(respCode >= 400){
                	output = (link.getAttribute("href") +" is a broken link");
                	linksBroken = true;
                }
                else{
                	output = (link.getAttribute("href") +" is a valid link");
                }
                //BaseClass.scenario.write(output);
            } 
	    	catch (Exception e) {
	            System.out.println(e.getLocalizedMessage());
	        }        
	    }
	}
	
	@Then("^All the links should return a succcess return code$")
	public void all_the_links_should_return_a_succcess_return_code() {
		if(linksBroken)
			Assert.fail("Links invalid");
	}
	// Step Definitions end here 
}
