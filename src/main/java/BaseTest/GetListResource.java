package BaseTest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class GetListResource {

	
	@Test
	public void getListRes()
	{
		RestAssured.baseURI="https://reqres.in/";
		RequestSpecification spec=RestAssured.given();
		Response resp=spec.request(Method.GET,"api/unknown");
		String body=resp.getBody().asPrettyString();
		System.out.println("The Response body is -----");
		System.out.println(body);
		//for getting all ids we have to use string as it returns List
		String id=resp.jsonPath().getString("data.id");
		System.out.println("The Id is ---"+id);
		//for getting particular id we use int
		int firstId=resp.jsonPath().getInt("data.id[1]");
		System.out.println("The Id is ---"+firstId);
//		Assert.assertEquals(id, 1);
		
	}
}
