package tests;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class soapXMLRequest {
	
	@Test
	public void validateSoapXML() throws IOException {
		
		FileInputStream fileInputStream = new FileInputStream(new File("./SoapRequest/add.xml"));
		String requestBody = IOUtils.toString(fileInputStream, "UTF-8");

		//Note: IOUtils comes from apache.commons
		//If required get the pom dependency

		File file = new File("./SOAPRequest/add.xml");
		 if (file.exists()){
		  System.out.println("  - -  File exists");
		 }

		given().
		 contentType("text/xml").
		 header("Accept", "text/xml").
		 body(requestBody).

		when().post("/calculator.asmx").

		then().statusCode(200).log().all();
		
	}

}
