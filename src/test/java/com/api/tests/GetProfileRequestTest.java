package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class GetProfileRequestTest {

	@Test
	public void getProfileTest() {

		LoginRequest loginRequest = new LoginRequest();
		AuthService authService = new AuthService();
		loginRequest.setUsername("TomJerry");
		loginRequest.setPassword("Tom@123");

		Response response = authService.login(loginRequest);

		LoginResponse loginResponse = response.as(LoginResponse.class);
		String token = loginResponse.getToken();

		UserManagementService userManagementService = new UserManagementService();

		Response resp = userManagementService.getProfile(token).then().log().all().extract().response();

		UserProfileResponse userProfileResponse = resp.as(UserProfileResponse.class);

		Assert.assertEquals(resp.statusCode(), 200);
		Assert.assertNotNull(userProfileResponse.getId());
		Assert.assertEquals(loginRequest.getUsername(), userProfileResponse.getUsername());
		Assert.assertEquals(userProfileResponse.getEmail(), "Tom123@gmail.com");
	}

}
