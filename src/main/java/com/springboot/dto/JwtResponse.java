package com.springboot.dto;

public class JwtResponse {
	private String token;
	private String rol;

	public JwtResponse() {
		// TODO Auto-generated constructor stub
	}

	public JwtResponse(String token, String rol) {
		this.token = token;
		this.rol = rol;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

}