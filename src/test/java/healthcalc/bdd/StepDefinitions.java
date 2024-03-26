package healthcalc.bdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import healthcalc.HealthCalc;
import healthcalc.HealthCalcImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	private HealthCalc calc;
	private float result;
	private boolean exception;

	@Given("I have an health calculator")
	public void i_have_an_health_calculator() {
	    calc= new HealthCalcImpl();
	}
	@When("I estimate the ideal weight for negative height {int}")
	public void i_estimate_the_ideal_weight_for_negative_height(Integer int1) {
		try {
			calc.idealWeight(int1, 'm');
		}catch(Exception e) {
			exception= true;
		}
	}
	@Then("the calculator throws an exception")
	public void the_calculator_throws_an_exception() {
		assertTrue(exception);
	}

	@When("I estimate the ideal weight for an invalid gender {string}")
	public void i_estimate_the_ideal_weight_for_an_invalid_gender(String string) {
		try {
			calc.idealWeight(160, string.toCharArray()[0]);
		}catch(Exception e) {
			exception= true;
		}
	}

	@When("I estimate the ideal weight for gender {string} and height {int} and gives a negative result")
	public void i_estimate_the_ideal_weight_for_gender_and_height_and_gives_a_negative_result(String string, Integer int1) {
		try {
			calc.idealWeight(int1, string.toCharArray()[0]);
		}catch(Exception e) {
			exception= true;
		}
	}

	@When("I estimate the ideal weight for gender {string} and height {int}")
	public void i_estimate_the_ideal_weight_for_gender_and_height(String string, Integer int1) throws Exception {
	    result=calc.idealWeight(int1, string.toCharArray()[0]);
	}
	@Then("the calculator return a  result {string}")
	public void the_calculator_return_a_result(String string) {
		assertEquals(Float.parseFloat(string), result);
	}
}