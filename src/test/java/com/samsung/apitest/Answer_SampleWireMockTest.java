package com.samsung.apitest;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@Ignore
public class Answer_SampleWireMockTest {

	@Rule
	public WireMockRule wireMockRule = new WireMockRule(8090);
	
	@Before
	public void setUp() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8090;
		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
		
		wireMockRule.stubFor(delete(urlEqualTo("/student/125"))
				.willReturn(aResponse()
						.withHeader("Content-Type", "application/json")
						.withStatus(200)
						.withBody("{ \"message\" : \"success\" }")));
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
