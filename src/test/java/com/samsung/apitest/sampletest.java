package com.samsung.apitest;

import org.junit.Before;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class sampletest {
	
	@Before
	public void setUp() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		
	}
	
	@Test
	public void gogotest() {
		Response response = RestAssured.given().contentType(ContentType.JSON)
		.when().get("/test").then().extract().response();
		
		System.out.println("response : " + response.prettyPrint());
		
	}

}
