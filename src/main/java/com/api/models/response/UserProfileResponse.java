package com.api.models.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserProfileResponse {

	private int id;
	private String username;
	private String email;
	private String firstName;
	private String lastName;
	private String mobileNumber;
}
