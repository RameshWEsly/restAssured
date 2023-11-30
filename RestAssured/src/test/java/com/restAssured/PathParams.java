package com.restAssured;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PathParams {
	
	
	

	@Test
	public void pathParams() {
		RequestSpecification req = RestAssured.given().pathParam("id", 1);
		//pathparams(map) pathParams("","","","");
		Response response = req.when().get("http://localhost:8080/student/li/{id}");
		response.then().statusCode(200);
		response.prettyPrint();
	}
}
