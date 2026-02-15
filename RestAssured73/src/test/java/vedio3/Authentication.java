package vedio3;

import org.testng.annotations.Test;

import io.restassured.RestAssured;


public class Authentication {

	@Test
	public void test_auth() {
		
		int code = RestAssured.given().auth().preemptive().basic("ToolsQA", "TestPassword").when().get("https://restapi.demoqa.com/authentication/   ").getStatusCode();
		System.out.println(code);
	
	}
	@Test
	public void test_Oauth2() {
		
	}
}
