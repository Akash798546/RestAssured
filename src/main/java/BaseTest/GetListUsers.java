package BaseTest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetListUsers {
	
	@Test
	public void getList()
	{
		RestAssured.baseURI="https://reqres.in/";
		RequestSpecification req=RestAssured.given();
		req.queryParam("page", 2);
		Response res=req.request(Method.GET,"api/users");
		String resbody=res.getBody().asPrettyString();
		System.out.println("The Response body is ------");
		System.out.println(resbody);
		System.out.println("The status code is --- "+res.getStatusCode());
		String getEmail=res.jsonPath().getString("data.email[1]");
		System.out.println("The Email is --- "+getEmail);
		
	}

}
