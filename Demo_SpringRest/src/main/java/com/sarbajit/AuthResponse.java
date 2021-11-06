package com.sarbajit;

public class AuthResponse {
	private final String token;

	public String getToken() {
		return token;
	}

	public AuthResponse(String token) {
		this.token = token;
	}
}
