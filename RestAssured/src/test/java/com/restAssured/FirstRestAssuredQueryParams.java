package com.restAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class FirstRestAssuredQueryParams {

	
	
	@Test
	public void getMethod() {
		
		RequestSpecification reqSpecification = RestAssured.given();
		
		Response response = reqSpecification.when().get("http://localhost:8080/student/list");
		 
		ValidatableResponse validatableResponse = response.then();
		validatableResponse.statusCode(200);
		
		
		RestAssured.given()
		.expect().statusCode(200).
		when().get("http://localhost:8080/student/list");
		
		//1
		given().queryParam("programme", "Mechanical Engineering")
		.queryParam("limit", 1)
		.when().get("http://localhost:8080/student/list")
		.prettyPrint();
		
		
		//2
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("programme", "Computer Science");
		given().queryParams(map).when().get("http://localhost:8080/student/list").prettyPrint();
		
	
		given().queryParams("programme", "Law","limit",2).when().get("http://localhost:8080/student/list").prettyPrint();
	}
	
}
