package AmodMahajan;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Request_ResponseSpecificationDemo {
	
	@Test
	public void Request_ResponseSpecificationDeom1() {
		
		RequestSpecification requestSpecific = RestAssured
				.given()
					.log()
					.all()
					.baseUri("https://api.restful-api.dev/objects")
					.contentType(ContentType.JSON);
		
		ResponseSpecification responseSpecification = RestAssured.expect();
		 responseSpecification.log().all();
		 responseSpecification.statusCode(200);
		 
		 RestAssured
			.given()
			.spec(requestSpecific)
			.log().all()
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
	@Test
	public void Request_ResponseSpecificationDeom2() {
			
			RequestSpecification requestSpecific = RestAssured
					.given()
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
								+ "      \"Hard disk size\": \"101 TB\"\r\n"
								+ "   }\r\n"
								+ "}");
			
			ResponseSpecification responseSpecification = RestAssured.expect();
			 responseSpecification.log().all();
			 responseSpecification.statusCode(200);
			 
			 RestAssured
				.given(requestSpecific, responseSpecification)
				//.spec(requestSpecific)
//				.log().all()
//						.baseUri("https://api.restful-api.dev/objects/")
//						.contentType(ContentType.JSON)
//						.body("{\r\n"
//								+ "   \"name\": \"Apple MacBook Pro 16\",\r\n"
//								+ "   \"data\": {\r\n"
//								+ "      \"year\": 2019,\r\n"
//								+ "      \"price\": 1849.99,\r\n"
//								+ "      \"CPU model\": \"Intel Core i9\",\r\n"
//								+ "      \"Hard disk size\": \"101 TB\"\r\n"
//								+ "   }\r\n"
//								+ "}")
					//.when()
						.post()
					.then();
					//	.spec(responseSpecification);
			 
		
	
		}
	
	

}
