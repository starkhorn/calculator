package com.starkhorn.calculator;

import static org.junit.Assert.assertEquals;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CalculatorSteps {
	
	private String input;
	private String output;
	
	@Given("^the input \"([^\"]*)\"$")
	public void the_input(String input) throws Throwable {
		this.input = input;
	}

	@When("^the calculator is run$")
	public void the_calculator_is_run() throws Throwable {
		this.output = new Calculator().run(this.input);
	}

	@Then("^the output should be \"([^\"]*)\"$")
	public void the_output_should_be_(String expected_output) throws Throwable {
		assertEquals(expected_output, this.output);
	}
	
}
