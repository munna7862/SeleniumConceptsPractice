package api;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Test
public class PostExample {

	@SuppressWarnings("unchecked")
	public String GenerateAPIKey()
	{
		// API endpoint URI 
		RestAssured.baseURI="https://fxg-fleet-dev.maximo.com/maxrest/oslc/apitoken/create";
		
		// Object for Request and giving Basic Authentication 
		RequestSpecification httpRequest = RestAssured.given().auth().preemptive().basic("GPSADAPTER", "maximoCloud0615");
		
		// Creating JSON object to write the raw data 
		JSONObject reqparam = new JSONObject();
		
		// Raw Data
		reqparam.put("expiration", 60);
		
		// Headers
		httpRequest.header("Content-Type","application/json");
		httpRequest.header("Authorization","BASIC R1BTQURBUFRFUjogbWF4aW1vQ2xvdWQwNjE1");
		
		httpRequest.body(reqparam.toJSONString());
		
		// Creating Response object
		Response response = httpRequest.request(Method.POST);
		String rb = response.getBody().asString();
		int statuscode = response.getStatusCode();
		System.out.println("Status code is: "+statuscode);
		Assert.assertEquals(statuscode, 200);
		String statusline = response.getStatusLine();
		System.out.println("Status Line is: "+statusline);
		System.out.println("Response is: "+rb);
		System.out.println(rb.substring(11,rb.length()-2));
		return rb.substring(11,rb.length()-2);
	}
}
