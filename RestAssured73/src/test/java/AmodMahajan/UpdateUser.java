package AmodMahajan;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UpdateUser {
	
	
	@Test 
	public void updateuser() {
		
		RestAssured
			.given().log().all()
				.baseUri("https://petstore.swagger.io/v2/user/")
				.basePath("{username}")
				.pathParam("username", "shiva")
				.header("Content-Type","application/json")
				.body("{\r\n"
						+ "  \"id\": 0,\r\n"
						+ "  \"username\": \"shiva\",\r\n"
						+ "  \"firstName\": \"Uma\",\r\n"
						+ "  \"lastName\": \"string\",\r\n"
						+ "  \"email\": \"Shiva@gmail.com\",\r\n"
						+ "  \"password\": \"string\",\r\n"
						+ "  \"phone\": \"string\",\r\n"
						+ "  \"userStatus\": 1\r\n"
						+ "}")
			.when()
				.put()
			.then()
				.log()
				.all()
				.statusCode(200);
	}
	
	@Test
	public void patchUpdate() {
		RestAssured
				.given().log().all()
					.baseUri("https://petstore.swagger.io/v2/user/")
					.basePath("{usrName}")
					.pathParam("usrName", "shiva")
					.body("{\r\n"
							
							+ "  \"phone\": \"3467\",\r\n"
							
							+ "}")
					.contentType(ContentType.JSON)
				.when()
					.patch()
				.then()
					.log()
					.all()
					.statusCode(200);
					
				
				
	}

}
