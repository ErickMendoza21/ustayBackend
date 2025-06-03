package com.springboot.dto;

public class RegisterRequest {
	private String nombre;
	private String apellidoPa;
	private String apellidoMa;
	private String username;
	private String password;

	public RegisterRequest() {
		// TODO Auto-generated constructor stub
	}

	public RegisterRequest(String nombre, String apellidoPa, String apellidoMa, String username, String password) {
		this.nombre = nombre;
		this.apellidoPa = apellidoPa;
		this.apellidoMa = apellidoMa;
		this.username = username;
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPa() {
		return apellidoPa;
	}

	public void setApellidoPa(String apellidoPa) {
		this.apellidoPa = apellidoPa;
	}

	public String getApellidoMa() {
		return apellidoMa;
	}

	public void setApellidoMa(String apellidoMa) {
		this.apellidoMa = apellidoMa;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}