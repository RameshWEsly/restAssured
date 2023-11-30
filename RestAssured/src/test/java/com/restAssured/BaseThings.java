package com.restAssured;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class BaseThings {

	@BeforeTest
	public void init() {
		RestAssured.baseURI="http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath="student";
	}
	
	@Test
	public void get() {
		given().
		pathParam("id", 2).
		when().get("/{id}").prettyPrint();
	}
}
