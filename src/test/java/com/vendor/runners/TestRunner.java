package com.vendor.runners;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = "stepDefinitions", plugin = {
		"html:target/cucumber-reports.html" })
public class TestRunner extends AbstractTestNGCucumberTests {
}
