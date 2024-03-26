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

		///////////////////////////////////////////////////////////////////////////
	//////////////Peso ideal /////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////

	@When("I estimate the ideal weight for negative height {int}")
	public void i_estimate_the_ideal_weight_for_negative_height(Integer inte) {
		try {
			calc.idealWeight(inte, 'm');
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
	public void i_estimate_the_ideal_weight_for_gender_and_height_and_gives_a_negative_result(String string, Integer inte) {
		try {
			calc.idealWeight(inte, string.toCharArray()[0]);
		}catch(Exception e) {
			exception= true;
		}
	}

	@When("I estimate the ideal weight for gender {string} and height {int}")
	public void i_estimate_the_ideal_weight_for_gender_and_height(String string, Integer inte) throws Exception {
	    result=calc.idealWeight(inte, string.toCharArray()[0]);
	}
	@Then("the calculator return a  result {string}")
	public void the_calculator_return_a_result(String string) {
		assertEquals(Float.parseFloat(string), result);
	}

	///////////////////////////////////////////////////////////////////////////
	//////////////Basal metabolic rate /////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	@When("I estimate the basal metabolic rate with invalid ehight {int}")
	public void i_estimate_the_basal_metabolic_rate_with_invalid_height(Integer inte) {
		try {
			calc.basalMetabolicRate(40, inte, 'm', 21);
		}catch(Exception e) {
			exception= true;
		}
	}

	@When("I estimate the basal metabolic rate with invalid gender {string}")
	public void i_estimate_the_basal_metabolic_rate_with_invalid_gender_h(String string) {
		try {
			calc.basalMetabolicRate(40, 150, string.toCharArray()[0], 21);
		}catch(Exception e) {
			exception= true;
		}
	}

	@When("I estimate the basal metabolic rate with negative age {int}")
	public void i_estimate_the_basal_metabolic_rate_with_negative_age(Integer inte) {
		try {
			calc.basalMetabolicRate(70, 140, 'w', inte);
		}catch(Exception e) {
			exception= true;
		}
	}

	@When("I estimate the basal metabolic rate with invalid weight {int}")
	public void i_estimate_the_basal_metabolic_rate_with_invalid_weight(Integer inte) {
		try {
			calc.basalMetabolicRate(inte, 170, 'w', 21);
		}catch(Exception e) {
			exception= true;
		}
	}

	@When("I estimate the basal metabolic rate for the given valid parameters {int} , {int} , {string} , {int}")
	public void i_estimate_the_basal_metabolic_rate_for_the_given_valid_parameters(Integer inte, Integer inte2, String str, Integer inte3) throws Exception {
		result=calc.basalMetabolicRate(inte, inte2, str.toCharArray()[0], inte3);
	}
	@Then("the system returns a result {string}")
	public void the_system_returns_a_result(String str) {
		assertEquals(Float.parseFloat(str), result);
	}
}