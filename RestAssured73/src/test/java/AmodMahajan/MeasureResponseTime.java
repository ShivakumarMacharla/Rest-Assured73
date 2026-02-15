package AmodMahajan;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class MeasureResponseTime {
	
public static void main(String[] args) {
	
	Response response = RestAssured
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
					+ "      \"Hard disk size\": \"190 TB\"\r\n"
					+ "   }\r\n"
					+ "}")
			.when()
				.post();
	
	Long milliSecondstime=  response.time();
	System.out.println("Time taken to execute milliSecondstime :"+milliSecondstime);
	Long responseTimeINSeconds = response.timeIn(TimeUnit.SECONDS);
	System.out.println("responseTimeINSeconds "+responseTimeINSeconds);
	
	//Assertion
	response.then().time(Matchers.lessThan(5000L));
	response.then().time(Matchers.greaterThan(3000L));
	
	response.then().time(Matchers.both(Matchers.greaterThan(2000L)) .and(Matchers.lessThan(5000L)));
				
	response.then().time(Matchers.lessThan(2L),TimeUnit.SECONDS);	
}
}
