package Bookstore;

import org.testng.annotations.Test;

import BaseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Authentication extends BaseTest{
	
	RequestSpecification req;
	Response res;
	@Test
	public void getAuthentication()
	{
		RestAssured.baseURI="https://bookstore.toolsqa.com/swagger/";
		req=RestAssured.given();
		
		req.header("Content-Type","application/json");
		req.body("{\r\n"
				+ "  \"userName\": \"akash\",\r\n"
				+ "  \"password\": \"1234\"\r\n"
				+ "}");
		res=req.post("/Account/V1/GenerateTokenPost");
	String body=res.getBody().asPrettyString();
	System.out.println(body);
	int statuscode=res.getStatusCode();
	System.out.println("the status code is : "+statuscode);
		
	}

}
