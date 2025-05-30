package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class UpdateProfileTest {

	@Test
	public void updateProfileTest() {

		LoginRequest loginRequest = new LoginRequest();
		AuthService authService = new AuthService();
		loginRequest.setUsername("TomJerry");
		loginRequest.setPassword("Tom@123");

		Response response = authService.login(loginRequest);

		LoginResponse loginResponse = response.as(LoginResponse.class);
		String token = loginResponse.getToken();
		System.out.println(token);

		ProfileRequest profileRequest = ProfileRequest.builder()
				.firstName("David")
				.lastName("Lane")
				.email("David1234@gmail.com")
				.mobileNumber("9871234560")
				.build();

		UserManagementService userManagementService = new UserManagementService();

		Response resp = userManagementService.updateProfile(token, profileRequest)
				.then().log().all()
				.extract()
				.response();
		
		UserProfileResponse userResponse = resp.as(UserProfileResponse.class);
		
		Assert.assertNotNull(userResponse.getId());
		Assert.assertEquals(profileRequest.getFirstName(), userResponse.getFirstName());
		Assert.assertEquals(profileRequest.getLastName(), userResponse.getLastName());
		Assert.assertEquals(profileRequest.getEmail(), userResponse.getEmail());
		Assert.assertEquals(profileRequest.getMobileNumber(), userResponse.getMobileNumber());
		
		System.out.println("****************************************");
		Response resp1 = userManagementService.getProfile(token).then().log().all().extract().response();
		UserProfileResponse userProfileResponse = resp1.as(UserProfileResponse.class);

		Assert.assertEquals(resp.statusCode(), 200);
		Assert.assertEquals(userProfileResponse.getFirstName(), userResponse.getFirstName());
		Assert.assertEquals(userProfileResponse.getLastName(), userResponse.getLastName());
		Assert.assertEquals(userProfileResponse.getEmail(), userResponse.getEmail());
		Assert.assertEquals(userProfileResponse.getMobileNumber(), userResponse.getMobileNumber());
	}
}
