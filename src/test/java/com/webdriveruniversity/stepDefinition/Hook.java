package com.webdriveruniversity.stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.webdriveruniversity.common.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hook{
	
	
	
	@Before(order = 0)
	public void initDriver(Scenario scenario) {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		BaseClass.scenario = scenario;
		System.out.println("Debug flag 1 ");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
		options.addArguments("--no-sandbox"); // Bypass OS security model
		//options.addArguments("--headless"); // Bypass OS security model
		BaseClass.driver = new ChromeDriver(options);
		BaseClass.driver.manage().window().maximize();
		BaseClass.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	
	@After(order = 0)
	public static void writeExtentReport(Scenario scenario) {
		if(scenario.isFailed()){
			try {
				;
			}
			catch (Exception e) {
				System.out.println("Something failed while taking screenshots");
			}
			finally {
				BaseClass.driver.quit();
			}
		}
		else{
			try {
				;
			}
			catch (Exception e) {
				System.out.println("Something failed while taking screenshots");
			}
			finally {
				BaseClass.driver.quit();
			}
		}
	}

}
