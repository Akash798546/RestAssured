package BaseTest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class GetRequest extends BaseTest{
	
	@Test
	public void get_Request()
	{
		test.info("Initializing Request");
		RestAssured.baseURI="https://reqres.in/api/";
		RequestSpecification httpRequest=RestAssured.given();
		Response res=httpRequest.request(Method.GET,"users");
		String responsebody=res.getBody().asPrettyString();
		System.out.println("The Response body is ---");
		System.out.println(responsebody);
		test.info("Verifying Status code");
		Assert.assertEquals(200, res.getStatusCode());
		System.out.println("The Status code is -- "+res.getStatusCode());
		test.info("Verifying Content Type");
		System.out.println("The Content Type is ----"+res.contentType().toString());
		
		
		Headers allhead=res.headers();
		for(Header head:allhead)
		{
			System.out.println(head.getName()+" : "+head.getValue() 	);
		}
		
	}

}
