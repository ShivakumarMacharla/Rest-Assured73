package vedio3;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Methods {
	
	@Test
	public void createUser() {
		
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type","application/json");
		
		JSONObject json = new JSONObject();
		json.put("id", "23");
		json.put("username", "shiva");
		json.put("firstName", "uma");
		json.put("lastName", "mach");
	
		
		request.body(json);
		
		Response rep = request.post("https://petstore.swagger.io/v2/user/createWithList");
		int code = rep.getStatusCode();
		Assert.assertEquals(code, 200);
		
		
		
		
	}
	
	@Test
	public void deleteUser() {
		RequestSpecification request = RestAssured.given();
		Response response = request.delete("https://petstore.swagger.io/v2/user/shiva");
		int code = response.getStatusCode();
		Assert.assertEquals(code, 200);
	}
	
		@Test
	public void updateUser() {
			
			RequestSpecification request = RestAssured.given();
			request.header("Content-Type","application/json");
			
			JSONObject json = new JSONObject();
			json.put("password", "Uma");
		
			
			request.body(json);
			
			Response rep = request.put("https://petstore.swagger.io/v2/user/ShivaAa");
			int code = rep.getStatusCode();
			Assert.assertEquals(code, 200);
		}
}
