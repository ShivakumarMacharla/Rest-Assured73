package AmodMahajan;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecificationDemo {
	
	ResponseSpecification responseSpecification;
	
	@BeforeClass
	public void setup() {
		 responseSpecification = RestAssured.expect();
		 responseSpecification.log().all();
		 responseSpecification.statusCode(200);
	}
	
	@Test
	public void createUser() {
		
		RestAssured
			.given().log().all()
					.baseUri("https://api.restful-api.dev/objects/")
					.contentType(ContentType.JSON)
					.body("{\r\n"
							+ "   \"name\": \"Apple MacBook Pro 16\",\r\n"
							+ "   \"data\": {\r\n"
							+ "      \"year\": 2019,\r\n"
							+ "      \"price\": 1849.99,\r\n"
							+ "      \"CPU model\": \"Intel Core i9\",\r\n"
							+ "      \"Hard disk size\": \"101 TB\"\r\n"
							+ "   }\r\n"
							+ "}")
				.when()
					.post()
				.then()
					.spec(responseSpecification);
	}

}
