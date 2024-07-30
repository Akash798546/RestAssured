package BaseTest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class GetDelayResponse {

	@Test
	public void getDelay() {

		
		RestAssured.baseURI = "https://reqres.in/";
		RequestSpecification req = RestAssured.given();
		req.queryParam("delay", 3);
		Response res = req.request(Method.GET, "api/users");
		String resbody = res.getBody().asPrettyString();
		System.out.println("The Response body is ----");
		System.out.println(resbody);
		int sc = res.getStatusCode();
		System.out.println("The status code is --- " + sc);
		Assert.assertEquals(200, sc);
		String fname = res.jsonPath().getString("data.first_name[0]");
		String lname = res.jsonPath().getString("data.last_name[0]");
		System.out.println("The name is : " + fname + " " + lname);
		Assert.assertEquals("George", fname);
		Assert.assertEquals("Bluth", lname);
	}

}
