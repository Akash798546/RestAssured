package BaseTest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class DeleteRequest extends BaseTest {
	int id = 2;

	@Test
	public void getDeleteRequest() {
		test.info("Getting the Base url");
		RestAssured.baseURI = "https://reqres.in/";
		RequestSpecification req = RestAssured.given();
		test.info("Given the Header");
		req.header("Content-Type", "application/json");
		Response res = req.delete("api/users/" + id);
		String resbody = res.getBody().asPrettyString();
		test.info("Getting the response body");
		System.out.println("The response body is - " + resbody);
		int Statuscode = res.getStatusCode();
		System.out.println("The Status code is - "+Statuscode);
		test.info("Verifying status code");
		Assert.assertEquals(204, Statuscode);
	}

}
