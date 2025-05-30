package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

@Listeners(com.api.listeners.TestListener.class)
public class LoginAPITest {

	@Test(description = "Verify if Login API is working....")
	public void loginTest() {

		LoginRequest loginRequest = new LoginRequest();
		AuthService authService = new AuthService();
		loginRequest.setUsername("TomJerry");
		loginRequest.setPassword("Tom@123");
		Response response = authService.login(loginRequest).then().log().all().extract().response();

		Assert.assertEquals(response.statusCode(), 200);

		LoginResponse loginResponse = response.as(LoginResponse.class);

		Assert.assertNotNull(loginResponse.getToken());
		Assert.assertEquals(loginRequest.getUsername(), loginResponse.getUsername());
	}

}
