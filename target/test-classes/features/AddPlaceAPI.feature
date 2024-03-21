Feature: Validate Add Place API
	@AddPlace  @Regression
	Scenario Outline: verify place being sucessfully added or not
	Given Add place payload "<name>" "<address>" "<language>"
	When user call "AddPlaceAPI" with  http "POST" resquest
	Then API call is sucess with status code 200
	And "status" Response body is "OK"
	And "scope" Response body is "APP"
	And  user call "GetPlaceAPI" with  http "GET" resquest To verify place added or  not

	
	
	
	Examples:
	| name | address | language |
	| Yogesh| Rahata | Shirdi|
	
@DeletePlace  @Regression
	Scenario: Delete Place API
	Given Delete place payload 
	When user call "DeletePlaceAPI" with  http "POST" resquest
	Then API call is sucess with status code 200
	And "status" Response body is "OK"
	
	
