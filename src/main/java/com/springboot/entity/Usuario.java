package com.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int usuario_id;
	String nombre;
	String apellido_pa;
	String apellido_ma;
	String correo_electronico;
	String contraseña;

	@ManyToOne
	@JoinColumn(name = "rol_id", nullable = false)
	private Rol rol;

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Usuario(int usuario_id, String nombre, String apellido_pa, String apellido_ma, String correo_electronico,
			String contraseña, Rol rol) {
		this.usuario_id = usuario_id;
		this.nombre = nombre;
		this.apellido_pa = apellido_pa;
		this.apellido_ma = apellido_ma;
		this.correo_electronico = correo_electronico;
		this.contraseña = contraseña;
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

	public String getApellido_pa() {
		return apellido_pa;
	}

	public void setApellido_pa(String apellido_pa) {
		this.apellido_pa = apellido_pa;
	}

	public String getApellido_ma() {
		return apellido_ma;
	}

	public void setApellido_ma(String apellido_ma) {
		this.apellido_ma = apellido_ma;
	}

	public String getCorreo_electronico() {
		return correo_electronico;
	}

	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

}
