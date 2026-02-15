package AmodMahajan;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreatingBooking {

	
//	@Test
	public void createUser1() {
		//Build Request
		RequestSpecification requestSpecification = RestAssured.given().log().all();
		requestSpecification.baseUri("https://api.restful-api.dev/objects");
		
		requestSpecification.body("{\r\n"
				+ "   \"name\": \"Apple MacBook Pro 16\",\r\n"
				+ "   \"data\": {\r\n"
				+ "      \"year\": 2019,\r\n"
				+ "      \"price\": 1849.99,\r\n"
				+ "      \"CPU model\": \"Intel Core i9\",\r\n"
				+ "      \"Hard disk size\": \"10 TB\"\r\n"
				+ "   }\r\n"
				+ "}");
		requestSpecification.contentType(ContentType.JSON);
		
		//Hit Request and Get Response
		Response response = requestSpecification.post();
		
		//validate the Response
		ValidatableResponse validatableResponse = response.then();
		validatableResponse.statusCode(200);
		validatableResponse.log().all();
		
	}
	
	@Test
	public void createUser2() {
		
		// build request
		Response response =	RestAssured.given()
		.log()
		.all()
		.baseUri("https://api.restful-api.dev/objects")
		.contentType(ContentType.JSON)
		.body("{\r\n"
				+ "   \"name\": \"Apple MacBook Pro 16\",\r\n"
				+ "   \"data\": {\r\n"
				+ "      \"year\": 2019,\r\n"
				+ "      \"price\": 1849.99,\r\n"
				+ "      \"CPU model\": \"Intel Core i9\",\r\n"
				+ "      \"Hard disk size\": \"10 TB\"\r\n"
				+ "   }\r\n"
				+ "}")
		// Hit Request and Get Response
		.post();
		
		// validate the Response
		response.then().log().all();
		int code = response.getStatusCode();
			
	}

}
