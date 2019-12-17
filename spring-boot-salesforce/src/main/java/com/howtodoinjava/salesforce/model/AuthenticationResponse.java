package com.howtodoinjava.salesforce.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
	private String access_token;
	private String instance_url;
	private String token_type;
	private String issued_at;

	@Override
	public String toString() {
		return "AuthenticationResponse [access_token=" + access_token + ", instance_url=" + instance_url
				+ ", token_type=" + token_type + ", issued_at=" + issued_at + "]";
	}
}