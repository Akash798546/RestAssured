package Bookstore;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CleintAuthorization {
	
	
	@Test
	public void getDetailsWithAuth()
	{
		RestAssured.baseURI="https://rahulshettyacademy.com/";
		RequestSpecification reqs=RestAssured.given();
		reqs.formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com");
		reqs.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W");
		Response res=reqs.post("oauthapi/oauth2/resourceOwner/token");
		String resbody=res.getBody().asPrettyString();
		System.out.println(resbody);
		String Token=res.jsonPath().getString("access_token");
		System.out.println("Token is : "+Token);
		System.out.println("The status code for Authentication Api is : "+res.getStatusCode());
	System.out.println("***************Getting Details*******************************");
		RestAssured.baseURI="https://rahulshettyacademy.com/";
		RequestSpecification rs=RestAssured.given();
		rs.queryParam("access_token", Token).expect().defaultParser(Parser.JSON);
		Response response=rs.get("/oauthapi/getCourseDetails");
		String body=response.getBody().asPrettyString();
		System.out.println(body);
		System.out.println("The status code for Getting details Api is : "+response.getStatusCode());
		GetCourse Gc=response.as(GetCourse.class);
		System.out.println("The Instructor name is : "+Gc.getInstructor());
		List<Api> apiList=Gc.getCourses().getApi();
		boolean courseFound = false;
		for (Api api : apiList) {
            System.out.println("Course Title: " + api.getCourseTitle());
            System.out.println("Course Price: " + api.getPrice());
            
            if (api.getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing")) {
                System.out.println("The Price of the Course is: " + api.getPrice());
                courseFound = true;
                break; // Stop once we find the course
            }
        }
        if (!courseFound) {
            System.out.println("Course with title 'Rest Assured Automation using Java' not found.");
        }
 
	
	
	}

}
