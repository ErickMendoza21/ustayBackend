package com.springboot.entity;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int usuario_id;
	private String nombre;
	private String apellidoPa;
	private String apellidoMa;

	@Column(nullable = false, unique = true)

	private String username;
	private String password;

	private String verificationCode; // Almacenará el código enviado al email
	private LocalDateTime verificationCodeExpiryDate; // Almacenará la fecha de expiración del código
	private boolean enabled = false; // Indica si la cuenta está verificada (por defecto false)

	@ManyToOne
	@JoinColumn(name = "rol_id", nullable = false)
	private Rol rol;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Token> token;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Favorito> favorito;

	public Usuario() {

	}

	public Usuario(int usuario_id, String nombre, String apellidoPa, String apellidoMa, String username,
			String password, String verificationCode, LocalDateTime verificationCodeExpiryDate, boolean enabled,
			Rol rol) {
		this.usuario_id = usuario_id;
		this.nombre = nombre;
		this.apellidoPa = apellidoPa;
		this.apellidoMa = apellidoMa;
		this.username = username;
		this.password = password;
		this.verificationCode = verificationCode;
		this.verificationCodeExpiryDate = verificationCodeExpiryDate;
		this.enabled = enabled;
		this.rol = rol;
	}

	public int getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
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

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public LocalDateTime getVerificationCodeExpiryDate() {
		return verificationCodeExpiryDate;
	}

	public void setVerificationCodeExpiryDate(LocalDateTime verificationCodeExpiryDate) {
		this.verificationCodeExpiryDate = verificationCodeExpiryDate;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

}