package com.webdriveruniversity.runner;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/"}, 
        tags = "@LinkTest",
        glue={"com.webdriveruniversity.stepDefinition"},
        plugin = {"pretty", "html:target/cucumber-reports"},
        publish = false
) 
public class RunnersTests {
    public static void main(String[] args) {
    }
}
