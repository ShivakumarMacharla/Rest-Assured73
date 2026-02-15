package AmodMahajan;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class RestAssuredScriptInBDDFormate {

	public static void main(String[] args) {
		
		//Given - pre conditions --> Build Request
		
		RestAssured
			.given()
				.log()
				.all()
				.baseUri("https://api.restful-api.dev/objects")
				.body("{\r\n"
						+ "   \"name\": \"Apple MacBook Pro 16\",\r\n"
						+ "   \"data\": {\r\n"
						+ "      \"year\": 2019,\r\n"
						+ "      \"price\": 1849.99,\r\n"
						+ "      \"CPU model\": \"Intel Core i9\",\r\n"
						+ "      \"Hard disk size\": \"100 TB\"\r\n"
						+ "   }\r\n"
						+ "}")
				.contentType(ContentType.JSON)
			.when()
				.post()
			.then()
				.log()
				.all()
				.statusCode(200);

	}

}
