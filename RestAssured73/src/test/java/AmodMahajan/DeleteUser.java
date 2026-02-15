package AmodMahajan;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class DeleteUser {

	
	@Test
	public void deleteUser() {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.baseUri("https://api.restful-api.dev/objects/");
		requestSpecification.basePath("{id}");
		requestSpecification.pathParam("id", 6);
		
		Response response =	requestSpecification.delete();
		int code =	response.getStatusCode();
		
		Assert.assertEquals(code, 200);
		
	}
	
	@Test
	public void deleteUser2() {
		RestAssured
			.given().log().all()
				.baseUri("https://api.restful-api.dev/objects/")
				.basePath("{id}")
				.pathParam("id", 6)
//				.contentType(ContentType.JSON)
				
			.when()
				.delete()
			.then()
				.log()
				.all()
				.statusCode(200);
				
	}
}
