package com.webdriveruniversity.runner;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/"}, 
        //tags = "@ActionsTest",
        glue={"com.webdriveruniversity.stepDefinition"},
        plugin = {"pretty", "html:target/cucumber-reports"},
        publish = true
) 
public class RunnersTests {
    public static void main(String[] args) {
    }
}
