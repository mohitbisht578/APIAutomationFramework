package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class AccountCreationTest {
	
	@Test
	public void signUpTest() {
		
		SignUpRequest signUpRequest	= new SignUpRequest().builder()
							.username("John_Doe123")
							.password("John@123")
							.email("Doe_Johm123new@gmail.com")
							.firstName("John")
							.lastName("Doe")
							.mobileNumber("9998765432")
							.build();
		
		AuthService authService = new AuthService();
		
		Response response = authService.signUp(signUpRequest)
					.then()
					.log().all()
					.extract().response();
		
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(response.asString(), "User registered successfully!");
		
	}
	
//	SignUpRequest signUpRequest = new SignUpRequest();
//	signUpRequest.setUsername("JohnDoe");
//	signUpRequest.setPassword("John@123");
//	signUpRequest.setEmail("John123@gmail.com");
//	signUpRequest.setFirstName("John");
//	signUpRequest.setLastName("Doe");
//	signUpRequest.setMobileNumber("99988817867");

}
