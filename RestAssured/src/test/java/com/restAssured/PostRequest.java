package com.restAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequest {
	
	
	@Test
	public void postRequest() {
		RestAssured.baseURI="http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "student";
		RequestSpecification request = RestAssured.given();
		Response  response = request.when().contentType(ContentType.JSON).when()
				.body("{\"firstName\":\"Ram\",\"lastName\":\"Hedley\",\"email\":\"jesusramesh10@gmai.co\",\"programme\":\"Criminology\",\"courses\":[\"Criminal Mind\",\"Gender, Crime and Justice \",\"Philosophy of Law \"]}").post();
		response.prettyPrint();
		response.then().statusCode(201);
	}

}
