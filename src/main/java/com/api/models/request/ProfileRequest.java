package com.api.models.request;

import com.api.models.response.UserProfileResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileRequest {
	
	private String firstName;
	private String lastName;
	private String email;
	private String mobileNumber;

}
