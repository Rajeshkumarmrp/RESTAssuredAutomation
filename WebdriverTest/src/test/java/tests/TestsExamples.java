package tests;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import junit.framework.Assert;

public class TestsExamples {
	@Test
	public void test_1() {
		
		Response response= get("https://reqres.in/api/users?page=2");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getHeader("content-type"));
		
		Assert.assertEquals(response.getStatusCode(), 201);	
		}
	
	@Test
	public void test_2() {
		
		baseURI= "https://reqres.in/api";
		given().get("/users?page=2").
		then().statusCode(200);
	}

}
