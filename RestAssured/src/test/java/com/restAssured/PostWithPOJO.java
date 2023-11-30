package com.restAssured;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class PostWithPOJO {

	@Test
	public void pojo() {
		StudentPOJO pojo = new StudentPOJO();
		Faker fake = new Faker();
		pojo.setFirstName(fake.name().firstName());
		pojo.setLastName(fake.name().lastName());
		pojo.setEmail(fake.internet().emailAddress());
		pojo.setProgramme("MEC");
		List<String> course = new ArrayList<String>();
		course.add("abcd");
		course.add("efgh");
		pojo.setCourses(course);
		
		Response response = given().contentType(ContentType.JSON).when().body(pojo).post("http://localhost:8080/student");
		response.prettyPrint();
		response.then().statusCode(201);
	}
}
