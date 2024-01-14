package tests;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class putPatchDeleteExample {
	
	
	@Test
	public void testPut() {

		baseURI= "https://reqres.in/api";
		
		JSONObject request = new JSONObject();
		
		
		request.put("name", "RAJESH");
		request.put("job", "Teacher");
		
		given().header("ContentType","Application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("/user/2").
		then().
			statusCode(200).log().all();
			
		
	}
	@Test
public void pathchTest() {
	JSONObject request = new JSONObject();
	
	baseURI = "https://reqres.in/api";
	
	request.put("name", "Rajesh");
	request.put("Job", "testing");
	
	
	given().header("Content-Type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
	when().patch("/user/2").
	then().statusCode(200).log().all();
	
}
	@Test
	public void deleteTest() {
		
		baseURI= "https://reqres.in/api";

		when().delete("/user/2").
		then().statusCode(204).log().all();
		
	}
}
