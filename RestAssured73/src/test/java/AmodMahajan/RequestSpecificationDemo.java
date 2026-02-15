package AmodMahajan;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationDemo {
	
	RequestSpecification requestSpecific;
	
	@BeforeClass
	public void setUprequestSpecification() {
		requestSpecific = RestAssured
													.given()
														.log()
														.all()
														.baseUri("https://api.restful-api.dev/objects")
														.contentType(ContentType.JSON);
		
	}
	
	@Test
	public void  createUser() {
		RestAssured
			.given()
				.spec(requestSpecific)
				.body("{\r\n"
						+ "   \"name\": \"Apple MacBook Pro 16\",\r\n"
						+ "   \"data\": {\r\n"
						+ "      \"year\": 2019,\r\n"
						+ "      \"price\": 1849.99,\r\n"
						+ "      \"CPU model\": \"Intel Core i9\",\r\n"
						+ "      \"Hard disk size\": \"100 TB\"\r\n"
						+ "   }\r\n"
						+ "}")
				.when()
					.post()
				.then()
					.log()
					.all()
					.statusCode(200);
	}

}
