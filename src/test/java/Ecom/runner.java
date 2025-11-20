package Ecom;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "C:\\Users\\HP\\IdeaProjects\\Project\\src\\test\\java\\Ecom\\Ecom.feature",
        glue = {"Ecom"},monochrome = true)

public class runner extends AbstractTestNGCucumberTests {
}
