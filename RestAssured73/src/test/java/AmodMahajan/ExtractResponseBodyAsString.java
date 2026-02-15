package AmodMahajan;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ExtractResponseBodyAsString {
	
	
	@Test
	public void postMethod() {
		
	String rep =	RestAssured
			.given()
				.log().all()
				.baseUri("https://api.restful-api.dev/objects")
				.contentType(ContentType.JSON)
				.body("{\r\n"
						+ "   \"name\": \"Apple MacBook Pro 16\",\r\n"
						+ "   \"data\": {\r\n"
						+ "      \"year\": 2019,\r\n"
						+ "      \"price\": 1849.99,\r\n"
						+ "      \"CPU model\": \"Intel Core i9\",\r\n"
						+ "      \"Hard disk size\": \"0 TB\"\r\n"
						+ "   }\r\n"
						+ "}")
			.when()
				.post()
			.then()
//				.log()
//				.all()
				.extract()
				.body()
//				.asString();
				.asPrettyString();
	
	System.out.println(rep);
	}

}
