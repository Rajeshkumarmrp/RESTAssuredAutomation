package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;


import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.* ;
import static org.hamcrest.Matchers.* ;


public class GetAndPostExample {
	
	@Test
	public void testGet() {
		//base url
		
		baseURI="https://reqres.in/api";
		given().get("/users?page=2").
		then().statusCode(200).body("data[4].first_name", equalTo("George"));
		
		
	}
	
	@Test
	public void testPost() {
		
	//	HashMap<String , Object> map=new HashMap<String , Object>();
	//	map.put("name", "Rajesh");
	//	map.put("ID", 22);
	//	System.out.println(map);
		baseURI= "https://reqres.in/api";

		
		JSONObject request = new JSONObject();
		
		request.put("NAME", "RAJESH");
		request.put("ID", 55);
		
		given().header("ContentType","Application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/user").
		then().
			statusCode(200).log().all();
		
		
	}

}
