package com.api.models.response;

import java.util.List;

import com.api.models.request.LoginRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponse {

	private String token;
	private String type;
	private String id;
	private String username;
	private String email;
	private List<String> roles;
	
}
