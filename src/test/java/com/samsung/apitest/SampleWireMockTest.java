package com.samsung.apitest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

public class SampleWireMockTest {

	public void setUp() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8090;
		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
	}
	
	@Test
	public void sampleWireMockTest() {

		given()
			.pathParam("studentId", 125)
		.when()
			.delete("/student/{studentId}")
		.then()
			.statusCode(200)
			.body("message", is("success"));	
	}
	
}
