package BaseTest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import net.minidev.json.JSONObject;


public class PostRegistrationSuccessfull {
	
	@Test
	public void postRegistration()
	{
		RestAssured.baseURI="https://reqres.in/";
		RequestSpecification rs=RestAssured.given();
		rs.header("Content-Type","application/json");
		
		JSONObject jo=new JSONObject();
		jo.put("email","eve.holt@reqres.in");
		jo.put("password","pistol");
		
		RequestSpecification resb=rs.body(jo.toJSONString());
//		rs.body("{\r\n"
//				+ "    \"email\": \"eve.holt@reqres.in\",\r\n"
//				+ "    \"password\": \"pistol\"\r\n"
//				+ "}");
		Response res=rs.post("/api/register");
		String resbody=res.getBody().asPrettyString();
		System.out.println(resbody);
		int id=res.jsonPath().getInt("id");
		System.out.println("The Id is --- "+id);
		Assert.assertEquals(4, id);
		int statuscode=res.getStatusCode();
		System.out.println("The status code is -- "+statuscode);
		Assert.assertEquals(200, statuscode);
	}

}
