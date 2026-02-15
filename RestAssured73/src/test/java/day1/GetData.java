package day1;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/*
 given()
 	content type, set cookies, add auth, add param, set headers info etc..
 when()
 	get, post, put, delete
 then()
 	validate status code,extract response, extract headers cookies and respone body..
 
 */

public class GetData {
	
	//@Test
	public void testResponseCode(){
		
		Response resp =	RestAssured.get("https://petstore.swagger.io/v2/pet/findByStatus?status=available");
		int code  = resp.getStatusCode();
		System.out.println("Status code is : "+code);
		Assert.assertEquals(code, 200);
		
		}
	@Test
	public void testBody() {
		Response rep = RestAssured.get("https://petstore.swagger.io/v2/pet/findByStatus?status=available");
		String body =	rep.getBody().asString();
		System.out.println(body);
	
	}
	@Test
	public void testGet() {
		
		 RestAssured.get("");
	}
	
	
}
