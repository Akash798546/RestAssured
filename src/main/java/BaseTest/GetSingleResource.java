package BaseTest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class GetSingleResource {
	
	int id=2;
	
	@Test
	public void getSingleRes()
	{
		RestAssured.baseURI="https://reqres.in/";
		RequestSpecification rs=RestAssured.given();
		Response res=rs.request(Method.GET,"/api/unknown/"+id);
		String body=res.getBody().asPrettyString();
		System.out.println("The Response is ---"+body);
		String name=res.jsonPath().getString("data.name");
		System.out.println("The given name is ---- "+name);
		Assert.assertEquals("fuchsia rose", name);
		int statuscode=res.getStatusCode();
		System.out.println("The status code is ---- "+statuscode);
		Assert.assertEquals(200, statuscode);
	}

}
