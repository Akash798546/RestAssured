package BaseTest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import net.minidev.json.JSONObject;

public class PutRequest extends BaseTest{
	
	int id=2;
	
	@Test
	public void getPutRequest()
	{
		
		test.info("Getting the Base url");
		RestAssured.baseURI="https://reqres.in/";
		RequestSpecification req=RestAssured.given();
		JSONObject reqpar=new JSONObject();
		test.info("Putting the Json data");
		reqpar.put("name", "Peter");
		reqpar.put("job", "Jr. QA");
		req.body(reqpar.toJSONString());
		Response response=req.put("api/users/"+id);
		test.info("Getting the response body");
		String resbody=response.getBody().asPrettyString();
		System.out.println("The Response Body is : "+resbody);
		int statusCode=response.getStatusCode();
		System.out.println("The Status code is : "+statusCode);
		test.info("Verifying status code");
		Assert.assertEquals(200, statusCode);
		
		
		
	}

}
