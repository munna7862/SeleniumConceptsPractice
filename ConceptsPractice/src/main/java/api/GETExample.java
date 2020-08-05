package api;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GETExample {
	@SuppressWarnings({ "unchecked", "unused" })
	@Test
	public void GetAssetID()
	{
		// Getting API Key -----------------------------------------------------------------------------------------------
		RestAssured.baseURI="https://fxg-fleet-dev.maximo.com/maxrest/oslc/apitoken/create"; 
		RequestSpecification httpRequest = RestAssured.given().auth().preemptive().basic("GPSADAPTER", "maximoCloud0615");
		JSONObject reqparam = new JSONObject();
		reqparam.put("expiration", 60);
		httpRequest.header("Content-Type","application/json");
		httpRequest.header("Authorization","BASIC R1BTQURBUFRFUjogbWF4aW1vQ2xvdWQwNjE1");
		httpRequest.body(reqparam.toJSONString());
		Response response = httpRequest.request(Method.POST);
		String rb = response.getBody().asString();
		String s = rb.substring(11,rb.length()-2);
		System.out.println(rb.substring(11,rb.length()-2));
		
		// Getting Device ID ---------------------------------------------------------------------------------------------
		RestAssured.baseURI="https://fxg-fleet-dev.maximo.com/maxrest/oslc/os"; 
		RequestSpecification httpGetRequest = RestAssured.given().auth().preemptive().basic("GPSADAPTER", "maximoCloud0615");
		httpGetRequest.header("Content-Type","application/json");
		httpGetRequest.header("Authorization","BASIC R1BTQURBUFRFUjogbWF4aW1vQ2xvdWQwNjE1");
		httpGetRequest.header("apikey",s);
		Response getResponse = httpGetRequest.request(Method.GET,"/FXGGPSOS?oslc.where=eq1=\\\"3H3J061S9KT826118\\\"& lean=1");
		String grb = getResponse.getBody().asString();
		System.out.println(grb);
	}
}
