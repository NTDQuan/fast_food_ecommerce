package com.ntdquan.fast_food_ecommerce_backend.DTO;

public class RefreshTokenRequest {
	private String token;

	public RefreshTokenRequest(String token) {
		super();
		this.token = token;
	}

	public RefreshTokenRequest() {
		super();
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
