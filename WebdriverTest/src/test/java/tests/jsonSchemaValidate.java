package tests;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.* ;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class jsonSchemaValidate {
	
	//THis schema validation test is used to validate our json is corret. If you chnage any json field value.
	//ID data typr change to string it throws error while running
	
	@Test
	public void jsonschemavalidation() {
		
		baseURI = "https://reqres.in/api";
		
		given().get("//users?page=2").
		then().
			assertThat().
			body(matchesJsonSchemaInClasspath("schema.json")).statusCode(200);
		
	}

}
