package com.api.tests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class LoginTest {
	

	@Test(description = "Verify if Login API is working....")
	public void loginTest() {
		
		Response response = given().log().all()
		.baseUri("http://64.227.160.186:8080")
		.header("accept", "application/json")
		.header("Content-Type", "application/json")
		.body("{\n"
				+ "  \"username\": \"TomJerry\",\n"
				+ "  \"password\": \"Tom@123\"\n"
				+ "}")
		.when()
		.post("/api/auth/login");
		
		Assert.assertEquals(response.statusCode(), 200);
	}
//	
	@Test
	public void accountSIgnup() {
		
		String requestBody = "{\n"
				+ "  \"username\": \"PeterJerry\",\n"
				+ "  \"password\": \"Peter@123\",\n"
				+ "  \"email\": \"PeterJerry123@gmail.com\",\n"
				+ "  \"firstName\": \"Tom\",\n"
				+ "  \"lastName\": \"Jerry\",\n"
				+ "  \"mobileNumber\": \"3333127288\"\n"
				+ "}";
		
		RestAssured.baseURI = "http://64.227.160.186:8080";
		RestAssured.given().log().all()
		.header("accept", "application/json")
		.header("Content-Type", "application/json")
		.body(requestBody)
		.when()
		.post("/api/auth/signup")
		.then().log().all()
		.assertThat()
		.statusCode(200);
		
	}

}
