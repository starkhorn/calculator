package com.starkhorn;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "target/test-classes/features",
		format = { "pretty", "html:target/test-reports" }
)

public class FeatureRunner {
	
}
