package com.ntdquan.fast_food_ecommerce_backend.Model;

public class AuthenticationResponse {
	private String token;
	
	public AuthenticationResponse(String token) {
		this.token = token;
	}
	
	public String getToken() {
		return token;
	}
}
