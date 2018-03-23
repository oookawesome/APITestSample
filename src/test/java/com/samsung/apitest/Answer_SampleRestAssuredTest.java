package com.samsung.apitest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

@Ignore
public class Answer_SampleRestAssuredTest {
	
	@Before
	public void setUp() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
		
	}
	
	@Test
	public void getStudentTest() {
		given()
			.pathParam("studentId", 123)
		.when()
			.get("/student/{studentId}")
		.then()
			.statusCode(200)
			.body("name", is("Hong Gil Dong"))
			.body("id", is(123))
			.body("scores[0].subject", is("Korean"))
			.body("scores[1].point", is(85))
		.extract().response();
		
	}
	
	@Test
	public void getStudentNotFoundExceptionTest() {
		given()
			.pathParam("studentId", 888)
		.when()
			.get("/student/{studentId}")
		.then()
			.statusCode(404)
			.body("message", is("student is not exist!"))
		.extract().response();
		
	}
	
	@Test
	public void postStudentTest() {
		Map<String, Object> reqBody = new HashMap<String,Object>();
		reqBody.put("name", "Jang Min Seok");
		reqBody.put("id", 678);
		Map<String, Object> scores = new HashMap<String,Object>();
		scores.put("subject", "Math");
		scores.put("point", 50);
		reqBody.put("scores", Arrays.asList(scores));
		
		Response response = 
		given()
			.contentType(ContentType.JSON)
			.body(reqBody)
		.when()
			.post("/student")
		.then()
			.statusCode(201)
			.body("student.name", is("Jang Min Seok"))
			.body("student.id", is(678))
			.body("student.scores[0].subject", is("Math"))
			.body("student.scores[0].point", is(50))
		.extract().response();
		
		String message = response.jsonPath().getString("message");
		assertThat(message).isEqualTo("Success to create student!");
		
	}
}
