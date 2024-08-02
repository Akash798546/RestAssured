package Bookstore;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GoogleMap {

	@Test
	public void postGoogleMap()
	{
		RestAssured.baseURI="https://rahulshettyacademy.com";
		RequestSpecification req=RestAssured.given();
		req.queryParam("key ", "qaclick123");
		GoogleData gd=new GoogleData();
		gd.setAccuracy("50");
		gd.setName("Peter Parker");
		gd.setPhone_number("+917999999999");
		gd.setAddress("Greater Noida India");
		gd.setLanguage("English");
		gd.setWebsite("www.google.com");
		List<String> mylist=new ArrayList<String>();
		mylist.add("Stationary");
		mylist.add("Food Shop");
		gd.setTypes(mylist);
		Location loc=new Location();
		loc.setLat("-38.427362");
		loc.setLng("33.427362");
		gd.setLocation(loc);
		req.body(gd);
		
		Response res=req.post("/maps/api/place/add/json");
		String body=res.getBody().asPrettyString();
		System.out.println(body);
		System.out.println("The Status code is : "+res.getStatusCode());
		System.out.println("The Status Line is : "+res.getStatusLine());
				
	}
	
}
