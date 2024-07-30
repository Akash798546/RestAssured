package BaseTest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class SingleUserGetRequest extends BaseTest {
	
	int id=2;
	
	@Test
	public void getSingleUser()
	{

		test.info("Getting the Base Url");
		RestAssured.baseURI="https://reqres.in/";
		RequestSpecification req=RestAssured.given();
		Response resp=req.request(Method.GET,"api/users/"+id);
		test.info("Getting the Response body");
		String resbody=resp.getBody().asPrettyString();
		System.out.println("The Response body is : "+resbody);
		System.out.println("The Status code is : "+resp.getStatusCode());
		test.info("Verifyng status code");
		Assert.assertEquals(200, resp.getStatusCode());
		
	}

}
