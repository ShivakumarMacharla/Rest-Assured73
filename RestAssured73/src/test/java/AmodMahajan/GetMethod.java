package AmodMahajan;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetMethod {
	
	@Test
	public void getSingleuser() {
		
		RequestSpecification requestSpecification = RestAssured.given().log().all();
		requestSpecification.baseUri("https://api.restful-api.dev/objects/");
		requestSpecification.basePath("{id}");
		requestSpecification.pathParam("id", 1);
		
		Response response = requestSpecification.get();
		ValidatableResponse validatableResponse = 	response.then().log().all();
		validatableResponse.statusCode(200);
			
	}
	
	@Test
	public void getSingleUser() {
		//build request
		RestAssured
				.given()
					.header("Connection", "keep-alive")
					.baseUri("https://api.restful-api.dev/objects/")
					.basePath("{id}")
					.pathParam("id", 7)
					.log()
					.all()
					
			// hit the request and get the response		
				.when()
					.get()
					
			// validate the response		
				.then()
					.log()
					.body()
					.statusCode(200);
		
	}
	
//	@Test
	public void getMultipeUser() {
		RestAssured
			.given()
				.baseUri("https://api.restful-api.dev/objects?id=3&id=5&id=10");
				
	}

}
