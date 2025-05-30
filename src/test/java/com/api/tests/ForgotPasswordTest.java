package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ForgotPasswordTest {

	@Test(description = "Verify if forgot password API is working....")
	public void forgotPasswordTest() {
		
		AuthService authService = new AuthService();
		
		Response response = authService.forgotPassword("Tom123@gmail.com")
				.then().log().all().extract().response();

		Assert.assertEquals(response.statusCode(), 200);

	}


}
