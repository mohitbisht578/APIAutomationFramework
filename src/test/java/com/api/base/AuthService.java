package com.api.base;

import java.util.HashMap;
import java.util.Map;

import io.restassured.response.Response;

public class AuthService extends BaseService {

	private static final String BASE_PATH = "/api/auth/";

	public Response login(Object payload) {

		return postRequest(payload, BASE_PATH + "login");
	}

	public Response signUp(Object payload) {

		return postRequest(payload, BASE_PATH + "signup");
	}

	public Response forgotPassword(String email) {

		Map<String, String> payload = new HashMap<>();
		payload.put("email", email);
		return postRequest(payload, BASE_PATH + "forgot-password");
	}

}
