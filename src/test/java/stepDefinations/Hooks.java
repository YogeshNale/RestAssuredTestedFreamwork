package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@DeletePlace")
	public void preConditionDeletePlaceAPI() throws IOException {
		StepDefination step = new StepDefination();
		step.add_place_payload("Shiv", "Shiv1", "Shiv2");
		step.user_call_with_http_resquest("AddPlaceAPI", "POST");
		step.user_call_with_http_resquest_to_verify_place_added_or_not("GetPlaceAPI", "GET");
		
	}
}
