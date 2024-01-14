package tests;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class testOnLocalApi {
	
	@Test
	public void getLocalApi() {
		
		baseURI= "http://localhost:3000";
		
		given().get("/subjects/1").then().statusCode(200).log().all();
		
		//given().get("/subjects").then().statusCode(200).log().all();
		
	}
	
	@Test
	public void posttest() {
		baseURI= "http://localhost:3000";
		
		JSONObject request = new JSONObject();
		request.put("id",7);
		request.put("name", "appium");
		request.put("id",9);
		request.put("name", "nativeapps76587");
		
		given().
			header("content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/subjects").then().statusCode(201).log().all();
		
		
		
	} 

	@Test
	public void puttest() {
		baseURI= "http://localhost:3000";
		
		JSONObject request = new JSONObject();
		
		request.put("id", "7");
		request.put("name", "developer123");
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().put("/subjects/9").
		then().statusCode(200).log().all();
		
		
	}
	
	@Test
	public void patchTest() {
		
		baseURI=  "http://localhost:3000";
	JSONObject request = new JSONObject();
		
		request.put("id", 7);
		request.put("name", "news");
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().patch("/subjects/5").
		then().statusCode(200).log().all();
		
				
	} 
	
	@Test
	public void deleteTest() {
		
		baseURI=  "http://localhost:3000";
		
		when().delete("/subjects/9").then().statusCode(200).log().all();
		
		
		
	}
	}

