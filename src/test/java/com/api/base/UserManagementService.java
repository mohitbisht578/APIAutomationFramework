package com.api.base;

import io.restassured.response.Response;

public class UserManagementService extends BaseService {

	private static final String BASE_PATH = "/api/users/";

	public Response getProfile(String token) {

		setAuthToken(token);
		return getRequest(BASE_PATH + "profile");
	}

	public Response updateProfile(String token, Object payload) {
		setAuthToken(token);
		return putRequest(payload, BASE_PATH + "profile");
	}
}
