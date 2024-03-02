package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;

public class StepDefination extends Utils{
	RequestSpecification requestBody;
	Response response;
   static String place_ID;
	TestDataBuild data = new TestDataBuild();
	@Given("Add place payload {string} {string} {string}")
	public void add_place_payload(String name, String address, String language) throws IOException {
		

	    requestBody= given().spec(commonData()).body(data.addPlacetestData(name , address , language));
	  
	}

	@When("user call {string} with  http {string} resquest")
	public void user_call_with_http_resquest(String resources, String method) {
		 
		//object of enum class 
		APIResources reso = APIResources.valueOf(resources);
		
		if(method.equalsIgnoreCase("POST"))
		response = requestBody.when().post(reso.getResource()).then().log().all().extract().response();
		
		else if (method.equalsIgnoreCase("GET")) {
			response = requestBody.when().get(reso.getResource()).then().log().all().extract().response();
		}
	}

	@Then("API call is sucess with status code {int}")
	public void api_call_is_sucess_with_status_code(int ExpectedStatusCode) {
		int getStatusCode=response.getStatusCode();
	 assertEquals(getStatusCode,ExpectedStatusCode);
	
	}

	@Then("{string} Response body is {string}")
	public void response_body_is(String parameter, String value ) {
		 assertEquals(getJsonPath(response,parameter ),value);
	}
	
	@Then("user call {string} with  http {string} resquest To verify place added or  not")
	public void user_call_with_http_resquest_to_verify_place_added_or_not(String resources, String method) throws IOException {
		 place_ID =getJsonPath(response, "place_id");
		System.out.println(place_ID);
		
		requestBody= given().spec(commonData()).queryParam("place_id",place_ID );
		user_call_with_http_resquest(resources,method);
		
	}
	
	@Given("Delete place payload")
	public void delete_place_payload() throws IOException {
		HashMap <String , Object> map = new HashMap<>();
		map.put("place_id", place_ID);
		System.out.println(map);
		requestBody = given().spec(commonData()).body(map);
		
	    
	}
}

