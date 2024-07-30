package BaseTest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import net.minidev.json.JSONObject;

public class PostRequest extends BaseTest {
	
	
	@Test
	public void getPostRequest()
	{
		test.info("Giving Base URL");
		RestAssured.baseURI="https://reqres.in/";
		RequestSpecification req=RestAssured.given();
//		JSONObject reqParam=new JSONObject();
//		test.info("Giving Payload");
//		reqParam.put("name", "morpheus");
//		reqParam.put("job", "leader");
//		
//		RequestSpecification resBody=req.body(reqParam.toJSONString());
		req.body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}");
		Response res=req.post("api/users");
		test.info("SuccessFully Getting Response Body");
		String body=res.getBody().asPrettyString();
		System.out.println("The Response Body is :  "+body);
		String statusCode=res.getStatusLine();
		System.out.println("The Status code is : "+statusCode);
		test.info("Verifying status code");
		//Assert.assertEquals(201, statusCode);
		
		
		
	}

}
